package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;
import com.neusoft.services.ShoppingBagService;

/**
 * Servlet implementation class ShoppingBagServlet
 */
@WebServlet("/shoppingBagServlet.do")
public class ShoppingBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingBagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println(1);
		ShoppingBagService sbs=new ShoppingBagService();
		
		HttpSession session=request.getSession();
		if(session.isNew()){
			System.out.println(session.getId());
		}
		
		
//		String pname=request.getParameter("pname");
//		System.out.println(request.getParameter("price"));
//		double price=Double.parseDouble(request.getParameter("price"));
//		int amount=Integer.parseInt(request.getParameter("amount"));
		//1.获取要买的商品
		System.out.println(request.getParameter("ype"));
		int sid=Integer.parseInt(request.getParameter("ype"));
         System.out.println(sid);
        Product product= sbs.findProduct(sid);
        //2.得到购物车  
        ShoppingBag shoppingBag=(ShoppingBag)session.getAttribute("shoppingBag");  
        if(shoppingBag==null){  
            shoppingBag=new ShoppingBag();  
            session.setAttribute("shoppingBag", shoppingBag);  
        }  
        //3.把商品添加到购物车中  
        shoppingBag.add(product);  
        //response.sendRedirect("homeServlet.do"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
