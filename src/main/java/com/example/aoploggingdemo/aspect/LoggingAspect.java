package com.example.aoploggingdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Pointcut(value = "execution(* com.example.aoploggingdemo.*.*.*(..))")
	public void loggingPointCut() {
		System.out.println("what");
	}
	
	@Around("loggingPointCut()")
	public Object loggingAdvice(ProceedingJoinPoint pj) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pj.getSignature().getName();
		String className = pj.getTarget().getClass().toString();
		
		Object[] array = pj.getArgs();
		System.out.println("Inside "+className+ "class "+methodName+" method, with request : "+mapper.writeValueAsString(array));
		System.out.println("what!");
		Object response = pj.proceed();
		
		System.out.println("Inside "+className+ "class "+methodName+" method, with response : "+mapper.writeValueAsString(response));
		return response;
	}
}
