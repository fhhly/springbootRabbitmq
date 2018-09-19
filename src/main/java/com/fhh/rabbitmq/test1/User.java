package com.fhh.rabbitmq.test1;

import java.io.Serializable;

/**
 * 用户
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月20日 下午4:20:49
 */
public class User implements Serializable {
	private static final long serialVersionUID = -7856879762301422465L;
	private String userName;
	private String age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
