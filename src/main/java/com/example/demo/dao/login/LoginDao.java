package com.example.demo.dao.login;

import com.example.demo.dao.mapper.TblSysUserMapper;
import com.example.demo.dao.model.TblSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 登录dao层
 * @author lbs
 * @date 2018年9月28日
 */
@Repository
public class LoginDao {

	@Autowired
	private TblSysUserMapper tblSysUserMapper;

	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	public TblSysUser loginIn(String name, String password){
		return tblSysUserMapper.loginIn(name, password);
	}
	/**
	 * 校验账号唯一性
	 * @param name
	 */
	public TblSysUser checkName(String name){
		return tblSysUserMapper.checkName(name);
	}
	/**
	 * 注册用户信息
	 * @param user
	 * @return
	 */
	public void signIn(TblSysUser user) {
		tblSysUserMapper.signIn(user);
	}
	
	/**
	 * 获取用户表主键id
	 * @return
	 */
	public int queryId() {
		return tblSysUserMapper.queryId();
	}
}
