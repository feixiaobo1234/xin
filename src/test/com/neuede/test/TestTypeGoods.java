package com.neuede.test;

import com.neuede.dao.impl.mybatis.TypeGoodsMybatis;
import com.neuedu.dao.TypeGoodsDao;
import com.neuedu.entity.TypeGoods;
import org.junit.Test;

public class TestTypeGoods {
    @Test
    public  void   testGoodsType(){
        TypeGoodsDao typegoods = new TypeGoodsMybatis();
//        TypeGoods t = new TypeGoods();
//        t.setId(3);
//        t.setName("天大的好事啊");
//        typegoods.addTypeGoods(t);
//        typegoods.updateTypeGoods(t);
//        typegoods.deleteTypeGoods(130);
//        typegoods.findById(124);
          typegoods.findTypeByPage(2,5);
    }
}

