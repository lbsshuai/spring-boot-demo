package com.example.demo.dao.exception;


public class MyException extends Exception {

	private static final long serivalVersionUID = 1L;

	private String message;

	private String code;

	private Throwable cause;

	public MyException() {
		super();
	}

	public MyException(Throwable cause) {
		super();
		this.cause = cause;
	}

	public MyException(String message) {
		super();
		this.message = message;
	}

	public MyException(String code, Throwable cause) {
		super();
		this.code = code;
		this.cause = cause;
	}

	public MyException(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public MyException(String message, String code, Throwable cause) {
		super();
		this.message = message;
		this.code = code;
		this.cause = cause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
}
