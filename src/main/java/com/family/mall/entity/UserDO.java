package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class UserDO extends BaseDO {
    private String name;
    private String password;
    private String nickName;
    private String telephone;
    private String imgUrl;
    private Byte gender;
    private Integer age;
    private Date birthDay;
    private Byte status;

}
