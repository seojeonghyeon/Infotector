package com.lime_it.infotector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lime_it.infotector.model.User;
import com.lime_it.infotector.repo.UserRepository;

@Controller
public class LoginController {
	@Autowired
	UserRepository repository;

	@PostMapping("/login/web")
	public String LoginUser(@RequestParam("user") User user) {
		List<User> users = repository.findByUser_Email(user.getUser_Email());
		if (users.size() == 0) {
			// 데이터가 없음을 사용자에게 알림
			return "redirect:/";
		}
		//로그인 화면으로 이동
		return "";

	}

	@PostMapping("/regist/web")
	public String RegistUser(@RequestParam("user") User user){
		List<User> users = repository.findByUser_Email(user.getUser_Email());
		if(users.size()==0){
			return "";
		}
		return "";
	}
}
