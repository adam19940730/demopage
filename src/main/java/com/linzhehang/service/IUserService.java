package com.linzhehang.service;

import java.util.List;

import com.linzhehang.bean.Page;
import com.linzhehang.bean.User;

public interface IUserService {

	void save(User user);
	void update(User user);
	void delete(Integer id);
	User findOne(Integer id);
	List<User> findAll();
	
	Page<User> findAllUserByPage(int p,int size);
	
}
