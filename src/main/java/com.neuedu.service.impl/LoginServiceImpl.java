package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.utils.MD5Utils;

public class LoginServiceImpl implements ILoginService{

	
	ILoginDao loginDao=new LoginDaoImpl();
	
	
	public Account  doLogin(String  username,String password) {
		//进行登录的业务逻辑处理
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
		
		return loginDao.doLogin(username,password);
		
		
	}

	@Override
	public void addToken(Account acc,String token) {
		// TODO Auto-generated method stub
		
		
		
		loginDao.addToken(token, acc);
	}

	@Override
	public String findTokenByAccountid(int id) {
		// TODO Auto-generated method stub
		
		
		loginDao.findTokenByAccountid(id);
		return null;
	}
	
}
