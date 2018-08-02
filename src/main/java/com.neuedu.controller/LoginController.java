package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;


/**
 * 负责接收用户用户名、密码
 * */
@WebServlet("/login")
public class LoginController extends HttpServlet{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ILoginService  loginService=new LoginServiceImpl();
		String username=null;
		String password=null;
		
		
		 username=req.getParameter("username");
		 password=req.getParameter("password");
		
		 Account a=loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		 System.out.println(a);
		 if(a!=null) {
			//登录成功
			
			Cookie name_cookie = new Cookie("username", username);
			name_cookie.setMaxAge(7*24*3600);
			resp.addCookie(name_cookie);
			
			Cookie psw_cookie = new Cookie("password",MD5Utils.GetMD5Code(password));
			name_cookie.setMaxAge(7*24*3600);
			resp.addCookie(psw_cookie);
			System.out.println("第一次登录");
			
			
//			生成token 放到数据库中
			
			long time = System.currentTimeMillis();
			String token= MD5Utils.GetMD5Code(username+password+time);
			loginService.addToken(a,token);
//			放到会话域
			HttpSession session=req.getSession();
			session.setAttribute("token", token);
			session.setAttribute("acc", a);
			req.getRequestDispatcher("loginsucess.jsp").forward(req, resp);
		}else {
			//登录失败
			req.getRequestDispatcher("loginfail.jsp").forward(req, resp);
		}
		}
	}

	/**
	 * @return boolean true:登录成功 false：登录失败
	 * */
	
	

