package cs.matemaster.tech.config.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;

/**
 * @author matemaster
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {



    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        System.out.println("constructor...");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("starting...");
    }
}
