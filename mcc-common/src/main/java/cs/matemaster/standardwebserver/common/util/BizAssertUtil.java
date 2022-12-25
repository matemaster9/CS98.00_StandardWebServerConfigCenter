package cs.matemaster.standardwebserver.common.util;

import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import cs.matemaster.standardwebserver.common.exception.BaseBusinessException;
import cs.matemaster.standardwebserver.common.exception.BaseTransactionException;
import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;

/**
 * @author matemaster
 */
public final class BizAssertUtil {

    private BizAssertUtil() {
    }

    public static void transactional(boolean assertBool, IErrorCode errorCode, Object extraMessage) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new BaseTransactionException(errorCode, extraMessage);
        }
    }

    public static void transactional(boolean assertBool, IErrorCode errorCode) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new BaseTransactionException(errorCode);
        }
    }


    public static void baseBusiness(boolean assertBool, IErrorCode errorCode, Object extraMessage) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new BaseBusinessException(errorCode, extraMessage);
        }
    }

    public static void baseBusiness(boolean assertBool, IErrorCode errorCode) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new BaseBusinessException(errorCode);
        }
    }

    public static void illegalParams(boolean assertBool, String extraMessage) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new IllegalParamsException(extraMessage);
        }
    }

    public static void illegalParams(boolean assertBool, IErrorCode errorCode, String extraMessage) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new IllegalParamsException(errorCode, extraMessage);
        }
    }

    public static void illegalParams(boolean assertBool, IErrorCode errorCode) {
        if (BusinessUtil.isTrue(assertBool)) {
            throw new IllegalParamsException(errorCode);
        }
    }
}
