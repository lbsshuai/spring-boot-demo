package com.example.demo.dao.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.SysUserLoveMapper;
import com.example.demo.dao.mapper.TblSysUserMapper;
import com.example.demo.dao.model.SysUserLove;
import com.example.demo.dao.model.TblSysUser;

/**
 * 登录dao层
 * @author lbs
 * @date 2018年9月28日
 */
@Repository
public class LoginDao {

	@Autowired
	private TblSysUserMapper tblSysUserMapper;
	
	@Autowired
	private SysUserLoveMapper sysUserLoveMapper;
	
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
	
	/**
	 * 插入用户爱好
	 * @param loveList
	 */
	public void insertLove(SysUserLove sul) {
		sysUserLoveMapper.insertSelective(sul);
	}
}
