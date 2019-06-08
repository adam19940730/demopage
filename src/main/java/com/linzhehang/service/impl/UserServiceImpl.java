package com.linzhehang.service.impl;

import java.util.List;

import com.linzhehang.bean.Page;
import com.linzhehang.bean.User;
import com.linzhehang.dao.IUserDao;
import com.linzhehang.dao.impl.UserDaoImpl;
import com.linzhehang.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();
	
	@Override
	public void save(User user) {
		dao.save(user);

	}

	@Override
	public void update(User user) {
		dao.update(user);

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);

	}

	@Override
	public User findOne(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<User> findAllUserByPage(int p, int size) {
		int countRow = dao.getCountRow();
		Page<User> page = new Page<User>(p,size,countRow);
		List<User> list = dao.findAllByPage(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
