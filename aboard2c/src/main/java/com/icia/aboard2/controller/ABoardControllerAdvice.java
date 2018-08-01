package com.icia.aboard2.controller;

import java.util.*;

import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.aboard2.exception.*;

// 컨트롤러 어드바이스가 처리할 패키지 지정
@ControllerAdvice(basePackages= {"com.icia.aboard2.controller", "com.icia.aboard2.service"})
public class ABoardControllerAdvice {
	// UserNotFoundException 처리
	@ExceptionHandler(UserNotFoundException.class)
	public String UNFEHandler(UserNotFoundException unfe, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", unfe.getMessage());
		return "redirect:/";
	}
	
	// BoardNotFoundException 처리
	@ExceptionHandler(BoardNotFoundException.class)
	public String BNFEHandler(BoardNotFoundException bnfe, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", bnfe.getMessage());
		return "redirect:/";
	}
	
	// BindException 처리 : index.jsp에서 alert()으로 출력하므로 에러 메시지가 여러개면 곤란. 하나만 넘기자
	@ExceptionHandler(BindException.class)
	public String bindExceptionHandler(BindingResult result, RedirectAttributes ra) {
		List<ObjectError> list = result.getAllErrors();
		ObjectError oe = list.get(0);
		FieldError fe = (FieldError)oe;
		ra.addFlashAttribute("msg", fe.getField() + ":" + oe.getDefaultMessage());
		return "redirect:/";
	}
}
