package com.example.demo.service;

import com.example.demo.dao.model.TblSysUser;

/**
 * 登录业务逻辑接口
 * @author lbs
 * @date 2018年9月28日
 */
public interface ILoginService {

	void insert(TblSysUser user);
}
