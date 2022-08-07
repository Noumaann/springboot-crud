package com.example.springbootdemo.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springbootdemo.responses.RespInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TraineeIdNotFoundException.class)
	public ResponseEntity<RespInfo> handlerMethodForException(TraineeIdNotFoundException ex, HttpServletRequest req){
		String msg = ex.getMessage();
		RespInfo ri = new RespInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),msg,req.getRequestURI());
		ResponseEntity<RespInfo> re = new ResponseEntity<>(ri,HttpStatus.NOT_FOUND);
		return re;
	}
	@ExceptionHandler(TraineeNameNotFoundException.class)
	public ResponseEntity<RespInfo> handlerMethodForException(TraineeNameNotFoundException ex, HttpServletRequest req){
		String msg = ex.getMessage();
		RespInfo ri = new RespInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),msg,req.getRequestURI());
		ResponseEntity<RespInfo> re = new ResponseEntity<>(ri,HttpStatus.NOT_FOUND);
		return re;
	}
}
