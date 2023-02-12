package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class GroupDO extends BaseDO{
    private String name;
    private String remark;
    private Byte status;
}
