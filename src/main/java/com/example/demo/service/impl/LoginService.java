package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.login.LoginDao;
import com.example.demo.dao.model.SysUserLove;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.service.ILoginService;

import ch.qos.logback.classic.Logger;

/**
 * 登录业务逻辑层
 * @author lbs
 * @date 2018年9月28日
 */
@Service
public class LoginService implements ILoginService {

	@Autowired
	private LoginDao loginDao;
	
	/**
	 * 注册
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void signIn(TblSysUser user) throws MyException{
		if(user == null) {
			//TODO 返回错误信息
		}
		
		//用户表插入数据
		loginDao.signIn(user);
		
		int id = loginDao.queryId();
		//插入爱好表
		/*for(int i = 0; i < loveList.size(); i++) {
			SysUserLove sul = new SysUserLove();
			sul.setId(id);
			sul.setLove(loveList.get(i));
			loginDao.insertLove(sul);
		}*/
		
	}

}
