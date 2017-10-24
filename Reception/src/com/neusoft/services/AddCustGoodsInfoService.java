package com.neusoft.services;

import com.neusoft.dao.CusGoodsDao;
import com.neusoft.dao.impl.CusGoodsDaoImpl;
import com.neusoft.entity.CustGoodsBean;
import com.neusoft.utils.DbUtil;

public class AddCustGoodsInfoService {
	CusGoodsDao  cgd=DbUtil.getInstance("cusGoodsDao", CusGoodsDaoImpl.class);
	/*
	 * ����ջ���ַ
	 */
	public CustGoodsBean addCust(CustGoodsBean cgb)
	{
		return cgd.addCusGoods(cgb);
	}
	/*
	 * ��ѡ�ջ���ַ��������
	 */
	public CustGoodsBean queryCust(String name)
	{
		return cgd.queryCus(name);
	}
}
