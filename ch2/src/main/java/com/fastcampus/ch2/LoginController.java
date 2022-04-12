package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
			//.1 세션종료. 
			session.invalidate();
			//2. 홈으로 이동 
			return "redirect:/";
		}
	
	
	@PostMapping("/login")
	public String login( String id, String pwd, String toURL, boolean rememberId,HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		//1. id 와 pwd를 확인. 
		//2-1. 일치하지 않으면, 홈으로 이동. 
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다","utf8");
			
			return "redirect:/login/login?msg="+msg; //redirect 하는 경우는 get으로 -> loginForm 메서드로 이동.
		}
		//2-2, id 와 pwd 일치시 , 
		// 세션객체 얻어오디. 
		HttpSession session = request.getSession();
		
		// 세션객체에 id 저장 
		session.setAttribute("id",id);
		
		
		
		if(rememberId) { //rememberId 체크 되어있으면. 저장. 안되있으면 삭제.
			//1. 쿠키를 생성
			Cookie cookie = new Cookie("id",id);
			//2. 응답에 저장 
			response.addCookie(cookie);
			
		}else {
			//쿠키를 삭제 
			//1. 쿠키를 생성
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);  //쿠키 삭제 코드. 
			response.addCookie(cookie);
		}
			//3. 홈으로 이동.   -> toURL이 있는경우 toRUL로 간다.
			toURL = toURL == null || toURL.equals("") ? "/" : toURL;
			
			return "redirect:"+toURL;   // "redirct:/" + toRUL 로 하면 ch2까지의 경로 포함됨 redirect:/ (슬래시 빼고 쓸것..)
	}
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id)&&"1234".equals(pwd);  // asdf와 id 의 순서를 바꿔서 쓴 이유는 null 체크를 안해도 되기 때문이다. 
	} //id.equals("asdf"); 인경우 null체크 필요하다. 
}
