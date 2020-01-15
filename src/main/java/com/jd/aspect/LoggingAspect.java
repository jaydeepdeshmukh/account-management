package com.jd.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	//	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.jd.accountservices.*.*(..))") 
	public void logBeforeMain(JoinPoint joinPoint){
		System.out.println("*********** Entering "+joinPoint.getSignature().getName()+" *************");
		Object[] args = joinPoint.getArgs();
		for(int i=0; i<args.length; i++)
		{
			System.out.println("*** Arg "+i+" :: "+args[i]);
		}
	}

	@After("execution(* *.*())") 
	public void logAfter(JoinPoint joinPoint){
		System.out.println("************ Exiting "+joinPoint.getSignature().getName()+" **************"); 
	}

	@AfterThrowing("within(com.jd.main.AccountManagement)")
	public void logError(JoinPoint joinPoint){
		System.out.println("************ exception thrown : "+joinPoint.toString());
	}
}
