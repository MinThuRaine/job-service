package com.minthuraine.job.system.portfolio.job.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {

    Map<String, Object> resultMap = new HashMap<>();

    public ResponseHandler() {
    }

    public ResponseEntity<Object> createUnsupportedParameterResponse(List<String> unsupportedParameter) {
        resultMap.put("status", "fail");
        resultMap.put("errorCode", "404");
        resultMap.put("unsupportedParameter", unsupportedParameter);

        return new ResponseEntity<Object>(resultMap, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> listJobRepository(String data) {
        resultMap.put("status", "success");
        resultMap.put("data", data);

        return new ResponseEntity<Object>(resultMap, HttpStatus.OK);
    }

}
