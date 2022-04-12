package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		//1. YoilTeller 클래스의 객체 생성. 
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		//2. 모든 메서드 정보를 가져와서 저장.
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) { //메서드의 이름 
			String name = m.getName(); //매개변수 목록
			Parameter[] paramArr = m.getParameters();
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); //메서드 반환타입
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}