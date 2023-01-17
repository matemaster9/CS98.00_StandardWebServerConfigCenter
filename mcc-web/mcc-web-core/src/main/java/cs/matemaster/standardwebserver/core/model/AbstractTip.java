package cs.matemaster.standardwebserver.core.model;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public abstract class AbstractTip {


    protected String code;


    protected String message;


    protected Long timestamp;
}
