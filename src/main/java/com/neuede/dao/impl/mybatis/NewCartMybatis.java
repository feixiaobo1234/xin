package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NewCartMybatis implements CartDao {
    @Override
    public boolean addCart(Cart cart) {
        SqlSession session = Mybatis.getSession();
        CartDao cartDao =session.getMapper(CartDao.class);
        cartDao.addCart(cart);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public boolean updataeCart(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> findAllCart() {
        return null;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public void clearCart() {

    }

    @Override
    public PageModel<Cart> findCartByPage(int pageNo, int pageSize) {
        return null;
    }
}
