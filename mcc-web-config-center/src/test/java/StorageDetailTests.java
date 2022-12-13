import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public class StorageDetailTests {


    @Test
    public void mock() {
        Book faker = new Faker(Locale.CHINA, ThreadLocalRandom.current()).book();
        BookStorageDetailDto storageDetail = new BookStorageDetailDto();
        storageDetail.setBookName(faker.title());
        storageDetail.setSpecifications(faker.genre());
        storageDetail.setOriginalInventory(100);
        storageDetail.setInboundCount(500);
        storageDetail.setInboundPrice(BigDecimal.valueOf(300));
        storageDetail.setOutboundCount(200);
        storageDetail.setOutboundPrice(BigDecimal.valueOf(100));
        storageDetail.setBalanceInventory(400);
        storageDetail.setStockPrice(BigDecimal.valueOf(80));
        storageDetail.setRemark(faker.publisher());
        System.out.println(storageDetail);
    }
}
