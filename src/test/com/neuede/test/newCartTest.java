package com.neuede.test;

import com.neuede.dao.impl.mybatis.NewCartMybatis;
import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.Test;

public class newCartTest {
    @Test
    public void testnewCart(){
//      购物车接口
      CartDao cartDao = new NewCartMybatis();
//      购物车
      Cart cart = new Cart();
      Product p = new Product(11, "feixiaobo", "buzhidao", 500, "meiyou");

      cart.setProduct(p);
      cart.setProductNum(5);

      cartDao.addCart(cart);
    }
}
