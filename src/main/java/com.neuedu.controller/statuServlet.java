package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class statuServlet
 */
@WebServlet("/statuServlet")
public class statuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public statuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	会话ID
		HttpSession session= request.getSession();
		String sessionid= session.getId();
		System.out.println(sessionid);
		System.out.println("会话失效时间"+session.getMaxInactiveInterval());
//		会话设置失效时间
		session.setMaxInactiveInterval(20);
		Object o =session.getAttribute("date");
		if(o==null) {
			session.setAttribute("date", System.currentTimeMillis());
		}
		
		System.out.println("date"+session.getAttribute("date"));
		
//	Object o =request.getAttribute("date");
//	if(o==null) {
//		request.setAttribute("date", System.currentTimeMillis());
//	}
//	
//	System.out.println("date"+request.getAttribute("date"));
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
