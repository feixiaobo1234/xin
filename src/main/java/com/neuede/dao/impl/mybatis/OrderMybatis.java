package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;

public class OrderMybatis implements OrderDao {
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSession session  = Mybatis.getSession();
       OrderDao orderDao= session.getMapper(OrderDao.class);
       orderDao.createOrder(userOrder);
       session.commit();
       session.close();
        return true;
    }

    @Override
    public int generateOrderId() {
        return 0;
    }
}
