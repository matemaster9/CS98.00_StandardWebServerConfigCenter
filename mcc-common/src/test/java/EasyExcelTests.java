import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import cs.matemaster.standardwebserver.common.mapstruct.InterfacePerformanceExcelMapper;
import cs.matemaster.standardwebserver.common.model.dto.excel.InterfacePerformanceQuota;
import cs.matemaster.standardwebserver.common.model.dto.excel.InterfacePerformanceQuotaExcelDto;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public class EasyExcelTests {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    @Test
    public void test1() {
        List<InterfacePerformanceQuotaExcelDto> interfacePerformanceQuotaList = Stream
                .generate(() -> InterfacePerformanceQuota
                        .builder()
                        .path("/activity/config")
                        .protocol("http")
                        .hps(random.nextLong(100_000, 1_000_000))
                        .tps(random.nextLong(100_000, 1_000_000))
                        .qps(random.nextLong(100_000, 1_000_000))
                        .responseTime(random.nextLong(200, 500))
                        .virtualUser(random.nextInt(1_000_000))
                        .build())
                .map(InterfacePerformanceExcelMapper.instance::toExcelDto)
                .limit(10000)
                .collect(Collectors.toList());

        File file = Paths.get("/Users/matemaster/Develop/GitHub项目/CS98.00_StandardWebServerConfigCenter/mcc-common/src/main/resources/接口性能信息.xlsx")
                .toFile();

        EasyExcelFactory
                .write(file, InterfacePerformanceQuotaExcelDto.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet()
                .doWrite(interfacePerformanceQuotaList);
    }

    @Test
    public void test2() {
        List<InterfacePerformanceQuotaExcelDto> interfacePerformanceQuotaList = Stream
                .generate(() -> InterfacePerformanceQuota
                        .builder()
                        .path("/activity/config")
                        .protocol("http")
                        .hps(random.nextLong(100_000, 1_000_000))
                        .tps(random.nextLong(100_000, 1_000_000))
                        .qps(random.nextLong(100_000, 1_000_000))
                        .responseTime(random.nextLong(200, 500))
                        .virtualUser(random.nextInt(1_000_000))
                        .build())
                .map(InterfacePerformanceExcelMapper.instance::toExcelDto)
                .limit(10000)
                .collect(Collectors.toList());
        interfacePerformanceQuotaList.forEach(System.out::println);
    }
}
