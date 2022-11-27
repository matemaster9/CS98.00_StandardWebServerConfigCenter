import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import cs.matemaster.tech.easyexcel.EasyExcelUtil;
import cs.matemaster.tech.easyexcel.PathUtil;
import cs.matemaster.tech.easyexcel.model.Global500CompanyDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matemaster
 */
public class EasyExcelRedaTest {

    @Test
    public void test() {
        System.out.println(PathUtil.getClasspath());
    }

    @Test
    public void test1() {
        String filename = "/Users/matemaster/Develop/GitHub项目/CS98.00_StandardWebServerConfigCenter/mcc-tech/target/test-classes/全球500强.xlsx";
        File file = Paths.get(filename).toFile();

        List<Global500CompanyDto> result = new ArrayList<>();
        EasyExcel.read(file, Global500CompanyDto.class, new ReadListener<Global500CompanyDto>() {
            @Override
            public void invoke(Global500CompanyDto data, AnalysisContext analysisContext) {
                result.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();

        result.forEach(System.out::println);
    }

    @Test
    public void test3() {
        String path = "/Users/matemaster/Develop/GitHub项目/CS98.00_StandardWebServerConfigCenter/mcc-tech/target/test-classes/全球500强.xlsx";

        List<Global500CompanyDto> result = new ArrayList<>();
        EasyExcel.read(path, Global500CompanyDto.class, new ReadListener<Global500CompanyDto>() {
            @Override
            public void invoke(Global500CompanyDto data, AnalysisContext analysisContext) {
                result.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();

        System.out.println(JsonUtil.serialize(result));
    }

    @Test
    public void test1_v2() {
        String filename = "/Users/matemaster/Develop/GitHub项目/CS98.00_StandardWebServerConfigCenter/mcc-tech/target/test-classes/全球500强.xlsx";
        File file = Paths.get(filename).toFile();

        List<Global500CompanyDto> result = EasyExcelUtil.toGenericList(file, Global500CompanyDto.class);
        result.forEach(System.out::println);
    }
}
