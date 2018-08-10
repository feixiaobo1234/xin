package com.neuede.test;

import com.neuede.dao.impl.mybatis.ProductMabatis;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class productTest {

    public  void  TestfindProductById(){
        ProductDao pd = new ProductMabatis();
//        pd.findById(10);
        Product p = new Product();
//
//      p.setId(50);
//        p.setName("Œ®—≈»„12");
//
        pd.addProduct(p);
//        pd.updateProduct(p);
//        pd.deleteProduct(29);

//        pd.findProductByPage(2,5);
    }
   public static void main(String[]args){
        test();
   }
    public static void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
      System.out.println(applicationContext);
        ProductDao product=(ProductDao)applicationContext.getBean(ProductDao.class);
       Product p =new Product("wewewei", "efe",  1324, "fefe");
        product.addProduct(p);

    }

}
