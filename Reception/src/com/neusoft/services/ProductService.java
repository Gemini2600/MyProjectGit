package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.neusoft.dao.DaoException;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.dao.impl.ProductDaoImpl;
import com.neusoft.dao.impl.RuleDaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DbUtil;

public class ProductService {
	ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
	
	//查询商品
	public PageModel<Product> getProductByPage(int pageNo,int pageSize){
		return pd.getPageModel(pageNo, pageSize);
	}
	//查询业务逻辑
	public void getProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		
		int _pageNo=Integer.parseInt(pageNo);
		int _pageSize=Integer.parseInt(pageSize);

		PageModel<Product> products=getProductByPage(_pageNo, _pageSize);
		
//		System.out.println(products);
		if(products!=null){
			int totalPageSize=(products.getTotalcount()%_pageSize==0 ? products.getTotalcount()/_pageSize : products.getTotalcount()/_pageSize+1);
			products.setTotalPageSize(totalPageSize);
			products.setPageNo(_pageNo);
		}
		request.setAttribute("products", products);
	
	}
	//查询全部商品
	public List<Product> getProductList(){
		List<Product>products=pd.getProductList();
		if(products.size()>0){
			return products;
		}
		return null;
	}
	/**
	 * 显示reqType=2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void disReqType2(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		int _pageNo=1;
		int _pageSize=4;
		PageModel<Product> products=getProductByPage(_pageNo, _pageSize);
		
		if(products!=null){
			int totalPageSize=(products.getTotalcount()%_pageSize==0 ? products.getTotalcount()/_pageSize : products.getTotalcount()/_pageSize+1);
			products.setTotalPageSize(totalPageSize);
			products.setPageNo(_pageNo);
		}
		
		request.setAttribute("products", products);
	}
	//根据名字  模糊查询商品
	public PageModel<Product> queryProductByName(String pname)
	{
		return pd.queryProductByName(pname);
	}
	
	
}
