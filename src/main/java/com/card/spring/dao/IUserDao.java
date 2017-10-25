package com.card.spring.dao;

import com.card.spring.entity.User;

import java.util.List;

public interface IUserDao {
	public User loadUser(User user);
	public List<User> loadAll();
}
