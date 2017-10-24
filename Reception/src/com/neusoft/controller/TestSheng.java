package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neusoft.entity.Address;
import com.neusoft.services.AddressService;
import com.neusoft.utils.Escape;

/**
 * Servlet implementation class TestSheng
 */
@WebServlet("/testSheng.do")
public class TestSheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSheng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String shengname=request.getParameter("shengname");
		shengname=Escape.unescape(shengname);
		System.out.println(shengname);
		
		AddressService as=new AddressService();
		List<Address> list = as.getShiByname(shengname);
		System.out.println(list);

		
	     StringBuilder sb = new StringBuilder();
	     for(Address address: list){
	    	 sb.append(address.getName()+";");
	     }
	     String str = null;
	     if(sb.length()>0){
	    	 str = sb.substring(0,sb.length()-1);
	     }else{
	    	 str = sb.toString();
	     }
	     PrintWriter out=response.getWriter();
	     out.println(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
