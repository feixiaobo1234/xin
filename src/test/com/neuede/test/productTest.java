package com.neuede.test;

import com.neuede.dao.impl.mybatis.ProductMabatis;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;
import org.junit.Test;

public class productTest {
    @Test
    public  void  TestfindProductById(){
        ProductDao pd = new ProductMabatis();
//        pd.findById(10);
        Product p = new Product();
//
      p.setId(50);
        p.setName("Œ®—≈»„12");
//
        pd.addProduct(p);
//        pd.updateProduct(p);
//        pd.deleteProduct(29);

//        pd.findProductByPage(2,5);
    }
}
