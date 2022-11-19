package cs.matemaster.standardwebserver.core;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class SuccessTip<T> extends AbstractTip {

    private T data;

    public SuccessTip(T data) {
        this.data = data;
        setCode(ErrorCode.SUCCESS.getCode());
        setMessage(ErrorCode.SUCCESS.getMessage());
        setTimestamp(System.currentTimeMillis());
    }
}
