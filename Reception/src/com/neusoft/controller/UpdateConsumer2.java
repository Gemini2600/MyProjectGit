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
 * Servlet implementation class UpdateConsumer2
 */
@WebServlet("/updateConsumer2.do")
public class UpdateConsumer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConsumer2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("uName");
		String psw = request.getParameter("password");
		System.out.println("username="+username);
		System.out.println("√‹¬Îµ»”⁄="+psw);
		
		
		LoginService ls=new LoginService();
		Consumer consumer=new Consumer(username, psw);
		Boolean result=ls.loginConsumer(consumer);
		
		String responseText ;
		if(result.equals(true))
		{
			responseText = "√‹¬Î’˝»∑";
		}else
		{
			responseText= "√‹¬Î¥ÌŒÛ";
		}
		response.getWriter().write(responseText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
