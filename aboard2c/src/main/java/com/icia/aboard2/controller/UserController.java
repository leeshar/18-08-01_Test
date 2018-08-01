package com.icia.aboard2.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.aboard2.dto.*;
import com.icia.aboard2.dto.UserDto.*;
import com.icia.aboard2.service.*;
import com.icia.aboard2.util.*;

import lombok.*;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/users/join")
	public String join() {
		return "users/join";
	}
	@PostMapping("/users")
	public String join(@Valid CreateUser create, BindingResult results, RedirectAttributes ra) throws BindException {
		ABoard2Util.throwBindException(results);
		service.join(create);
		ra.addFlashAttribute("msg", ABoard2Contstants.WELCOME);
		return "redirect:/";
	}
	@GetMapping("/users/{id}")
	public String read(@PathVariable String id, Model model) {
		id = "hasaway";
		model.addAttribute("user", service.read(id));
		return "users/read";
	}
	
	// 유저 정보 변경 : update
	@PostMapping("/users/update")
	public String update(@Valid UserDto.UpdateUser user, BindingResult results, RedirectAttributes ra) throws BindException {
		ABoard2Util.throwBindException(results);
		service.update(user);
		ra.addFlashAttribute("msg", "정보를 변경했습니다");
		return "redirect:/";
	}
}




