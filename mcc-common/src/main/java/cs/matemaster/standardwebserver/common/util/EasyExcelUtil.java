package cs.matemaster.standardwebserver.common.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author matemaster
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EasyExcelUtil {

    public static <T> List<T> toGenericList(InputStream excel, Class<T> tClass) {
        List<T> genericList = new ArrayList<>();
        EasyExcelFactory.read(excel, tClass, new GenericReadListener<>(genericList)).sheet().doRead();
        return genericList;
    }

    public static void exportExcel(String filename, List<List<String>> head, List<List<Object>> data) throws IOException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return;
        }

        HttpServletResponse response = requestAttributes.getResponse();
        if (Objects.isNull(response)) {
            return;
        }
        String encodeFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + encodeFilename + ".xlsx");

        EasyExcelFactory
                .write(response.getOutputStream())
                .head(head)
                .sheet()
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(data);
    }

    @AllArgsConstructor
    private static class GenericReadListener<T> implements ReadListener<T> {
        private final List<T> dataList;

        @Override
        public void invoke(T t, AnalysisContext analysisContext) {
            dataList.add(t);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            // ignore
        }
    }
}
