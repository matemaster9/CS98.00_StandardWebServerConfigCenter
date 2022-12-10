import cs.matemaster.tech.config.ConfigApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author matemaster
 */
@SpringBootTest(classes = ConfigApplication.class)
public class ConfigAppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void yaml() {
        YamlMapFactoryBean yamlMap = new YamlMapFactoryBean();
        yamlMap.setResources(new ClassPathResource("configurable.yml"));
        yamlMap.getObject();

        YamlPropertiesFactoryBean yamlProperties = new YamlPropertiesFactoryBean();
        yamlProperties.setResources(new ClassPathResource("configurable.yml"));
        yamlProperties.getObject();
    }
}
