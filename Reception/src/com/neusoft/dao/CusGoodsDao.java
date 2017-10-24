package com.neusoft.dao;

import com.neusoft.entity.CustGoodsBean;

public interface CusGoodsDao {

	/**
	 * ����ջ���ַ
	 * @param cb
	 * @return
	 * @throws PersonalException
	 */
	public CustGoodsBean addCusGoods(CustGoodsBean cb) throws DaoException;
	
	/**
	 * ��ѯ�ջ���ַ
	 * ��������
	 */
	public CustGoodsBean queryCus(String name) throws DaoException;
}
