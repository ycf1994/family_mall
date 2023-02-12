package com.family.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserGroupRelationDO extends BaseDO{
    private Long id;
    private Long userId;
    private Long groupId;
    private Long inviteUserId;
    private Byte role;
}
