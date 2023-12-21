package com.minthuraine.job.system.portfolio.job.handler;


import com.minthuraine.job.system.portfolio.job.exception.UnsupportedParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class UnsupportedParameterExceptionHandler {

    @ExceptionHandler(value = {UnsupportedParameterException.class})
    public ResponseEntity<Object> handleException(UnsupportedParameterException exception) {
        return new ResponseHandler().createUnsupportedParameterResponse(exception.getUnsupportedParameters());
    }

}
