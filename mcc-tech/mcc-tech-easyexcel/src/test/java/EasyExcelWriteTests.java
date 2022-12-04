import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import cs.matemaster.tech.easyexcel.model.ActivityDto;
import cs.matemaster.tech.easyexcel.util.MockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
@Slf4j
public class EasyExcelWriteTests {

    @Test
    public void test() {
        List<ActivityDto> activityList = Stream.generate(() -> {
                    ActivityDto activity = new ActivityDto();
                    activity.setActivityId(MockUtil.getUniqueId("ACT"));
                    activity.setActivityName(MockUtil.getRandomString(10));
                    activity.setActivityViewCount(MockUtil.random.nextInt(0, 100000));
                    activity.setActivityVisitCount(MockUtil.random.nextInt(0, 100000));
                    activity.setActivityPrizeCount(MockUtil.random.nextInt(0, 100000));
                    activity.setActivityParticipateCount(MockUtil.random.nextInt(0, 100000));
                    activity.setActivityPrizeAmount(BigDecimal.valueOf(MockUtil.random.nextDouble(0, 100000)));
                    return activity;
                }).limit(10000)
                .collect(Collectors.toList());


        String filename = "/Users/matemaster/Develop/GitHub项目/CS98.00_StandardWebServerConfigCenter/mcc-tech/mcc-tech-easyexcel/src/main/resources/活动数据.xlsx";

        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("活动编号"));
        head.add(Collections.singletonList("活动名称"));
        head.add(Collections.singletonList("活动访问次数"));
        head.add(Collections.singletonList("活动点击次数"));
        head.add(Collections.singletonList("活动参与次数"));
        head.add(Collections.singletonList("活动发奖次数"));
        head.add(Collections.singletonList("活动发奖金额"));

        long now = System.currentTimeMillis();
        EasyExcelFactory
                .write(filename)
                .head(head)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet()
                .doWrite(activityList);
        log.info("写入Excel数据量：" + activityList.size());
        log.info("写入Excel耗时：" + (System.currentTimeMillis() - now) + "毫秒");
    }
}
