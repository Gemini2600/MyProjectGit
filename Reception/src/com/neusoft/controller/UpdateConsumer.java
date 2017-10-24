package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer;
import com.neusoft.services.LoginService;

/**
 * Servlet implementation class UpdateConsumer
 */
@WebServlet("/updateConsumer.do")
public class UpdateConsumer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConsumer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("user");
		String psw = request.getParameter("psw");
		System.out.println("username1+"+username);
		System.out.println("psw=="+psw);
		
		LoginService ls = new LoginService();
		Consumer consumer=ls.updateUsers(username, psw);
		if(consumer!=null){
			response.getWriter().write("<script>alert(\"ÐÞ¸Ä³É¹¦\")</script>");
			request.getRequestDispatcher("updateconsumer.jsp").forward(request, response);
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
