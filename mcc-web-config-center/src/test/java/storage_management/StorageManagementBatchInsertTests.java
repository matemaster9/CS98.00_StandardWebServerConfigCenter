package storage_management;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.google.common.base.Stopwatch;
import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.mapper.StorageManagementMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class StorageManagementBatchInsertTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private StorageManagementMapper storageManagementMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * mybatis批处理插入
     */
    @Test
    public void save() {
        List<BookStorageDetailDto> collect = mockData();
        Stopwatch started = Stopwatch.createStarted();
        // 这里使用mybatis api:DefaultSqlSession 它不会参与到 Spring 的事务管理之中。必须手动提交，并关闭
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            System.out.println(sqlSession.getClass().getName());
            StorageManagementMapper mapper = sqlSession.getMapper(StorageManagementMapper.class);
            collect.forEach(mapper::insertStorageDetail);
            sqlSession.commit();
        }
        System.out.println("执行耗时：" + started.stop().elapsed(TimeUnit.SECONDS));
    }

    @Test
    public void batch() {
        List<BookStorageDetailDto> collect = mockData();
        Stopwatch started = Stopwatch.createStarted();
        try (SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH)) {
            StorageManagementMapper mapper = sqlSessionTemplate.getMapper(StorageManagementMapper.class);
            collect.forEach(mapper::insertStorageDetail);
            sqlSessionTemplate.commit();
        }
        System.out.println("执行耗时：" + started.stop().elapsed(TimeUnit.SECONDS));
    }

    /**
     * foreach拼接sql
     */
    @Test
    public void foreachLoop() {
        Stopwatch started = Stopwatch.createStarted();
        storageManagementMapper.insertStorageDetailList(mockData());
        System.out.println("执行耗时：" + started.stop().elapsed(TimeUnit.SECONDS));
    }

    /**
     * 循环插入单条
     */
    @Test
    public void forLoop() {
        Stopwatch started = Stopwatch.createStarted();
        mockData().forEach(storageManagementMapper::insertStorageDetail);
        System.out.println("执行耗时：" + started.stop().elapsed(TimeUnit.SECONDS));
    }

    public List<BookStorageDetailDto> mockData() {
        Book faker = new Faker(Locale.CHINA, ThreadLocalRandom.current()).book();

        return Stream.generate(() -> {
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
                    return storageDetail;
                }).limit(10)
                .collect(Collectors.toList());
    }


    @Test
    public void sqlSessionTemplate() {
        System.out.println(sqlSessionTemplate);
    }
}
