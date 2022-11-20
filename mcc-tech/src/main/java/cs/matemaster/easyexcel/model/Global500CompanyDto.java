package cs.matemaster.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author matemaster
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Global500CompanyDto {

    @ExcelProperty(value = "排名")
    private int rank;

    @ExcelProperty(value = "公司名称")
    private String companyName;

    @ExcelProperty(value = "营收")
    private long income;

    @ExcelProperty(value = "利润")
    private long profit;

    @ExcelProperty(value = "国家")
    private String country;
}
