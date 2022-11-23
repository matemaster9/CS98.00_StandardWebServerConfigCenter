package cs.matemaster.standardwebserver.common.mapstruct;

import cs.matemaster.standardwebserver.common.model.dto.excel.InterfacePerformanceQuota;
import cs.matemaster.standardwebserver.common.model.dto.excel.InterfacePerformanceQuotaExcelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author matemaster
 */
@Mapper
public interface InterfacePerformanceExcelMapper {

    InterfacePerformanceExcelMapper instance = Mappers.getMapper(InterfacePerformanceExcelMapper.class);

    InterfacePerformanceQuotaExcelDto toExcelDto(InterfacePerformanceQuota quota);
}
