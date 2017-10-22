package com.card.spring.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.spring.business.IUserService;
import com.card.spring.dao.IUserDao;
import com.card.spring.entity.User;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	public boolean checkUser(User user) {
		User u=userDao.loadUser(user);
		return u!=null?true:false;
	}
	public List<User> loadAll(){
		return userDao.loadAll();
	}
}
