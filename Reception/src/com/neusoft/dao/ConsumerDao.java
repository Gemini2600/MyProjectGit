
package com.neusoft.dao;
import java.util.List;

import com.neusoft.entity.Consumer;
import com.neusoft.entity.PageModel;

public interface ConsumerDao {
	//查询全部会员
	public List<Consumer> getConsumerList();
	//添加买家
	public boolean addConsumer(Consumer consumer) throws DaoException;
	//删除买家
	public boolean deleteConsumer(Integer id) throws DaoException;
	//修改买家
	public boolean updateConsumer(Consumer consumer) throws DaoException;
	//查询买家
	public Consumer getConsumer(Integer id) throws DaoException;
	//分页
	public PageModel<Consumer> getPageModel(int pageNo,int pageSize) throws DaoException;
	//根据用户名查询买家
	public Consumer getConsumerByLoginName(String loginname);
	//根据用户名和密码查询买家
	public Boolean queryConsumer(Consumer consumer);
	/**
	 * 根据用户名查询密码
	 */
	public Consumer queryPswByUsername(String loginname);
	/**
	 * 根据用户名修改密码
	 * 
	 */
	public Consumer updatePsw(String loginname,String password);
	
	
}
