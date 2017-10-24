package com.neusoft.dao;

import com.neusoft.entity.Order;
import com.neusoft.entity.PageModel;

public interface OrderDao {
	//分页查询
	public PageModel<Order> getPageModel(int pageNo,int pageSize);
	//分页查询订单状态
	public PageModel<Order> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
