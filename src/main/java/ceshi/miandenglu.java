package ceshi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class miandenglu
 */
@WebServlet("/miandenglu")
public class miandenglu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public miandenglu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username=null;
		String password= null;
		Cookie[] cookie =request.getCookies();
	if(cookie!=null) {
		for(Cookie c :cookie) {
			if(c.getName().equals("username")) {
				username = c.getValue();
			}
			
			if(c.getName().equals("password")) {
				password = c.getValue();
			}
		}
		
		if(username!=null&&password!=null&&!username.equals("")&&!password.equals("")) {
			
			request.getRequestDispatcher("loginsucess.jsp").forward(request, response);;
			return ;
		}
		
	}
		
		
		
		
		 username =request.getParameter("username");
		 password = request.getParameter("password");
		ILoginService loginService = new LoginServiceImpl();
		Account acc = loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		if(acc!=null) {
			
			Cookie cookie1 = new Cookie("username", username);
			cookie1.setMaxAge(7*24*3600);
			response.addCookie(cookie1);;
			
			Cookie cookie2 = new Cookie("password",MD5Utils.GetMD5Code(password));
			cookie2.setMaxAge(7*24*3600);
			response.addCookie(cookie2);
			
			
			
			System.out.println(acc+"ÄÜµÇÂ¼°¡");
			request.getRequestDispatcher("loginsucess.jsp").forward(request, response);
		
		}else {
			request.getRequestDispatcher("faile.jsp").forward(request, response);
			

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
