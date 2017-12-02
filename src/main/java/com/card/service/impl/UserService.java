package com.card.service.impl;

import com.card.dao.IUserDao;
import com.card.entity.User;
import com.card.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Transactional(propagation= Propagation.REQUIRES_NEW,
			isolation= Isolation.READ_COMMITTED,
			readOnly=true, timeout=60000)
	public List<User> loadAll(){
		return userDao.loadAll();
	}

	@Transactional(propagation= Propagation.REQUIRED,timeout=60000)
	public boolean saveUser(User user){
		boolean bool=false;
		if(userDao.saveUser(user)==1)bool=true;
		return bool;
	}

	@Transactional(propagation= Propagation.REQUIRES_NEW,
			isolation= Isolation.READ_COMMITTED,
			readOnly=true, timeout=60000)
    public User loadUserByopenId(String openId){

        return userDao.loadUserByopenId(openId);
    }

	@Transactional(propagation= Propagation.REQUIRES_NEW,
			isolation= Isolation.READ_COMMITTED,
			readOnly=true, timeout=60000)
	public boolean loadById(String openId) {
		User user=userDao.loadById(openId);
		return user!=null?true:false;
	}
}
