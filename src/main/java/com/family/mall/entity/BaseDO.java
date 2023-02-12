package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDO implements Serializable {
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    private Byte isDeleted;
    private Date gmtCreated;
    private Date gmtModified;
}
