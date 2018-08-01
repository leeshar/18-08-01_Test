package com.icia.aboard2.exception;


public class UserNotFoundException extends RuntimeException {
	private String id;
	public UserNotFoundException(String id) {
		this.id = id;
	}
	@Override
	public String getMessage() {
		return id + "을/를 찾을 수 없습니다";
	}
}
