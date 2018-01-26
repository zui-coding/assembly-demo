package com.zuicoding.platform.comment.exception;

import java.io.Serializable;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
public interface IMessage extends Serializable {

    int getCode();
    String getMessage();
}
