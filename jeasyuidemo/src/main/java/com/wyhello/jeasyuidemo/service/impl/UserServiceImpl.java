package com.wyhello.jeasyuidemo.service.impl;

import java.util.List;

import com.wyhello.jeasyuidemo.dao.UserDAO;
import com.wyhello.jeasyuidemo.dao.impl.UserDAOImpl;
import com.wyhello.jeasyuidemo.pojo.User;
import com.wyhello.jeasyuidemo.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDao = new UserDAOImpl();
	
	public List<User> queryAllUser() {
		List<User> l = userDao.queryAll();
		return l;
	}

	public void addUser(User u) {
		userDao.add(u);
		
	}

}
