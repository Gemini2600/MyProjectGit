package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Consumer;
import com.neusoft.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		
		LoginService ls = new LoginService();
		
		Boolean result = ls.loginConsumer(new Consumer(loginname, password));
		Consumer consumer= new Consumer(loginname, password, System.currentTimeMillis(), System.currentTimeMillis(), request.getRemoteAddr());
		
		if(result)
		{
			session.setAttribute("consumer", consumer);
			request.getRequestDispatcher("loginHomeServlet.do").forward(request, response);
		}else
		{
			System.out.println("µÇÂ¼Ê§°Ü");
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
