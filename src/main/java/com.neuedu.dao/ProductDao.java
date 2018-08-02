package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {

	 /**
	  * 添加商品
	  * */
	boolean  addProduct(Product product);
	/**
	 * 所有商品
	 * */
	List<Product> findAll();
	/**
	 *更新商品
	 * */
	boolean  updateProduct(Product product);
	/**
	 * 删除商品
	 * */
	boolean  deleteProduct(int id);
	
	/**查找单个商品*/
	Product  findById(int id);
	
	/**
	 * 分页查询
	 * */
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
	int checkName(String name);
}
