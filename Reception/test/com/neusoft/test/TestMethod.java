package com.neusoft.test;

import java.util.List;

import com.neusoft.dao.AddressDao;
import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.impl.AddressDaoImpl;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.utils.DbUtil;

public class TestMethod {

	public static void main(String[] args) {
//		testGetConsumerByLoginName();
//		testGetSheng();
		testGetShiByname();
	}
	public static void testGetConsumerByLoginName(){
		ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
		System.out.println(cd.getConsumerByLoginName("servlet05"));
	}
	//���Բ�ѯȫ��ʡ������
	public static void testGetSheng(){
		AddressDao ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		System.out.println(ad.getSheng());
	}
	//ͨ��ʡ��ѯ���е�����
	public static void testGetShiByname(){
		AddressDao ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		System.out.println(ad.getShiByname("ɽ��ʡ"));
	}
}
