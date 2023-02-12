package com.family.mall.expection;

import com.family.mall.model.vo.ResponseEnum;
import lombok.Data;

@Data
public class MallException extends RuntimeException{
    private String code;
    private String msg;

    public MallException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MallException(ResponseEnum responseEnum){
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }
}
