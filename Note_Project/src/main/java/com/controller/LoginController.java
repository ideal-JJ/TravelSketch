package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Login;
import com.dto.Member;
import com.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService mService;
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("kkk") Login x, BindingResult errors, Model xxx, HttpSession session) {
		
		if (errors.hasErrors()) {
			return "loginForm";
		} else {
			Member m = mService.login(x); 
			if (m == null) {
				xxx.addAttribute("mesg", "아이디 또는 비밀번호를 틀렸습니다");
				return "home";
			} else {
				session.setAttribute("login", m);
				return "home";
			}
		}
	}
}
