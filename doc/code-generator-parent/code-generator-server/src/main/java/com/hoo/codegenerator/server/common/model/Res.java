package com.hoo.codegenerator.server.common.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 统一响应对象
 *
 * @author hank
 * @create 2020-01-10 上午11:11
 **/
public class Res<T> extends HashMap<String,Object> implements Serializable{
    private String message;
    private Serializable code;
    private T data;

    public Res(){
        super();
        super.put("message", message);
        super.put("code", -1);
        super.put("data", data);
    }

    public static <T> Res<T> ok() {
        Res<T> res = new Res();
        res.setCode(200);
        return res;
    }

    public static <T> Res<T> data(T data) {
        Res<T> res = new Res<T>();
        res.setCode(200);
        res.setData(data);
        return res;
    }

    public static <T> Res<T> error(String message) {
        Res<T> res = new Res();
        res.setMessage(message);
        return res;
    }

    public String getMessage() {
        return message;
    }

    public Res setMessage(String message) {
        super.put("message", message);
        this.message = message;
        return this;
    }

    public Serializable getCode() {
        return code;
    }

    public void setCode(Serializable code) {
        super.put("code", code);
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        super.put("data", data);
        this.data = data;
    }
}
