package org.javahd.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String getName())")
	public void advice1()
	{
		System.out.println("Getting the name of student object");
	}
	
	@After("execution(public String getName())")
	public void advice2()
	{
		System.out.println("The name of student object is returned");
	}
	

//	@Before("execution(public * get*())")
//	public void advice3(){
//		System.out.println("Getting any of the student attributes");
//	}
	
//	@Pointcut("execution(public * get*())")
//	public void allGetters() {}
	
//	@Pointcut("within(org.javahd.spring.bean.*)")
//	public void allGetters() {}
//	
//	@Before("allGetters()")
//	public void advice4(){
//		System.out.println("Getting any of the student attributes");
//	}
}
