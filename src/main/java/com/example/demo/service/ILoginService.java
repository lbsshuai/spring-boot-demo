package com.example.demo.service;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.TblSysUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录业务逻辑接口
 * @author lbs
 * @date 2018年9月28日
 */
public interface ILoginService {

	/**
	 * 登录
	 * @param name
	 * @param password
	 */
	void loginIn(String name, String password, String rememberMe, HttpServletResponse response) throws MyException;

	/**
	 * 注册
	 */
	void signIn(TblSysUser user)throws MyException;


}
