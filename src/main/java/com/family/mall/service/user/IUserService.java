package com.family.mall.service.user;

import com.family.mall.model.dto.UserDTO;

public interface IUserService {
    UserDTO getUserById(Long id);

    Boolean addUser(UserDTO userDTO);

    Boolean existsName(String name);

    Boolean existsTelephone(String telephone);

    UserDTO login(String name,String password);

    Boolean updateUser(UserDTO userDTO);
}
