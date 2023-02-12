package com.family.mall.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.family.mall.entity.UserDO;
import com.family.mall.mapper.UserMapper;
import com.family.mall.model.dto.UserDTO;
import com.family.mall.util.MallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO getUserById(Long id) {
        return MallUtil.convert(userMapper.selectById(id),UserDTO.class);
    }

    @Override
    public Boolean addUser(UserDTO userDTO) {
        return userMapper.insert(MallUtil.convert(userDTO,UserDO.class)) == 1;
    }

    @Override
    public Boolean existsName(String name) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getName,name))!=null;
    }

    @Override
    public Boolean existsTelephone(String telephone) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getTelephone,telephone))!=null;
    }

    @Override
    public UserDTO login(String name, String password) {
        return MallUtil.convert(userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getName,name).eq(UserDO::getPassword,password)),UserDTO.class);
    }

    @Override
    public Boolean updateUser(UserDTO userDTO) {
        return userMapper.updateById(MallUtil.convert(userDTO,UserDO.class)) == 1;
    }
}
