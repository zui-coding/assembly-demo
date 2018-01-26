package com.zuicoding.platform.comment.exception;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
public class BusinessException extends RuntimeException {

    private IMessage errorMsg;

    public BusinessException(IMessage errorMsg) {
        super(errorMsg.getMessage());
        this.errorMsg = errorMsg;

    }

    public IMessage getErrorMsg() {
        return errorMsg;
    }

}
