package com.linzhehang.web.action;

import org.apache.struts2.ServletActionContext;

import com.linzhehang.bean.Page;
import com.linzhehang.bean.User;
import com.linzhehang.myproxy.ActionInvocation;
import com.linzhehang.myproxy.Interceptor;
import com.linzhehang.myproxy.MyProxy;
import com.linzhehang.service.IUserService;
import com.linzhehang.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private IUserService service = new UserServiceImpl();
	private int pg;
	private int size;

	public String save() {
		MyProxy mp = new MyProxy();
		IUserService proxy = (IUserService) mp.getProxy(service, new Interceptor() {

			@Override
			public Object intercept(ActionInvocation invocation) throws Exception {
				Object invoke = null;
				if (user.getName() != null && user.getName().length() > 0 && user.getName().length() <= 5) {
					invoke = invocation.invoke();

				}
				else {
					throw new RuntimeException("姓名长度必须小于5！");
				}
				return invoke;
			}

			@Override
			public void init() {
				// TODO Auto-generated method stub

			}

			@Override
			public void destory() {
				// TODO Auto-generated method stub

			}
		});
		proxy.save(user);
		return "find";
	}

	public String find() {
		if (pg == 0) {
			pg = 1;
		}
		if (size == 0) {
			size = 10;
		} 
		Page<User> page = service.findAllUserByPage(pg, size);
		ServletActionContext.getRequest().setAttribute("page", page);
		System.out.println(page); 
		return "findUI"; 
	}

	public String delete() {
		MyProxy mp = new MyProxy();
		User targetUser = service.findOne(user.getId());
		IUserService proxy = (IUserService) mp.getProxy(service, new Interceptor() {

			@Override
			public Object intercept(ActionInvocation invocation) throws Exception {
				Object invoke = null;
				if (targetUser.getMoney() >= 0 && targetUser.getMoney() <= 1000) {
					invoke = invocation.invoke();
				} else {
					throw new RuntimeException("无法删除金额大于1000的用户");
				}
				return invoke;
			}

			@Override
			public void init() {
				// TODO Auto-generated method stub

			}

			@Override
			public void destory() {
				// TODO Auto-generated method stub

			}
		});
		proxy.delete(user.getId());
		return "find";
	}

	public String update() {
		service.update(user);
		return "find";
	}

	public String updateUI() {
		ServletActionContext.getRequest().setAttribute("user", service.findOne(user.getId()));
		return "updateUI";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
