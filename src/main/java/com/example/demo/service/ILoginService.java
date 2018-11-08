package com.example.demo.service;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.TblSysUser;

/**
 * 登录业务逻辑接口
 * @author lbs
 * @date 2018年9月28日
 */
public interface ILoginService {

	/**
	 * 注册
	 */
	void signIn(TblSysUser user)throws MyException;
}
