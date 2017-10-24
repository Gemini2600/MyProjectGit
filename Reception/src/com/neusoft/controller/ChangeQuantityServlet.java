package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.ShoppingBag;
import com.neusoft.services.ShoppingBagService;

/**
 * Servlet implementation class ChangeQuantitySevlet
 */
@WebServlet("/changeQuantityServlet.do")
public class ChangeQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeQuantityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ShoppingBagService sbs=new ShoppingBagService();
		
		HttpSession session=request.getSession();
		if(session.isNew()){
			System.out.println(session.getId());
		}
		
		int sid=Integer.parseInt(request.getParameter("id"));
        System.out.println("sid="+sid);
        int quantity =Integer.parseInt(request.getParameter("quantity"));  
        ShoppingBag shoppingBag= (ShoppingBag)session.getAttribute("shoppingBag");  
        sbs.changeQuantity(sid, quantity, shoppingBag); 
          
	    request.getRequestDispatcher("shoppingbag.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
