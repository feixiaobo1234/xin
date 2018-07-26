package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.TypeGoods;

public interface TypeGoodsService {
	/**�����Ʒ����*/
    public  boolean addTypeGoods(TypeGoods typegoods);	
    /**��ѯ��Ʒ����*/
    public  List<TypeGoods> findAll();
    /**�޸���Ʒ����*/
    public  boolean  updateTypeGoods(TypeGoods typegoods);
    /**ɾ����Ʒ����*/
    public  boolean deleteTypeGoods(int id);
    /**����id��ѯ��Ʒ������Ϣ*/
    public  TypeGoods  findTypeGoodsById(int id);
    /**��ҳ��ѯ����*/
    public  PageModel findTypeByPage(int pageNo, int pageSize);
}
