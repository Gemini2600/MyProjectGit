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
	//测试查询全部省的名字
	public static void testGetSheng(){
		AddressDao ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		System.out.println(ad.getSheng());
	}
	//通过省查询出市的名字
	public static void testGetShiByname(){
		AddressDao ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		System.out.println(ad.getShiByname("山西省"));
	}
}
