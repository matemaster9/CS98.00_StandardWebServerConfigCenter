package cs.matemaster.standardwebserver.common.util;

import cs.matemaster.standardwebserver.common.constant.MockDataTypeEnum;
import cs.matemaster.standardwebserver.common.model.dto.ActivityDataFunnelDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public final class BusinessDataSimulator {

    public static List<ActivityDataFunnelDto> getMockActivityDataFunnelList(int capacity) {
        return Stream.generate(() -> {
                    ActivityDataFunnelDto activityDataFunnelDto = new ActivityDataFunnelDto();
                    activityDataFunnelDto.setActivityId(BusinessUtil.getBizSequence("ACT"));
                    activityDataFunnelDto.setDate(LocalDate.of(2022, DataFakerUtil.getRandomInteger(9, 11), DataFakerUtil.getRandomInteger(1, 30)));
                    activityDataFunnelDto.setDeptId(DataFakerUtil.getRandomDeptId());
                    activityDataFunnelDto.setDeptName(DataFakerUtil.getRandomValue(MockDataTypeEnum.Job));
                    activityDataFunnelDto.setViewCount(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setParticipantNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setPrizeNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setRecipientNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setYmdPrizeNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setYmdPrizeNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setUseTicketNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setRecipientTicketNumber(DataFakerUtil.getRandomInteger(0, 100));
                    activityDataFunnelDto.setPrizeAmount(DataFakerUtil.getRandomBigDecimal("0.01", "10000.00"));
                    activityDataFunnelDto.setRecipientAmount(DataFakerUtil.getRandomBigDecimal("0.01", "10000.00"));
                    return activityDataFunnelDto;
                }).limit(capacity)
                .collect(Collectors.toList());
    }
}
