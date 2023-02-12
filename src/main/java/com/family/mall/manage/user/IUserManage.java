package com.family.mall.manage.user;

import com.family.mall.model.dto.UserDTO;
import com.family.mall.model.vo.UserVO;

public interface IUserManage {
    UserVO getUserById(Long id);

    Boolean regUser(UserVO userVO);

    Boolean updateUser(UserVO userVO);

    UserVO login(String name,String password);
}
