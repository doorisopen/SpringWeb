package org.kpu.myweb.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class MyAspect {

	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
	/*
	 *  DAO의 쿼리 수행시간 측정 하기
	 */
	@Around("execution(* *..persistence.*.*(..))")
	public Object logPrint(ProceedingJoinPoint pjp) throws Throwable {
		// before advice
		StopWatch sw = new StopWatch();
		sw.start();
		
		// long start = System.currentTimeMillis();
		// proceed() 메서드 호출 => 실제 비즈니스
		// 비즈니스가 리턴하는 객체가 있을 수 있으므로 Obejct로 받아준다.
		Object result = pjp.proceed();
		
		// after advice
		sw.stop();
		Long total = sw.getTotalTimeMillis();
				
		// 어떤 클래스의 메서드인지 출력하는 정보는 pjp 객체에 있다.
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		
		// 실행시간은 로그로 남기는 것이 좋지만, 여기서는 콘솔창에 찍도록 한다.
		System.out.println("[ExecutionTime] " + taskName + " , " + total + "(ms)");
		
		
		/* 각계층의 실행 로그 출력 하기
		 * 
		String type = pjp.getSignature().getDeclaringTypeName();
		String name = "";
		
		if(type.contains("Controller")) {
			name = "Controller : ";
		} else if(type.contains("Service")) {
			name = "Service : ";
		} else if(type.contains("DAO")) {
			name = "Persistence : ";
		}
		long end = System.currentTimeMillis();
		
		logger.info(name + type + "."+pjp.getSignature().getName() + "()");
		logger.info("Argument/Parameter : " +Arrays.toString(pjp.getArgs()));
		logger.info("Running Time :" +(end-start));
		logger.info("-----------------------------------------------------");
		*/
		return result;
	}
}
