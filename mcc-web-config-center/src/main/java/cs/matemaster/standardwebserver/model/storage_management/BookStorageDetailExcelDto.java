package cs.matemaster.standardwebserver.model.storage_management;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author matemaster
 */
@Getter
@Builder
public class BookStorageDetailExcelDto {

    private int initStock;

    private int inboundCount;

    private int outboundCount;

    private int balanceStock;

    private int rank;

    private LocalDate date;

    private String bookName;

    private String specifications;

    private BigDecimal inboundPrice;

    private BigDecimal inboundSumAmount;

    private BigDecimal outboundPrice;

    private BigDecimal outboundSumAmount;

    private BigDecimal stockPrice;

    private BigDecimal stockAmount;

    private String remark;
}
