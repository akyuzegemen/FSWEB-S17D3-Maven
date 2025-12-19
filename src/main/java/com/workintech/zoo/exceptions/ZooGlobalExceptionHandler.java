package com.workintech.zoo.exceptions;


import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ZooGlobalExceptionHandler {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ZooGlobalExceptionHandler.class); //@Slf4j

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handlerException(ZooException zooException) {
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(zooException.getHttpStatus().value(), zooException.getMessage(), System.currentTimeMillis());
        log.error(zooErrorResponse.getMessage());
        return new ResponseEntity<>(zooErrorResponse, zooException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handlerException(Exception exception) {
        ZooErrorResponse newResponse = new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), System.currentTimeMillis());
        log.error(newResponse.getMessage());
        return new ResponseEntity<>(newResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
