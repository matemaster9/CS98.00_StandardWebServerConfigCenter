package cs.matemaster.standardwebserver.app.facade;

import com.google.common.collect.Lists;
import cs.matemaster.standardwebserver.common.model.dto.ActivityDataFunnelDto;
import cs.matemaster.standardwebserver.common.util.BusinessDataSimulator;
import cs.matemaster.standardwebserver.common.util.EasyExcelUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Component
public class ActivityDataFunnelFacadeImpl implements ActivityDataFunnelFacade {

    @Override
    @SneakyThrows
    public void export() {
        List<ActivityDataFunnelDto> activityDataFunnels = BusinessDataSimulator.getMockActivityDataFunnelList(210_000);
        List<List<String>> columnList = Lists.newArrayList();
        columnList.add(Collections.singletonList("活动编号"));
        columnList.add(Collections.singletonList("日期"));
        columnList.add(Collections.singletonList("部门名称"));
        columnList.add(Collections.singletonList("访问人次"));
        columnList.add(Collections.singletonList("参与人次"));
        columnList.add(Collections.singletonList("中奖人次"));
        columnList.add(Collections.singletonList("领奖人次"));
        columnList.add(Collections.singletonList("羊毛党参与人次"));
        columnList.add(Collections.singletonList("羊毛党领奖人次"));
        columnList.add(Collections.singletonList("领券人数"));
        columnList.add(Collections.singletonList("用券人数"));
        columnList.add(Collections.singletonList("中奖金额"));
        columnList.add(Collections.singletonList("领奖金额"));

        List<List<Object>> data = activityDataFunnels.parallelStream().map(item -> {
            List<Object> dataList = Lists.newArrayList();
            dataList.add(item.getActivityId());
            dataList.add(item.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            dataList.add(item.getDeptName());
            dataList.add(item.getViewCount());
            dataList.add(item.getParticipantNumber());
            dataList.add(item.getPrizeNumber());
            dataList.add(item.getRecipientNumber());
            dataList.add(item.getYmdParticipantNumber());
            dataList.add(item.getYmdPrizeNumber());
            dataList.add(item.getUseTicketNumber());
            dataList.add(item.getRecipientTicketNumber());
            dataList.add(item.getPrizeAmount());
            dataList.add(item.getRecipientAmount());
            return dataList;
        }).collect(Collectors.toList());

        EasyExcelUtil.exportExcelInMemory("活动数据漏斗12W模拟测试", columnList, data);
    }
}
