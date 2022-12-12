import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class NamingBeanTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void name() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
