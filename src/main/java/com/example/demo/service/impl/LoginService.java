package com.example.demo.service.impl;

import com.example.demo.dao.model.TblSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.login.LoginDao;
import com.example.demo.service.ILoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	 * 登录
	 * @param name
	 * @param password
	 */
	@Override
	public void loginIn(String name, String password, String rememberMe, HttpServletResponse response) throws MyException{
		TblSysUser tblSysUser = loginDao.loginIn(name, password);
		if(tblSysUser == null) {
			throw new MyException("用户名或密码错误");
		}
		//Cookie存入记住用户名
		Cookie nameCookie = new Cookie("userName",tblSysUser.getName());
		nameCookie.setPath("/");
		response.addCookie(nameCookie);

		//是否记住密码
		if(rememberMe.equals("1")){
			//通过Cookie实现记住密码
			String loginInfo = tblSysUser.getName()+"#"+tblSysUser.getPassword();
			Cookie userInfoCookie = new Cookie("userInfoCookie",loginInfo);
			userInfoCookie.setMaxAge(120);
			userInfoCookie.setPath("/");
			response.addCookie(userInfoCookie);
		}

	}

	/**
	 * 注册
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void signIn(TblSysUser user) throws MyException{
		if(user == null) {
			throw new MyException("账号或密码为空，请填写！");
		}

		//校验数据唯一性
		TblSysUser tblSysUser = loginDao.checkName(user.getName());
		if(tblSysUser != null){
			throw new MyException("账号名已存在，请换一个！");
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
