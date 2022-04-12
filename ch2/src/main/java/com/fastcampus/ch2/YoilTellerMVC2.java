package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//년원일을 입력함녀 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC2 {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return"yoilError";
	}
	
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {	
	public String main(@RequestParam(required=true) int year, 
		@RequestParam(required=true) int month ,
		@RequestParam(required=true) int day , Model model) throws IOException {
		
	
	//1. 입력 
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
		
		//2. 작업 
//		int yyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
		
		
		//1. 유효성 검사 
		if(!isValid(year, month, day))
			return "yoilError";
		
		char yoil = getYoil(year, month, day);
		
		//계산한 결과를 model에 저장 
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil", yoil);
		
		
		return "yoil"; //WEB-INF/views/yoil.jsp를 이용해서 작업 결과를 보여달라.

	
		
		
		//		3. 출력 
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter(); //response객체에서 출력스트림을 얻는다. 
//		out.println(year + "년" +month+ "월"+ day+"일");
//		out.println(yoil+"요일입니다.");
		
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
