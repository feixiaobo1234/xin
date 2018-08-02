package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CartDaoImpl implements CartDao {

	ProductDao productDao = new ProductDaoImpl();

	@Override
//	添加购物车、
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into cart(productid,productnum) values (" + cart.getProduct().getId() + ","
					+ cart.getProductNum() + ")";
			System.out.println(sql);
			st.execute(sql);
			// boolean flag=st.execute(sql);
			// System.out.println("购物车增加"+flag);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("执行吗");
		return false;

	}

	@Override
//	删除购物车
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from cart where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
//	更新 购物车
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productnum=" + cart.getProductNum() + "where id=" + cart.getId() + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
//	查询购物车
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub

		List<Cart> carts = new ArrayList<Cart>();

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int productid = rs.getInt("productid");
				int num = rs.getInt("productnum");

				Cart cart = new Cart();
				cart.setId(id);
				cart.setProductNum(num);
				cart.setProduct(productDao.findById(productid));
				carts.add(cart);
			}

			return carts;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
//	获取购物车数量
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
//	通过id  num更新购物车
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productnum=" + num + " where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
//	清空购物车
	public void clearCart() {
		// TODO Auto-generated method stub

	}

	@Override
//	分页查询所有
	public PageModel<Cart> findCartByPage(int pageNo, int pageSize) {
		return null;
	}

}
