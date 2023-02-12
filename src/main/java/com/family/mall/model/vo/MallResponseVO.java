package com.family.mall.model.vo;

import com.family.mall.expection.MallException;
import lombok.Data;

import java.io.Serializable;
@Data
public class MallResponseVO implements Serializable {
    private Object data;
    private String code;
    private String msg;
    private Boolean success;
    private Long rt;

    public Boolean getSuccess() {
        return ResponseEnum.SUCCESS.isType(code);
    }

    public MallResponseVO(Object data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public MallResponseVO() {
    }

    public static MallResponseVO success(Object data){
        return new MallResponseVO(data, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    public static MallResponseVO success(Object data,Long rt){
        MallResponseVO vo =  new MallResponseVO(data, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
        vo.setRt(rt);
        return vo;
    }

    public static MallResponseVO fail(MallException exception, Long rt){
        MallResponseVO vo =  new MallResponseVO(null, exception.getCode(),exception.getMsg());
        vo.setRt(rt);
        return vo;
    }

    public static MallResponseVO fail(ResponseEnum responseEnum, Long rt){
        MallResponseVO vo =  new MallResponseVO(null, responseEnum.getCode(),responseEnum.getMsg());
        vo.setRt(rt);
        return vo;
    }
}
