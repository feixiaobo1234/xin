package com.neuede.test;

import com.neuede.dao.impl.mybatis.LoginMybatis;
import com.neuedu.dao.ILoginDao;
import org.junit.Test;

public class User {

    @Test
    public void  testLogin(){
        ILoginDao  lg  = new LoginMybatis();

        lg.doLogin("123","·ÑÏþ²¨");
        System.out.println("ÎÒµÄ");

    }

}
