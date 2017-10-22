package com.card.spring.business;

import com.card.spring.entity.User;
import java.util.List;

public interface IUserService {
	public boolean checkUser(User user);
	public List<User> loadAll();
}
