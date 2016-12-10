package com.yx.statistics.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(basePackages="com.yx.statistics.controller")
public class ErrorViewResoler extends ResponseEntityExceptionHandler {
	private static final Logger LOG=Logger.getLogger(ErrorApiResoler.class);

    
	@ExceptionHandler
    ModelAndView handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status=getStatus(request);
        String errorMsg=ex.getMessage()==null ? "NullPointerException": ex.getMessage();
        ModelAndView mv=new ModelAndView("aop_error");
        mv.addObject("errorMsg",errorMsg);
        LOG.error(ex.toString());
        return mv;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
