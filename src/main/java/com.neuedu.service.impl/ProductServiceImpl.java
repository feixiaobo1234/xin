package com.neuedu.service.impl;

import java.util.List;

import com.neuede.dao.impl.mybatis.ProductMabatis;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;

public class ProductServiceImpl implements ProductService {

	
	ProductDao productDao=new ProductMabatis();
	
	@Override
//	�����Ʒ
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDao.addProduct(product);
	}

	@Override
//	������Ʒ
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
//	������Ʒ
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
//	ɾ����Ʒ
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
//	������Ʒ
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	//��ҳ��ѯ
	public PageModel findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productDao.findProductByPage(pageNo, pageSize);
	}

	
}
