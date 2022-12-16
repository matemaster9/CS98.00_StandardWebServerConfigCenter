package cs.matemaster.standardwebserver.common.model.request;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import cs.matemaster.standardwebserver.common.util.BizAssertUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author matemaster
 */
@Setter
@Getter
public class BookStorageDetailPagingQuery extends PagingParam {


    public void checkParams() {
        BizAssertUtil.illegalParams(getPageNo() <= 0, ErrorEnum.ILLEGAL_PARAMETER);
        BizAssertUtil.illegalParams(getPageSize() > 10000, ErrorEnum.ILLEGAL_PARAMETER, "页面容量过大");
    }
}
