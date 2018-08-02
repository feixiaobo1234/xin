package com.neuede.test;

import com.neuede.dao.impl.mybatis.ProductMabatis;
import com.neuedu.dao.ProductDao;
import org.junit.Test;

public class checkName {

    @Test
    public  void  testCheckName(){
        ProductDao pd = new ProductMabatis();
        pd.checkName("费晓波");

    }
}
