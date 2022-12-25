package cs.matemaster.standardwebserver.core.model;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class SuccessTip<T> extends AbstractTip {

    private T data;

    public SuccessTip(T data) {
        this.data = data;
        setCode(ErrorEnum.SUCCESS.getCode());
        setMessage(ErrorEnum.SUCCESS.getMessage());
        setTimestamp(System.currentTimeMillis());
    }
}
