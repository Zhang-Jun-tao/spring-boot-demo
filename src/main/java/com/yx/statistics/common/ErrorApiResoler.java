package com.yx.statistics.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alibaba.fastjson.JSONObject;

@ControllerAdvice(basePackages="com.yx.statistics.api")
public class ErrorApiResoler extends ResponseEntityExceptionHandler {
	private static final Logger LOG=Logger.getLogger(ErrorApiResoler.class);

    
	@ExceptionHandler
    @ResponseBody
    ResponseEntity<String> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        String errorMsg=ex.getMessage()==null ? "NullPointerException": ex.getMessage();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("status", Integer.parseInt(status.toString()));
        map.put("errorMsg", errorMsg);
        LOG.error(ex.toString());
        ResponseEntity<String> entity=new ResponseEntity<String>(JSONObject.toJSONString(map), HttpStatus.valueOf(200));
        return entity;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
