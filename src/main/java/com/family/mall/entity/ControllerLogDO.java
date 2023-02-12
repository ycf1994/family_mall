package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("controller_log")
public class ControllerLogDO implements Serializable {
    private String requestUrl;
    private String requestBody;
    private String responseBody;
    private String clueId;
    private String success;
    private Integer rt;
    private Date time;
}
