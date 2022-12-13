package cs.matemaster.standardwebserver.mapper;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author matemaster
 */
public interface StorageManagementMapper {

    @Insert({"insert into book_storage_detail " +
            "(book_name, specifications, original_inventory, inbound_count, inbound_price, outbound_count, outbound_price, " +
            " balance_inventory, stock_price, remark) " +
            "values " +
            "(#{item.bookName},#{item.specifications},#{item.originalInventory},#{item.inboundCount},#{item.inboundPrice}," +
            "#{item.outboundCount},#{item.outboundPrice},#{item.balanceInventory},#{item.stockPrice},#{item.remark})"})
    int insertStorageDetail(@Param("item") BookStorageDetailDto bookStorageDetail);

    @Insert({"<script> " +
            "insert into book_storage_detail " +
            "(book_name, specifications, original_inventory, inbound_count, inbound_price, outbound_count, outbound_price, " +
            " balance_inventory, stock_price, remark) " +
            "values " +
            "<foreach collection = 'list' item = 'item' separator = ','> " +
            "(#{item.bookName},#{item.specifications},#{item.originalInventory},#{item.inboundCount},#{item.inboundPrice}," +
            "#{item.outboundCount},#{item.outboundPrice},#{item.balanceInventory},#{item.stockPrice},#{item.remark})" +
            "</foreach>" +
            "</script>"})
    int insertStorageDetailList(@Param("list") List<BookStorageDetailDto> bookStorageDetailList);
}
