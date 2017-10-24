package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Consumer;
import com.neusoft.services.RegisterService;

/**
 * Servlet implementation class RegisterVerifyServlet
 */
@WebServlet("/registerVerifyServlet.do")
public class RegisterVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String loginname = request.getParameter("loginname");
		System.out.println("loginname=" + loginname);
		
		RegisterService rs=new RegisterService();
		Consumer consumer=rs.getConsumerByName(loginname);
		
		PrintWriter pw = response.getWriter();
		
		if(consumer!=null){
			String tip = "<font color='red'>该用户已存在</font>";
			pw.write(tip);
		}else{
			String tip = "<font color='green'>可以注册</font>";
			pw.write(tip);
		}
		
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
