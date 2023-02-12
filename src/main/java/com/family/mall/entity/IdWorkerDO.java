package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("id_worker")
public class IdWorkerDO implements Serializable {
    @TableId(value = "id",type=IdType.AUTO)
    private Long id;
    private Integer value;
}
