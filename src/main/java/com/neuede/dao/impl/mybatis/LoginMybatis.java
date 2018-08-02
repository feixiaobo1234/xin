package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatis implements ILoginDao {
    @Override
    public Account doLogin(String _username, String _password) {
            String  resource = "mybatis-config.xml";
            Reader reader =  null;
            SqlSession  session ;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
        session =sqlFactory.openSession();
        Map<String,String> map = new HashMap<String, String>();
        map.put("username",_username);
        map.put("password",_password);
        Account account=session.selectOne("com.neuedu.entity.Account.findByUserAndPassword",map);
        System.out.println(account.password+"已经查到了");
        session.close();

        return account;


    }

    @Override
    public void addToken(String token, Account acc) {

    }

    @Override
    public String findTokenByAccountid(int accountid) {
        return null;
    }
}
