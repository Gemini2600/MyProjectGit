package com.neusoft.dao;

import com.neusoft.entity.Order;
import com.neusoft.entity.PageModel;

public interface OrderDao {
	//��ҳ��ѯ
	public PageModel<Order> getPageModel(int pageNo,int pageSize);
	//��ҳ��ѯ����״̬
	public PageModel<Order> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
