package cs.matemaster.standardwebserver.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author matemaster
 */
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 去除StringHttpMessageConverter，解决接口统一过程中，返回string导致的类型转换错误
        converters.removeIf(converter -> converter.getClass() == StringHttpMessageConverter.class);

        // 调整httpMessage转换器顺序
        // converters.add(0, new MappingJackson2HttpMessageConverter());
    }
}
