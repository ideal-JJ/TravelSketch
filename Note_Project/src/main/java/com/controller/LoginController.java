package com.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Chart;
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
				
				if (m.getUserid().equals("admin") && m.getPasswd().equals("1234")) {
					// 관리자
					return "admin";
				} else {
					return "redirect:/note";
				}
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("log out !!!");
		session.invalidate();
		return "redirect:/note";
	}
	
	@RequestMapping(value = "/chart" , method=RequestMethod.POST)
	public @ResponseBody List chart() {
		Chart chart = mService.chartSelect();
//		List<HashMap<String, Integer>> temp = new ArrayList<HashMap<String, Integer>>(); 
		
		List mapList = new ArrayList();
		
		
		try{
	        Object obj = chart;
	        for (Field field : obj.getClass().getDeclaredFields()){
	        	field.setAccessible(true);
	            Object value = field.get(obj);
	            
//	            System.out.println(field.getName());
	            Map map = new HashMap();
				
				String areaName = "";
	            switch (field.getName()) {
					case "Seoul":
						areaName = "서울";
						break;	
					case "Gyeonggi":
						areaName = "경기";
						break;
					case "Gangwon":
						areaName = "강원";
						break;
					case "Chungcheongbuk":
						areaName = "충북";
						break;
					case "Chungcheongnam":
						areaName = "충남";
						break;
					case "Jeollabuk":
						areaName = "전북";
						break;
					case "Jeollanam":
						areaName = "전남";
						break;
					case "Gyeongsangbuk":
						areaName = "경북";
						break;
					case "Gyeongsangnam":
						areaName = "경남";
						break;
					case "Cheju":
						areaName = "제주";
						break;
				}
	    		map.put("x", areaName);
	    		map.put("y", Integer.parseInt(value.toString()));
	    		mapList.add(map);
	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }
		
		return mapList;
	}
}
