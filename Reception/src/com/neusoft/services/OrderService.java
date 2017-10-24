package com.neusoft.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.neusoft.dao.OrderDao;
import com.neusoft.dao.impl.OrderDaoImpl;
import com.neusoft.entity.Order;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;

public class OrderService {
	OrderDao od=DbUtil.getInstance("orderDao", OrderDaoImpl.class);
	//��ҳ��ѯ
	public PageModel<Order> getPageModel(int pageNo,int pageSize){
		PageModel<Order>  pageModel=od.getPageModel(pageNo, pageSize);
		return pageModel;
	}
	//��ҳ��ѯҵ���߼�
	public void getOrderLogin(ServletRequest request,ServletResponse response) throws ServletException, IOException {
	    //����ҳ�ı�ǩ��ȡ
	   String pageNo=request.getParameter("pageNo");
	   String pageSize=request.getParameter("pageSize");
		
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			//����ֱ������Ϊ��һҳ��������������
//			int _pageNo=1;
//  		int _pageSize=5;
			System.out.println("�����ҳ��ѯ����չʾ");
			PageModel<Order>  orders=getPageModel(_pageNo,_pageSize);
			if(orders!=null) {
				int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
				orders.setTotalPageSize(totalPageSize);
				orders.setPageNo(_pageNo);
			}
			
			request.setAttribute("orders", orders);
			
			System.out.println("��תҳ��֮ǰ");
			request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}

//��ҳ��ʾ
	public void getShow(ServletRequest request,ServletResponse response) {
		try {
			
		//����ֱ������Ϊ��һҳ������4������
		int _pageNo=1;
  		int _pageSize=4;
		System.out.println("����չʾҳ��");
		PageModel<Order>  orders=getPageModel(_pageNo,_pageSize);
		if(orders!=null) {
			int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
			orders.setTotalPageSize(totalPageSize);
			orders.setPageNo(_pageNo);
		}

		request.setAttribute("orders", orders);
		
	    try {
			request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	}catch(NumberFormatException e) {
		e.printStackTrace();
	}
	}
	//��ҳ��ѯ��֧��������ɣ��Ѹ���ѷ���
	public  PageModel<Order> getPageModelStatus(int pageNo,int pageSize,int searchType) {
		
		PageModel<Order> pageModel=od.getPageModelStatus(pageNo, pageSize, searchType);
		   return pageModel;
	}

	//��ҳ��ѯ����
	public void getOrdersLogicStatus(ServletRequest request,ServletResponse response) {
			System.out.println("ִ������");
		    String pageNo=request.getParameter("pageNo");
			String pageSize=request.getParameter("pageSize");
			String searchType=request.getParameter("searchType");
			request.setAttribute("searchType",searchType);
			
			try {
				int _pageNo=Integer.parseInt(pageNo);
				int _pageSize=Integer.parseInt(pageSize);
				int _searchType=Integer.parseInt(searchType);
				System.out.println("�����ҳ��ѯ����չʾ");
				PageModel<Order>  orders=getPageModelStatus(_pageNo,_pageSize,_searchType);
				if(orders!=null) {
					int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
					orders.setTotalPageSize(totalPageSize);
					orders.setPageNo(_pageNo);
				}
				
				request.setAttribute("orders", orders);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
	}
	 //����¼����ֱ���ʾ��ͬ�Ķ���״̬
	public void getShowStatus(ServletRequest request,ServletResponse response) {
		
		String searchType=request.getParameter("searchType");
       	System.out.println("�����="+searchType);
		try {
			
			//����ֱ������Ϊ��һҳ������3������
			int _pageNo=1;
			int _pageSize=4;
			int _searchType=Integer.parseInt(searchType);

			System.out.println("����չʾҳ��");
			PageModel<Order>  orders=getPageModelStatus(_pageNo,_pageSize,_searchType);
			if(orders!=null) {
				int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
				orders.setTotalPageSize(totalPageSize);
				orders.setPageNo(_pageNo);
			}

			request.setAttribute("orders", orders);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}











}
