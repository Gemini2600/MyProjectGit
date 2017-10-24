package com.neusoft.services;

import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.entity.Consumer;
import com.neusoft.utils.DbUtil;

public class RegisterService {
	ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
	
	//����consumer��loginname��ѯconsumer
	public Consumer getConsumerByName(String loginname){
		return cd.getConsumerByLoginName(loginname);
	}
	//consumerע��
	public boolean addConsumer(Consumer consumer){
		return cd.addConsumer(consumer);
	} 
}
