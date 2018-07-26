package com.neuedu.service;

import com.neuedu.entity.Account;

public interface ILoginService {

	public Account  doLogin(String username, String password);
	
	public void  addToken(Account acc, String token);
	
	String findTokenByAccountid(int id);
}
