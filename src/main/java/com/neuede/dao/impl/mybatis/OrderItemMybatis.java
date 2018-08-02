package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderItemMybatis implements OrderItemDao{
    @Override
    public boolean addOrderItems(List<UserOrderItem> orderItems) {
        SqlSession session = Mybatis.getSession();
        OrderItemDao orderItemDao=session.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItems(orderItems);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public int generateOrderItemId() {
        return 0;
    }
}
