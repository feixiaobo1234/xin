package com.neuede.test;

import com.neuede.dao.impl.mybatis.CartMybatis;
import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.Test;

public class CartTest {
    @Test
    public void  testCart(){
        CartDao  dao= new CartMybatis();
        Cart cart = new Cart();
        Product p = new Product();
        p.setId(100);
        p.setPrice(250);

        int  i = 4;
        int num =6;
        cart.setId(i);
        cart.setProductNum(num);
        cart.setProduct(p);

//        dao.addCart(cart);
//        dao.deleteCart(5);
//        dao.updataeCart(cart);
//        dao.findCartByPage(2,2);
//            dao.updateCart(4,2);

//        dao.getCartNum();
//        dao.clearCart();
    }
}
