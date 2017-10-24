package com.neusoft.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.CartItem;
import com.neusoft.entity.CustGoodsBean;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product_orderInfo;
import com.neusoft.entity.ShoppingBag;
import com.neusoft.services.AddCustGoodsInfoService;
import com.neusoft.services.OrderInfoService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orderInfoServlet.do")
public class OrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		/**
		 * 订单信息
		 */
		
		String name = request.getParameter("name");
		
		String phone = request.getParameter("phone");
		
		String sheng = request.getParameter("sheng");
		//System.out.println(sheng);
		String shi = request.getParameter("shi");
		System.out.println(shi);
		String xian = request.getParameter("xian");
		System.out.println(xian);
		String detail = request.getParameter("detailInfo");
		
		//添加到consumer_addr
		CustGoodsBean cgb = new CustGoodsBean(name, sheng+shi+xian+detail, phone, sheng, shi,xian, detail);
		AddCustGoodsInfoService acgi = new AddCustGoodsInfoService();
		System.out.println(cgb);
		CustGoodsBean cg = acgi.addCust(cgb);
		CustGoodsBean cg2 = acgi.queryCust(cg.getName());
		/**
		 * 收货信息的id
		 */
		int pid = cg2.getId();
		System.out.println("收货信息的id:"+pid);
		/**
		 * 订单信息
		 */
		//订单id
		String oid = request.getParameter("oid");
		System.out.println("订单的id为:"+oid);
		/**
		 * 商品信息
		 * 添加商品信息
		 */
	
	/**
	 * 	orderno  varchar(50) not null, -- 订单编号
		orderstatus int ,-- 订单状态  1:未付款2：已付款 3.已发货  4已完成
		paystatus   int,  -- 1.线上支付  2.货到付款
		ordertime bigint ,-- 下单时间
		paytime bigint ,-- 付款时间
		addrinfo  int, -- 收货人信息:引用子aosumer_addr表中的id
		mask     varchar(200) -- 备注信息
	 */
		String orderId = request.getParameter("oid");
		String payStyle = request.getParameter("payStyle");
		int ps = Integer.parseInt(payStyle);
		String info = request.getParameter("info");
		OrderInfoService ois=new OrderInfoService();
		Orderinfo orderInfo=new Orderinfo(oid,1, ps, System.currentTimeMillis(), System.currentTimeMillis(), pid, info);
		System.out.println(orderInfo);
		Boolean result = ois.addOrderInfo(orderInfo);
		if(result.equals(true))
		{
			/**
			 * 获取订单id
			 */
			System.out.println("添加订单成功");
			Orderinfo orderB = ois.queryOrder(orderId);
			System.out.println("订单信息:"+orderB);
			int ob = orderB.getId();
			System.out.println("订单id:"+ob);
			
		// 添加商品
		Enumeration<String> s=request.getSession().getAttributeNames();
			while(s.hasMoreElements()){
			          Object obj =  request.getSession().getAttribute(s.nextElement());
			          System.out.println("所有的商品"+obj);
			          if(obj instanceof ShoppingBag)
			          {
			        	  ShoppingBag sb = (ShoppingBag)obj;
			        	  Map<Integer,CartItem> map=sb.getMap();
			        	 Set<Integer> keys=map.keySet();
			        	 for (Integer key: keys) {
							System.out.println(key);
							boolean flag= ois.addSAndOid(new Product_orderInfo(ob, map.get(key).getProduct().getId()));
							System.out.println(flag);
			        	 }
			        	 
			          }
					}
			System.out.println("添加商品成功");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else
		{
			System.out.println("添加订单失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
