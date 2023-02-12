package com.family.mall.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {
    private Long id;
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
