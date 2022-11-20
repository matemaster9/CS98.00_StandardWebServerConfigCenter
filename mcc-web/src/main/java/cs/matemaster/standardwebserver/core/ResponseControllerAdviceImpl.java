package cs.matemaster.standardwebserver.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.swagger.v3.core.util.Json;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author matemaster
 */
@ControllerAdvice
public class ResponseControllerAdviceImpl implements ResponseBodyAdvice<Object> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        GetMapping get = methodParameter.getMethodAnnotation(GetMapping.class);
        PostMapping post = methodParameter.getMethodAnnotation(PostMapping.class);
        PutMapping put = methodParameter.getMethodAnnotation(PutMapping.class);
        DeleteMapping delete = methodParameter.getMethodAnnotation(DeleteMapping.class);

        String[] methods = new String[0];
        if (get != null) {
            methods = get.value();
        }
        if (post != null) {
            methods = post.value();
        }
        if (put != null) {
            methods = put.value();
        }
        if (delete != null) {
            methods = delete.value();
        }

        return ArrayUtil.isNotEmpty(methods);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 保证后端统一接口返回操作 不影响 swagger.json
        Method method = methodParameter.getMethod();
        if (method != null && "openapiJson".equals(method.getName())) {
            return data;
        }

        // 避免返回String类型报错
        if (data instanceof String) {
            try {
                return objectMapper.writeValueAsString(new SuccessTip<>((String) data));
            } catch (JsonProcessingException ignore) {

            }
        }
        return new SuccessTip<>(data);
    }
}
