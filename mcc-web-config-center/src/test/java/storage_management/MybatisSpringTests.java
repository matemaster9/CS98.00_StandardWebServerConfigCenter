package storage_management;

import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class MybatisSpringTests {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void name() {
        System.out.println(sqlSession.getClass().getName());
        System.out.println(sqlSessionFactory.getClass().getName());
    }
}
