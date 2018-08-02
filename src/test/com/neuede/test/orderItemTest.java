package com.neuede.test;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import org.junit.Test;

public class orderItemTest {
    @Test
    public  void  test(){

        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder();
    }
}
