package org.kpu.myweb.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice("org.kpu.web.controller")
public class MemberControllerAdvice {
	
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {

    	e.printStackTrace();
        return "member/error";
    }
    
    @ExceptionHandler(DataNotFoundException.class)
    public String handleException(DataNotFoundException e) {
        return "member/not_found";
    }

}
