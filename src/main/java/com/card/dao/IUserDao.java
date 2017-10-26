package com.card.dao;

import com.card.entity.User;

import java.util.List;

public interface IUserDao {
	public List<User> loadAll();
}
