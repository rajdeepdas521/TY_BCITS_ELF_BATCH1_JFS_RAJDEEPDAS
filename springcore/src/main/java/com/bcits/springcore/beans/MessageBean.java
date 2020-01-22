package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean, DisposableBean{

	private String message;
	
	public MessageBean() {
		System.out.println("Its Intantiation phase!");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
    public void afterPropertiesSet() throws Exception {
		System.out.println("Inside init phase....");
		
	}
	@Override
	public void destroy() throws Exception{
		System.out.println("Its Destruction Phase !!!!");
	}

}
