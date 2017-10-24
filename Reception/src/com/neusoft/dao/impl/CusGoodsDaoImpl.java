package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.CusGoodsDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.CustGoodsBean;
import com.neusoft.utils.ConnectionFactory;

public class CusGoodsDaoImpl implements CusGoodsDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
	 * 添加买家收货地址
	 */
	@Override
	public CustGoodsBean addCusGoods(CustGoodsBean cb) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "insert into consumer_addr(name,addr,phone,provice,city,area,addrd) values(?,?,?,?,?,?,?)";
			ResultSetHandler<Long> rsh = new ScalarHandler<>();
			Object obj[] = {cb.getName(),cb.getAddr(),cb.getPhone(),cb.getProvice(),cb.getCity(),cb.getArea(),cb.getAddrd()};
			int val = qr.insert(conn, sql, rsh, obj).intValue();
			if(val>0){
				return new CustGoodsBean(cb.getName(),cb.getAddr(),cb.getPhone(),cb.getProvice(),cb.getCity(),cb.getArea(),cb.getAddrd());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("添加地址失败", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
		 /**
		  * 查询收货地址根据名字
		  */
		@Override
		public CustGoodsBean queryCus(String name) throws DaoException {
			try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,name,addr,phone,provice,city,area,addrd from consumer_addr where name=?";
			ResultSetHandler<CustGoodsBean> rsh = new BeanHandler<>(CustGoodsBean.class);
				CustGoodsBean cgb = qr.query(conn, sql, rsh, name);
				if(cgb!=null)
				{
					return cgb;
				}
			} catch (SQLException e) {
				throw new DaoException("查询地址失败", e);
			}finally
			{
				DbUtils.closeQuietly(conn);
			}
			return null;
		}

}
