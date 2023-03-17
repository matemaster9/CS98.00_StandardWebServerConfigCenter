package cs.matemaster.rabbit_book.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author matemaster
 */
@Slf4j
@Component
public class RabbitLifeCycleBean implements InitializingBean, DisposableBean {


    @Override
    public void destroy() throws Exception {
        log.info("implements DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("implements InitializingBean");
    }

    @PostConstruct
    public void startup() {
        log.info("@PostConstruct");
    }

    @PreDestroy
    public void shutdown() {
        log.info("@PreDestroy");
    }

    @Bean(initMethod = "beanAnnotationInitMethod", destroyMethod = "beanAnnotationDestroyMethod")
    public RabbitLifeCycleBean cycleBean() {
        return new RabbitLifeCycleBean();
    }

    public void beanAnnotationInitMethod() {
        log.info("RabbitLifeCycleBean创建之前");
    }

    public void beanAnnotationDestroyMethod() {
        log.info("RabbitLifeCycleBean销毁之后");
    }
}
