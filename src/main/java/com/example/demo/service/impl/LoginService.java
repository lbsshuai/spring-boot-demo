package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.login.LoginDao;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.service.ILoginService;

/**
 * 登录业务逻辑层
 * @author lbs
 * @date 2018年9月28日
 */
@Service
public class LoginService implements ILoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void insert(TblSysUser user) {
		loginDao.insert(user);
	}

}
