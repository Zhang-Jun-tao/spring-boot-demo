package com.yx.statistics.common;

/**
 * Created by Administrator on 2017/1/18.
 */
public class SuccessMsg implements ResultMsg{

    private int status;
    private int code;
    private String msg;
    private Integer have_data;
    private String data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getHave_data() {
        return have_data;
    }

    public void setHave_data(Integer have_data) {
        this.have_data = have_data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public SuccessMsg() {
    }

    public SuccessMsg(int status, int code, String msg, Integer have_data, String data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.have_data = have_data;
        this.data = data;
    }
}
