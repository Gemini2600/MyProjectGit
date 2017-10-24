package com.neusoft.services;

import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.entity.Consumer;
import com.neusoft.utils.DbUtil;

public class RegisterService {
	ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
	
	//根据consumer的loginname查询consumer
	public Consumer getConsumerByName(String loginname){
		return cd.getConsumerByLoginName(loginname);
	}
	//consumer注册
	public boolean addConsumer(Consumer consumer){
		return cd.addConsumer(consumer);
	} 
}
