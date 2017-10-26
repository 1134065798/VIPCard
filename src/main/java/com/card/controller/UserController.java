package com.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.card.service.IUserService;
import com.card.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping("/loadAll")
	public String loadAll() {
		List<User> List=userService.loadAll();
		return List.toString();
	}

}
