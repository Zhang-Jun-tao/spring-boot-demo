package com.yx.statistics.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopInterception {

	@Before("execution(* com.yx.statistics.api..*.*(..))")
	public void before(){
		System.out.println("---------before------------");
	}
	
	@After("execution(* com.yx.statistics.api..*.*(..))")
	public void after(){
		System.out.println("---------after------------");
	}
	
	@Around("execution(* com.yx.statistics.api..*.*(..))")
	public Object  around(ProceedingJoinPoint joinpoint){
		System.out.println("---------around------------"+joinpoint);

		Object result= null;
		String methodName = joinpoint.getSignature().getName();
		try {
			//执行目标方法，并得到结果
			result = joinpoint.proceed();
			//前置通知
			System.out.println(joinpoint.getSignature().toString());
			System.out.println("The method "+methodName+" begins with "+ Arrays.asList(joinpoint.getArgs()));
			//返回通知
			System.out.println("The method "+methodName+" ends  "+result);
		} catch (Throwable e) {
			// 异常通知，当执行函数proceed()的过程中出现异常，则可以利用这个处理。
			//可用来controller异常拦截和接口拦截。
			System.out.println("The method "+methodName+" occurs  excetion:"+e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method "+methodName+" ends");
		//返回执行方法的返回值
		return result;
	}
	
	@AfterThrowing(throwing="ex",pointcut="execution(* com.hjf.boot.demo.boot_mybatis.controller..*.*(..))")
	public void AfterExcepter(Throwable ex){
		System.out.println("---------AfterExcepter------------"+ex);
	}
}
