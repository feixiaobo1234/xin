package com.nenude.controller.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class FrontLogin
 */
@WebServlet("/FrontLogin")
public class FrontLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String method = request.getParameter("method");
		ILoginService  loginService = new LoginServiceImpl();
		Account acc = loginService.doLogin(username, password);
		if(acc!=null) {
			
//			StringBuffer sb = new StringBuffer("{");
//			//用户名
//			sb.append("\"");
//			sb.append("username");
//			sb.append("\"");
//			sb.append(":");
//			sb.append("\"");
//			sb.append(acc.getUsername());
//			sb.append("\"");
//			sb.append(",");
//			
//			//密码
//			sb.append("\"");
//			sb.append("password");
//			sb.append("\"");
//			sb.append(":");
//			sb.append("\"");
//			sb.append(acc.getPassword());
//			sb.append("\"");
//			sb.append(",");
//			
//			//ip
//			sb.append("\"");
//			sb.append("Ip");
//			sb.append("\"");
//			sb.append(":");
//			sb.append("\"");
//			sb.append(acc.getIp());
//			sb.append("\"");
//			sb.append(",");
//			
//			//sex
//			sb.append("\"");
//			sb.append("sex");
//			sb.append("\"");
//			sb.append(":");
//			sb.append("\"");
//			sb.append(acc.getSex());
//			sb.append("\"");
//			
//			sb.append("}");
			
			Gson gson = new Gson();
			//对象转成json字符串
			String json=gson.toJson(acc);
			//json字符串转成acc对象
			Account acc1 =gson.fromJson(json, Account.class);
			System.out.println(json);
			
			PrintWriter writer=	response.getWriter();
//			writer.print("success("+sb.toString()+")");
			writer.print(method+"("+json+")");
			
			
			
			
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
