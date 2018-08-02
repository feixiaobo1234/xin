package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {



	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "insert into product(name,pdesc,price,rule,image,stock) values (?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt   (6, product.getStock());
			System.out.println("插入的是"+product.getStock());
			System.out.println(sql);
			st.execute();
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,pdesc,price,rule ,image,stock from  product";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, name, pdesc, price, rule, image, stock);
				products.add(product);
			}

			return products;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		// 1.连接数据库
		// 5.执行sql语句
		int count = 0;

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			// 2.准备sql语句
			String sql = "update product set name=?  , image=? , price=? , rule=? , stock=?    where id=? ";
			// 3.预编译sql语句
			ps = conn.prepareStatement(sql);
			// 4.赋值
			ps.setString(1, product.getName());
			
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getRule());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getId());
			

			System.out.println(sql);
			count = ps.executeUpdate();
			System.out.println("修改数量是"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (count != 0) {
			return true;
		}
		return false;
	}

	// 删除数据
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		// 删除数据
		int count = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from product where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			System.out.println(sql);
			// 创建preparement
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (count != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Product findById(int id) {

		Product product = new Product();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,pdesc,price,rule,image,stock from  product where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			rs = st.executeQuery();

			if (rs.first()) {
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				product.setId(_id);
				product.setName(name);
				product.setPrice(price);
				product.setDesc(pdesc);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
			}

			return product;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return product;
	}

	// 分页查询
	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Product> pageModel = new PageModel<Product>();
		// 分页中有list<Product>的集合
		List<Product> products = new ArrayList<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,pdesc,price,rule ,image,stock from product  limit ?,?";

			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			// 打印sql语句
			System.out.println(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, name, pdesc, price, rule, image, stock);
				products.add(product);
			}
			// 设置一页的集合
			pageModel.setDate(products);
			// 设置当前页
			pageModel.setCurrentPage(pageNo);
			// 设置总页数
			String accountTotal_sql = "select count(*) from product";
			st = conn.prepareStatement(accountTotal_sql);
			rs = st.executeQuery();
			int _totalPage = 0;
			if (rs.first()) {
				int total_account = rs.getInt(1);
				_totalPage = ((total_account % pageSize == 0) ? total_account / pageSize
						: total_account / pageSize + 1);
				System.out.println("总页数" + _totalPage);
			}
			pageModel.setTotalPage(_totalPage);

			// return pageModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pageModel;

	}

	@Override
	public int checkName(String name) {
		return 0;
	}


}
