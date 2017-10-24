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

import com.neusoft.dao.DaoException;
import com.neusoft.dao.OrderInfoDao;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product_orderInfo;
import com.neusoft.utils.ConnectionFactory;

public class OrderInfoDaoImpl implements OrderInfoDao{
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	PreparedStatement pstmt = null;
    ResultSet rs = null;
	@Override
	public Boolean addOrderInfo(Orderinfo ob) throws DaoException {
		
		try {
		conn = ConnectionFactory.getConnection();
		String sql = "insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask)values(?,?,?,?,?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		Object obj[] = {ob.getOrderno(),ob.getOrderstatus(),ob.getPaystatus(),ob.getOrdertime(),ob.getPaytime(),ob.getAddrinfo(),ob.getMask()};
		
			int val = qr.insert(conn, sql, rsh, obj).intValue();
			if(val>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ÃÌº”∂©µ• ß∞‹", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public Orderinfo queryOrder(String orderno) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id from orderinfo where orderno = ?";
			ResultSetHandler<Orderinfo> rsh = new BeanHandler<>(Orderinfo.class);
			Orderinfo oobb = qr.query(conn, sql, rsh, orderno);
			if(oobb!=null)
			{
				return oobb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø∂©µ• ß∞‹", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@Override
	public Boolean addSAndOid(Product_orderInfo po) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "insert into product_orderinfo(orderid,productid) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, po.getOrderid());
			pstmt.setInt(2, po.getProductid());
			int val = pstmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ÃÌº”∏±±Ì ß∞‹", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

}
