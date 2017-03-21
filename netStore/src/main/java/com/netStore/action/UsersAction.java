package com.netStore.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netStore.pojo.Users;
import com.netStore.service.UsersService;

@Controller
public class UsersAction {
	//自动注入 
	@Autowired
	public UsersService usersService;


	@RequestMapping("/login1")
	public String login(){
		
		
		
		return "users/list_books";
		
	}

}
