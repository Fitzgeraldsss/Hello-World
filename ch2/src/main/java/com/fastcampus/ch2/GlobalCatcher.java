package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice("fascampus") //지정된 패키지에서만 예외처리
public class GlobalCatcher {
	@ExceptionHandler({NullPointerException.class , FileNotFoundException.class})//배열 형식으로 여러개 예외처리 가능.
	public String catcher() {

		return "error";
	}
	

//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//200 -> 500
	@ExceptionHandler(Exception.class)
	public String catcher2() {
//		m.addAttribute("ex",ex);
		return "error";
	}
}
