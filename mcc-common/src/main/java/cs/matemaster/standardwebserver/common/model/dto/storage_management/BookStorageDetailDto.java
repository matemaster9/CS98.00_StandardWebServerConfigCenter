package cs.matemaster.standardwebserver.common.model.dto.storage_management;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Schema(name = "书籍库存明细")
public class BookStorageDetailDto {

    @Schema(description = "书名")
    private String bookName;

    @Schema(description = "规格型号")
    private String specifications;

    @Schema(description = "初始库存")
    private int originalInventory;

    @Schema(description = "入库数量")
    private int inboundCount;

    @Schema(description = "入库单价")
    private BigDecimal inboundPrice;

    @Schema(description = "出库数量")
    private int outboundCount;

    @Schema(description = "出库单价")
    private BigDecimal outboundPrice;

    @Schema(description = "剩余库存")
    private int balanceInventory;

    @Schema(description = "库存单价")
    private BigDecimal stockPrice;

    @Schema(description = "备注")
    private String remark;
}
