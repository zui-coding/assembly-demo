package com.zuicoding.platform.comment.dict;

import com.zuicoding.platform.comment.exception.IMessage;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
public enum BusinessCode implements IMessage{

    NIKENAME_ISEMPTY(-300,"昵称为空"),
    EMAIL_ISEMPTY(-301,"邮箱为空"),
    CONTEXT_ISEMPTY(-302,"评论内容为空");

    private int code;
    private String message;

    BusinessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String toString() {
        return "BusinessCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
