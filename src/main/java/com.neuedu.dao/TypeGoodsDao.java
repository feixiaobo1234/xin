package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.TypeGoods;

public interface TypeGoodsDao {

	
	 /**
	  * �����Ʒ����
	  * */
	boolean  addTypeGoods(TypeGoods typegoods);
	/**
	 * �鿴��Ʒ����
	 * */
	List<TypeGoods> findAll();
	/**
	 * �޸���Ʒ����
	 * */
	boolean  updateTypeGoods(TypeGoods typegoods);
	/**
	 * ɾ����Ʒ����
	 * */
	boolean  deleteTypeGoods(int id);
	
	/**����id��ѯ��Ʒ����*/
	TypeGoods  findById(int id);
	/**
	 * ��ҳ��ѯ
	 * */
	
	PageModel<TypeGoods> findTypeByPage(int pageNo, int pageSize);
}
