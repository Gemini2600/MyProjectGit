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
		 * ������Ϣ
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
		
		//��ӵ�consumer_addr
		CustGoodsBean cgb = new CustGoodsBean(name, sheng+shi+xian+detail, phone, sheng, shi,xian, detail);
		AddCustGoodsInfoService acgi = new AddCustGoodsInfoService();
		System.out.println(cgb);
		CustGoodsBean cg = acgi.addCust(cgb);
		CustGoodsBean cg2 = acgi.queryCust(cg.getName());
		/**
		 * �ջ���Ϣ��id
		 */
		int pid = cg2.getId();
		System.out.println("�ջ���Ϣ��id:"+pid);
		/**
		 * ������Ϣ
		 */
		//����id
		String oid = request.getParameter("oid");
		System.out.println("������idΪ:"+oid);
		/**
		 * ��Ʒ��Ϣ
		 * �����Ʒ��Ϣ
		 */
	
	/**
	 * 	orderno  varchar(50) not null, -- �������
		orderstatus int ,-- ����״̬  1:δ����2���Ѹ��� 3.�ѷ���  4�����
		paystatus   int,  -- 1.����֧��  2.��������
		ordertime bigint ,-- �µ�ʱ��
		paytime bigint ,-- ����ʱ��
		addrinfo  int, -- �ջ�����Ϣ:������aosumer_addr���е�id
		mask     varchar(200) -- ��ע��Ϣ
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
			 * ��ȡ����id
			 */
			System.out.println("��Ӷ����ɹ�");
			Orderinfo orderB = ois.queryOrder(orderId);
			System.out.println("������Ϣ:"+orderB);
			int ob = orderB.getId();
			System.out.println("����id:"+ob);
			
		// �����Ʒ
		Enumeration<String> s=request.getSession().getAttributeNames();
			while(s.hasMoreElements()){
			          Object obj =  request.getSession().getAttribute(s.nextElement());
			          System.out.println("���е���Ʒ"+obj);
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
			System.out.println("�����Ʒ�ɹ�");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else
		{
			System.out.println("��Ӷ���ʧ��");
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
