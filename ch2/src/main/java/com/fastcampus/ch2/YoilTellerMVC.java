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
public class YoilTellerMVC {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return"yoilError";
	}
	
	@RequestMapping("/getYoilMVC4")
//	public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {	
	public String main(MyDate date, Model model) throws IOException {
		
	
	//1. 입력 
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
		
		//2. 작업 
//		int yyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
		
		
		//1. 유효성 검사 
		if(!isValid(date))
			return "yoilError";
		
		char yoil = getYoil(date);
		
		//계산한 결과를 model에 저장 
		model.addAttribute("mydate",date);
		model.addAttribute("yoil", yoil);
		
		
		return "yoil"; //WEB-INF/views/yoil.jsp를 이용해서 작업 결과를 보여달라.

	
		
		
		//		3. 출력 
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter(); //response객체에서 출력스트림을 얻는다. 
//		out.println(year + "년" +month+ "월"+ day+"일");
//		out.println(yoil+"요일입니다.");
		
	}


	private boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay()) ;
	}

	private char getYoil(MyDate date) {
		// TODO Auto-generated method stub
		return getYoil(date.getYear() , date.getMonth(), date.getDay());
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
	   private boolean isValid(int year, int month, int day) {    
	    	if(year==-1 || month==-1 || day==-1) 
	    		return false;
	    	
	    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
	    }
}
