package com.card.service;

import com.card.entity.User;
import java.util.List;

public interface IUserService {
	public List<User> loadAll();
    public boolean saveUser(User user);
    public User loadUserByopenId(String openId);
	public boolean loadById(String openId);
}
