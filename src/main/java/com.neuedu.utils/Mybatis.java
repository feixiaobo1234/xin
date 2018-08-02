package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Mybatis {

    public static SqlSession getSession(){

            String resource = "mybatis-config.xml";
            Reader reader = null;
            SqlSession session=null;

            try {
            reader= Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        session=ssf.openSession();
        return  session;
    }

}
