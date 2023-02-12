package com.family.mall.controller;

import com.family.mall.manage.user.IUserManage;
import com.family.mall.model.vo.UserVO;
import com.family.mall.service.user.IUserService;
import com.family.mall.util.MallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zouwei
 * @className UserController
 * @date: 2022/7/16 下午11:13
 * @description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private IUserManage userManage;

	@GetMapping("/getbyid")
	public Object getUserById(@RequestParam("id") Long id) {
		return userManage.getUserById(id);
	}





}