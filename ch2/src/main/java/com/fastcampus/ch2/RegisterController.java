package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RegisterController{
	//@RequestMapping("/register/add") 회원가입 폼

	@InitBinder
	public void toDate(WebDataBinder binder) {
	    ConversionService conversitionservice =	binder.getConversionService();

//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class , new CustomDateEditor(df, false));
	    
		binder.registerCustomEditor(String[].class , new StringArrayPropertyEditor("#")); //구분자 #
		//binder.setValidator(new UserValidator()); //userValidator를 WebDataBind의 localvalidator로 등록.
	//	binder.addValidators(new UserValidator());

	}
	
	@RequestMapping(value="/register/add", method={RequestMethod.GET,RequestMethod.POST})  //=> get방식으로 회원가입 불가. 아래 코드와 동일 
	public String register() {
		return "registerForm";
	}
	
	
	@PostMapping("/register/add")
		public String save(@Valid User user,BindingResult result, Model m) throws UnsupportedEncodingException {
		System.out.println("result="+result);
		System.out.println("user="+user);
		/*
		 * //수동 검증 UserValidator userValidator = new UserValidator();
		 * userValidator.valiate(user,result); // BindingReslut는 Errors의 자손
		 */		

		
		//User 객체를 검증한 결과 에러가 있으면 userForm을 이용해 에러를 보여준다. 
		if(result.hasErrors()) {
			
		}
		/*
		 * //1. 유효성 검사 if(!isValid(user)) { String msg =
		 * URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
		 * 
		 * m.addAttribute("msg",msg); return "forward:/register/add"; // 두줄이 밑의 한줄과 동일/
		 * //return "redirect:/register/add?msg="+msg;// URL재작성. (rewriting) }
		 * 
		 */
		
		//2. DB에 신규회원 정보를 저장 
			return "registerInfo";
		}

	private boolean isValid(User user) {
		return true;
	}
}
