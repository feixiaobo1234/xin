package com.neuedu.service.impl;

import java.util.List;

import com.neuede.dao.impl.mybatis.CartMybatis;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;

public class CartServiceImpl implements CartService {
//cartdao 数据库的实现类
//	CartDao cartDao=new CartDaoImpl();
//	Mybatis的实现类
CartDao cartDao=new CartMybatis();
	@Override
//	添加购物车
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
//	删除购物车
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
//	（未完成）更新购物车
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
//	（未完成）查询所有购物车
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
//	获取购物车的数量
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
//	更新购物车商品的数量
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

}
