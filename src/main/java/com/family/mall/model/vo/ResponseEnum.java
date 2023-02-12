package com.family.mall.model.vo;

public enum ResponseEnum {
    SUCCESS("200","成功"),
    ERROR("500","内部错误"),
    LOGIN_ERROR_NAME_EXISTS("101","用户名已存在"),
    LOGIN_ERROR_TELEPHONE_EXISTS("102","手机号已存在")
    ;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isType(String code){
        return this.code.equals(code);
    }

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
