package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.TypeGoodsDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.dao.impl.jdbc.TypeGoodsDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.TypeGoods;
import com.neuedu.service.TypeGoodsService;

public class TypeGoodsServiceImpl implements TypeGoodsService {

	
	TypeGoodsDao typegoodsDao=new TypeGoodsDaoImpl();
	@Override
	public boolean addTypeGoods(TypeGoods typegoods) {
		// TODO Auto-generated method stub
		return typegoodsDao.addTypeGoods(typegoods);
	}

	@Override
	public List<TypeGoods> findAll() {
		// TODO Auto-generated method stub
		return typegoodsDao.findAll();
	}

	@Override
	public boolean updateTypeGoods(TypeGoods typegoods) {
		// TODO Auto-generated method stub
		return typegoodsDao.updateTypeGoods(typegoods);
	}

	@Override
	public boolean deleteTypeGoods(int id) {
		// TODO Auto-generated method stub
		return typegoodsDao.deleteTypeGoods(id);
	}

	@Override
	public TypeGoods findTypeGoodsById(int id) {
		// TODO Auto-generated method stub
		return typegoodsDao.findById(id);
	}

	@Override
	public PageModel findTypeByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return typegoodsDao.findTypeByPage(pageNo, pageSize);
	}

}
