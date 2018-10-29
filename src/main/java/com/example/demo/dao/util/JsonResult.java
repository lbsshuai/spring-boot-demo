package com.example.demo.dao.util;

/**
 * 返回结果类
 * @author lbs
 * @date 2018年10月9日
 */
public class JsonResult<T> {

	private String message;
	private String flag;
	private T object;
	
	public JsonResult(){}
	
	public JsonResult(String flag) {
		super();
		this.flag = flag;
	}

	public JsonResult(String message, String flag) {
		super();
		this.message = message;
		this.flag = flag;
	}

	public JsonResult(String flag, T object) {
		super();
		this.flag = flag;
		this.object = object;
	}

	public JsonResult(String message, String flag, T object) {
		super();
		this.message = message;
		this.flag = flag;
		this.object = object;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
	@Override
	public String toString() {
		return "JsonResult [message=" + message + ", flag=" + flag + ", object=" + object + "]";
	}
}
