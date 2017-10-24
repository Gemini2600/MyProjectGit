package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.services.CateService;

/**
 * Servlet implementation class CateServlet
 */
@WebServlet("/cServlet.do")
public class CateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		CateService cs=new CateService();
		String reqType=request.getParameter("reqType");
		//ɾ������
		String delet_cid=request.getParameter("delet_cid");
		
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//����ɾ����������     �����Ҵ����쳣
				try{
					int delcid=Integer.parseInt(delet_cid);
					cs.delRegion(delcid);
					cs.disReqType2(request, response);
				
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("productcate.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//������ѯ��������    �����Ҵ����쳣
				try{
					cs.getCateLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
//						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			}
		}else{
			cs.disReqType2(request, response);
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