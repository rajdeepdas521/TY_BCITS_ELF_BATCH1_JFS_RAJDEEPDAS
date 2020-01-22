package com.bcits.springcore;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBean;

public class MessageTest {

	public static void main(String[] args) {
		ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
		((ConfigurableApplicationContext)Context).registerShutdownHook();
		
		MessageBean messageBean = (MessageBean)Context.getBean("message");

		System.out.println(messageBean.getMessage());
//		((AbstractApplicationContext) applicationContext).close();
		
	}

}
