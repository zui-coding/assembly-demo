package com.zuicoding.platform.comment.module;

import java.io.Serializable;

import com.zuicoding.platform.comment.exception.IMessage;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 952689424153445778L;

    private int code = 200;
    private T result;

    public Response(int code) {
        this.code = code;
    }

    public Response(T result) {
        this.result = result;
    }

    public Response() {
    }

    public Response(int code, T result) {
        this.code = code;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Response setResult(T result) {
        this.result = result;
        return  this;
    }

    public static Response success(){

        return new Response();
    }
    public static Response success(Object o){

        return new Response(o);
    }

    public static Response fail(){
        return new Response(-500);
    }
    public static Response fail(Object o){
        return new Response(-500,o);
    }

    public static Response fail(IMessage message){
        return new Response(message.getCode(),message.getMessage());
    }
}
