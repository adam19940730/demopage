package com.linzhehang.dao;

import java.util.List;

import com.linzhehang.bean.User;

public interface IUserDao {

	void save(User user);
	void update(User user);
	void delete(Integer id);
	User findOne(Integer id);
	List<User> findAll();
	//获取该类页面的总行数
	int getCountRow();
	//获取分页数据
	List<User> findAllByPage(int startLine,int size);
}
