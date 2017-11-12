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
	public boolean saveUser(User user){
		boolean bool=false;
		if(userDao.insert(user)==1)bool=true;
		return bool;
	}
    public User loadUserByopenId(String openId){

        return userDao.loadUserByopenId(openId);
    }

	public boolean loadById(String openId) {
		User user=userDao.loadById(openId);
		System.out.println(user);
		return user!=null?true:false;
	}
}
