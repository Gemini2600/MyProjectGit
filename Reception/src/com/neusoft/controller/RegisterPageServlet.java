package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer;
import com.neusoft.services.RegisterService;

/**
 * Servlet implementation class RegisterPageServlet
 */
@WebServlet("/registerPageServlet.do")
public class RegisterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RegisterService rs=new RegisterService();
		
		String loginname = request.getParameter("loginname");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		String surepassword=request.getParameter("surepassword");
		if(password.equals(surepassword)){
			Consumer newConsuemr=new Consumer(loginname, surepassword, System.currentTimeMillis(),
					System.currentTimeMillis(), request.getRemoteAddr(),nickname,null,System.currentTimeMillis());
			rs.addConsumer(newConsuemr);
			response.sendRedirect("loginpage.jsp");
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
