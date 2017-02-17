package com.hard.recommends;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component("email")
//@EnableTransactionManagement
public class Email implements AfterReturningAdvice {
	public void sendEmail(String message) {
		System.out.println("send email: " + message);
	}
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		sendEmail("hello");
	}
}