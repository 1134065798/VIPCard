package com.card.dao;

import com.card.entity.User;

import java.util.List;

public interface IUserDao {

	public List<User> loadAll();
	public User loadUserByopenId(String openId);
	public int insert(User user);
	public User loadById(String openId);
}
