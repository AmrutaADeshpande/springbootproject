package com.rts.auth.filter;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
	public static final Logger log = LogManager.getLogger(LogInterceptor.class);
	
	@Around("@annotation(com.rts.auth.filter.Logged)")
	public Object logEntry(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		log.info("Beginning Method : "+method.getName());
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    log.info("Method : "+method.getName()+" : Ended In "+executionTime+ "ms");
	    return proceed;
	}

}
