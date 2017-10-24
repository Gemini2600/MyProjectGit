package com.neusoft.services;


import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.entity.Consumer;
import com.neusoft.utils.DbUtil;

/**
 * ҵ���߼���
 * */
public class LoginService {
	ConsumerDao cd =DbUtil.getInstance("consumerDao",ConsumerDaoImpl.class);
	/**
	 * ����˻�
	 */
	public boolean addConsumer(Consumer consumer){
		return cd.addConsumer(consumer);
	}
	/**
	 * ��¼�˻�
	 */
	public Boolean loginConsumer(Consumer consumer)
	{
		return cd.queryConsumer(consumer);
	}
	/**
	 * �����û����ж��Ƿ�����û�
	 */
	public Consumer queryUserByName(String loginname)
	{
		return cd.getConsumerByLoginName(loginname);
	}
	/**
	 * �����û�����ѯ����
	 */
	public Consumer queryPswByUsername(String loginname)
	{
		return cd.queryPswByUsername(loginname);
	}
	
	/**
	 * �޸��û���������
	 */
	public Consumer updateUsers(String loginname,String password)
	{
		return cd.updatePsw(loginname, password);
	}
	
}
