package org.kpu.myweb.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ExceptionCheckAspect {

	// org.kpu.myweb 패키지로 시작하는 모든 패키지 선택 하고 Impl로 끝나는 클래스의 모든 메소드
	@Pointcut("execution(* org.kpu.myweb..*Impl.*(..))")
    public void allPointcut() {}
	// get*(..)로 끝나는 메소드
    @Pointcut("execution(* org.kpu.myweb..*Impl.get*(..))")
    public void getPointcut() {}

    @Before("allPointcut()")
    public void printLogging() {
        System.out.println("[공통 로그-Log4j 비지니스 로직 수행 전 동작");
    }

    @AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
    public void exceptionLogging(JoinPoint jp, Exception exceptObj) {
        String method = jp.getSignature().getName();
        System.out.println(method + "() 메소드 수행 중 예외 발생!");

        if (exceptObj instanceof SQLException) {
            System.out.println("SQL 수행 중 예외 발생");
        } else {
            System.out.println("기타 예외 발생");
        }
    }
}
