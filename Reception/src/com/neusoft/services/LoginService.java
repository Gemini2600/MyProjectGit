package com.neusoft.services;


import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.entity.Consumer;
import com.neusoft.utils.DbUtil;

/**
 * 业务逻辑层
 * */
public class LoginService {
	ConsumerDao cd =DbUtil.getInstance("consumerDao",ConsumerDaoImpl.class);
	/**
	 * 添加账户
	 */
	public boolean addConsumer(Consumer consumer){
		return cd.addConsumer(consumer);
	}
	/**
	 * 登录账户
	 */
	public Boolean loginConsumer(Consumer consumer)
	{
		return cd.queryConsumer(consumer);
	}
	/**
	 * 根据用户名判断是否存在用户
	 */
	public Consumer queryUserByName(String loginname)
	{
		return cd.getConsumerByLoginName(loginname);
	}
	/**
	 * 根据用户名查询密码
	 */
	public Consumer queryPswByUsername(String loginname)
	{
		return cd.queryPswByUsername(loginname);
	}
	
	/**
	 * 修改用户名和密码
	 */
	public Consumer updateUsers(String loginname,String password)
	{
		return cd.updatePsw(loginname, password);
	}
	
}
