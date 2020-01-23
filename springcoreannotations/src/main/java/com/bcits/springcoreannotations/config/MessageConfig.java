package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.mypostprocessors.MyBeanFactoryPostProcessor;
import com.bcits.springcoreannotations.mypostprocessors.MyBeanPostProcessor;

@Configuration
public class MessageConfig {
	
   @Bean(name="messageBean")
   public MessageBean getMessageBean() {
	   MessageBean messageBean =new MessageBean();
	   messageBean.setMessage("Welcome Back to Spring Core...");
	   
	   return messageBean;
   }
	@Bean
	public MyBeanPostProcessor getMyBPP() {
		return new MyBeanPostProcessor();
		
	}
	@Bean
	public MyBeanFactoryPostProcessor getMyBFPP() {
		return new MyBeanFactoryPostProcessor();
	}

}
