package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.services.ProductService;

/**
 * Servlet implementation class LoginHomeServlet
 */
@WebServlet("/loginHomeServlet.do")
public class LoginHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ProductService ps=new ProductService();
		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					ps.getProductLogin(request, response);
					request.getRequestDispatcher("loginhome.jsp").forward(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			ps.disReqType2(request, response);
			request.getRequestDispatcher("loginhome.jsp").forward(request, response);
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
