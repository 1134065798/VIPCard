package com.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.service.IUserService;
import com.card.dao.IUserDao;
import com.card.entity.User;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	public List<User> loadAll(){
		return userDao.loadAll();
	}
}
