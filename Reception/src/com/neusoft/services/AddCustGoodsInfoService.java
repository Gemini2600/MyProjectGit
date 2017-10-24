package com.neusoft.services;

import com.neusoft.dao.CusGoodsDao;
import com.neusoft.dao.impl.CusGoodsDaoImpl;
import com.neusoft.entity.CustGoodsBean;
import com.neusoft.utils.DbUtil;

public class AddCustGoodsInfoService {
	CusGoodsDao  cgd=DbUtil.getInstance("cusGoodsDao", CusGoodsDaoImpl.class);
	/*
	 * 添加收货地址
	 */
	public CustGoodsBean addCust(CustGoodsBean cgb)
	{
		return cgd.addCusGoods(cgb);
	}
	/*
	 * 查选收货地址根据名字
	 */
	public CustGoodsBean queryCust(String name)
	{
		return cgd.queryCus(name);
	}
}
