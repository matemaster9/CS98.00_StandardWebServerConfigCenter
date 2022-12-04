package cs.matemaster.tech.sign.service.impl;

import cs.matemaster.tech.sign.service.JsonWebTokenSupport;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@Primary
public class JJwtImpl extends AbstractJsonWebTokenSupport implements JsonWebTokenSupport {
}
