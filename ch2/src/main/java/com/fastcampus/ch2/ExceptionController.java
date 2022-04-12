package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class MyException extends RuntimeException{
	MyException(String msg) {
		super(msg);
	}
	 MyException() {this("");}
 }

@Controller
public class ExceptionController {
	




	@RequestMapping("/ex")
	public String main(Model m) throws Exception{
		
			throw new MyException("예외가 발생했습니다.");
	}
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
