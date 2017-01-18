package com.yx.statistics.common;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhang on 2017/1/18.
 */
public class ErrorMsg implements ResultMsg{
    private int status;
    private int code;
    private String msg;


    public ErrorMsg() {
    }

    public ErrorMsg(int status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public  static  void main(String[] args){
        ResultMsg msg=new ErrorMsg(200,200,"ok");
        System.out.println(JSONObject.toJSONString(msg));
    }
}
