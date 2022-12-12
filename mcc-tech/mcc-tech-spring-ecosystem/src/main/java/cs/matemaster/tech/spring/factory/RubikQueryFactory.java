package cs.matemaster.tech.spring.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
public class RubikQueryFactory implements FactoryBean<RubikQuery> {

    @Override
    public RubikQuery getObject() throws Exception {
        return new RubikQuery();
    }

    @Override
    public Class<?> getObjectType() {
        return RubikQuery.class;
    }
}
