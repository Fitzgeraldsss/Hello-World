package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//������� �Է��Գ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public void main(@RequestParam(required=true) HttpServletRequest request , HttpServletResponse response) throws IOException {
		//1. �Է� 
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. �۾� 
		int yyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyy, mm -1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		//3. ��� 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //response��ü���� ��½�Ʈ���� ��´�. 
		out.println(year + "��" +month+ "��"+ day+"��");
		out.println(yoil+"�����Դϴ�.");
		
	}
}
