package com.card.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.card.spring.business.IUserService;
import com.card.spring.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/loginHandler")
	public String loginHandler(User user) {
		boolean bool=userService.checkUser(user);
		return bool?"redirect:loadAll":"error";
	}
	@ResponseBody
	@RequestMapping("/loadAll")
	public String loadAll() {
		List<User> List=userService.loadAll();
		return List.toString();
	}

}
