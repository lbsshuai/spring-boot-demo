package com.example.demo.dao.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.TblSysUserMapper;
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
	
	public void insert(TblSysUser user) {
		tblSysUserMapper.insert(user);
	}
}
