package com.family.mall.manage.user;

import com.family.mall.expection.MallException;
import com.family.mall.model.dto.UserDTO;
import com.family.mall.model.vo.ResponseEnum;
import com.family.mall.model.vo.UserVO;
import com.family.mall.service.user.IUserService;
import com.family.mall.util.MallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserManage implements IUserManage{
    @Autowired
    private IUserService userService;

    @Override
    public UserVO getUserById(Long id) {
        return MallUtil.convert(userService.getUserById(id),UserVO.class);
    }

    @Override
    public Boolean regUser(UserVO userVO) {
        UserDTO userDTO = MallUtil.convert(userVO,UserDTO.class);
        if(userService.existsName(userDTO.getName())){
            throw new MallException(ResponseEnum.LOGIN_ERROR_NAME_EXISTS);
        }
        if(userService.existsTelephone(userDTO.getTelephone())){
            throw new MallException(ResponseEnum.LOGIN_ERROR_TELEPHONE_EXISTS);
        }
        return userService.addUser(userDTO);
    }

    @Override
    public Boolean updateUser(UserVO userVO) {
        return userService.updateUser(MallUtil.convert(userVO, UserDTO.class));
    }

    @Override
    public UserVO login(String name, String password) {
        return MallUtil.convert(userService.login(name,password), UserVO.class);
    }
}
