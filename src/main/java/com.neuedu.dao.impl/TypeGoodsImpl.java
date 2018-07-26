package com.neuedu.dao.impl;

import java.util.List;

import com.neuedu.dao.TypeGoodsDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.TypeGoods;

public class TypeGoodsImpl implements TypeGoodsDao {

	@Override
	public boolean addTypeGoods(TypeGoods typegoods) {
		// TODO Auto-generated method stub
		return DataSource.typeGoods.add(typegoods);
	}

	@Override
	public List<TypeGoods> findAll() {
		// TODO Auto-generated method stub
		return DataSource.typeGoods;
	}

	@Override
	public boolean updateTypeGoods(TypeGoods typegood) {
		// TODO Auto-generated method stub
		//step1:先查询到要修改的商品种类
				List<TypeGoods> typeGoods=DataSource.typeGoods;
				for(int i=0;i<typeGoods.size();i++) {
					TypeGoods p=typeGoods.get(i);
					//商品ID
					int  _id=p.getId();
					if(_id==typegood.getId()) {
						//step2:将新的商品种类赋值给旧的商品种类
						typeGoods.set(i, typegood);
						return true;
					}
				}
				return false;
	}

	@Override
	public boolean deleteTypeGoods(int id) {
		// TODO Auto-generated method stub
		List<TypeGoods> typeGoods=DataSource.typeGoods;
		for(int i=0;i<typeGoods.size();i++) {
			TypeGoods p=typeGoods.get(i);
			//商品ID
			int  _id=p.getId();
			if(_id==id) {
				typeGoods.remove(i);
				return true;
			}
		}
		
		return false;
	}

	
	@Override
	public TypeGoods findById(int id) {
		// TODO Auto-generated method stub
		List<TypeGoods> list=DataSource.typeGoods;
		for(int i=0;i<list.size();i++) {
			TypeGoods p=list.get(i);
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public PageModel<TypeGoods> findTypeByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}




}
