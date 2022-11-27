package cs.matemaster.tech.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.google.common.collect.Maps;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EasyExcelUtil {

    public static <T> List<T> toGenericList(File excel, Class<T> tClass) {
        List<T> genericList = new ArrayList<>();
        EasyExcelFactory.read(excel, tClass, new GenericReadListener<>(genericList)).sheet().doRead();
        return genericList;
    }

    public static void exportExcel(HttpServletResponse response, String filename, List<List<String>> head, List<List<Object>> data) throws IOException {
        String encodeFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + encodeFilename + ".xlsx");

        // todo: 自定义excel列表长宽度

        EasyExcelFactory.write(response.getOutputStream())
                .head(head)
                .registerWriteHandler(new AdaptiveColumnWidthStyle())
                .sheet().doWrite(data);
    }

    // todo: 自定义excel列表长宽度
    private static class AdaptiveColumnWidthStyle extends AbstractColumnWidthStyleStrategy {

        private static final Map<Integer, Map<Integer, Integer>> SheetColumnWithMap = Maps.newHashMapWithExpectedSize(16);

        @Override
        protected void setColumnWidth(CellWriteHandlerContext context) {
            if (BusinessUtil.isFalse(context.getHead()) && CollectionUtils.isNotEmpty(context.getCellDataList())) {
                return;
            }
            WriteSheetHolder writeSheetHolder = context.getWriteSheetHolder();
            Map<Integer, Integer> columnWithMap = SheetColumnWithMap.computeIfAbsent(writeSheetHolder.getSheetNo(), k -> Maps.newHashMap());

        }

        @Override
        protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
            if (BusinessUtil.isFalse(isHead) && CollectionUtils.isNotEmpty(cellDataList)) {
                return;
            }
            Map<Integer, Integer> columnWithMap = SheetColumnWithMap.computeIfAbsent(writeSheetHolder.getSheetNo(), k -> Maps.newHashMap());

        }

        private int columnWidth(List<WriteCellData<?>> data, Cell cell, boolean isHead) {
            if (isHead) {
                return cell.getStringCellValue().length();
            }

            WriteCellData<?> writeCellData = data.get(0);
            CellDataTypeEnum type = writeCellData.getType();
            switch (type) {
                case STRING:
                    return writeCellData.getStringValue().getBytes(StandardCharsets.UTF_8).length;
                default:
                    return String.valueOf(writeCellData.getData()).getBytes(StandardCharsets.UTF_8).length;
            }
        }
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
