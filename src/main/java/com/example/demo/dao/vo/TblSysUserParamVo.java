package com.example.demo.dao.vo;


/**
 * 注册参数
 * @author lbs
 * @date 2018年10月9日
 */
public class TblSysUserParamVo {

	private String name;

	private String password;

	private String sex;

	private String nation;
	
	public String getName() {
		return nvl(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return nvl(password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return nvl(sex);
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nvl(nation);
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	private String nvl(String param) {
		return com.example.demo.dao.util.StringUtils.trimToNull(param);
	}
	
	@Override
	public String toString() {
		return "TblSysUserParamVo [name=" + name + ", password=" + password + ", sex=" + sex + ", nation=" + nation + "]";
	}
	
}
