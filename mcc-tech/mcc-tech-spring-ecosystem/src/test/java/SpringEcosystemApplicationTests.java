import cs.matemaster.tech.spring.SpringEcosystemApplication;
import cs.matemaster.tech.spring.dependency_injection.ActivityQueryFacadeImpl;
import cs.matemaster.tech.spring.dependency_injection.SysUserQueryFacadeImpl;
import cs.matemaster.tech.spring.factory.RubikQuery;
import cs.matemaster.tech.spring.factory.RubikQueryFactory;
import cs.matemaster.tech.spring.service.ActivityQueryService;
import cs.matemaster.tech.spring.service.SysUserQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringEcosystemApplication.class)
public class SpringEcosystemApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SysUserQueryFacadeImpl sysUserQueryFacade;

    @Autowired
    private ActivityQueryFacadeImpl activityQueryFacade;

    @Resource(name = "cacheQueryServiceImpl")
    private SysUserQueryService sysUserQueryService1;

    @Autowired
    @Qualifier("cacheQueryServiceImpl")
    private SysUserQueryService sysUserQueryService2;

    @Test
    public void name() throws Exception {
        String name = applicationContext.getClass().getName();
        System.out.println(name);

        if (applicationContext.containsBean("&rubikQueryFactory")) {
            RubikQueryFactory bean = (RubikQueryFactory) applicationContext.getBean("&rubikQueryFactory");
            System.out.println(bean.getObject().hashCode());
            System.out.println(bean.getObject().hashCode());
        }

        System.out.println(applicationContext.getBean(RubikQuery.class).hashCode());
        System.out.println(applicationContext.getBean(RubikQuery.class).hashCode());
    }

    @Test
    public void injection() {
        sysUserQueryFacade.stdOut();
        activityQueryFacade.stdOut();
        System.out.println(sysUserQueryService1.getSysUserList());
        System.out.println(sysUserQueryService2.getSysUserList());
    }

    @Test
    public void beanDefinitionName() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // bean别名
        String alias2 = applicationContext.getBean("alias2", String.class);
        System.out.println(alias2);
    }

}
