package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Account;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository()
public class ProductMabatis implements ProductDao {
    @Autowired
//    @Qualifier
//    @Resource(name)
    private SqlSession session;
    @Override
//    添加商品
    public boolean addProduct(Product product) {
//        String resource = "mybatis-config.xml";
//        Reader reader = null;
//        SqlSession session=null;
//
//        try {
//           reader= Resources.getResourceAsReader(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
//        session=ssf.openSession();
//        SqlSession session =null;
//        session= Mybatis.getSession();

        int a =session.insert("com.neuedu.entity.Product.addProduct",product);
//       ProductDao p= session.getMapper(ProductDao.class);
//       p.addProduct()
//        session.getMapper()
        System.out.println(a);

//        session.commit();
//        session.close();
        if(a!=1){
            return  false;
        }
        return   true;

    }

    @Override
//    所有商品
    public List<Product> findAll() {


        return null;
    }

    @Override
//    更新商品
    public boolean updateProduct(Product product) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session = null;

        try {
           reader= Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        session= ssf.openSession(true);
        int a =session.update("com.neuedu.entity.Product.updateProduct",product);
        System.out.println("商品修改 返回值是"+a);

        session.commit();
        session.close();
        if(a!=1){
            return false;
        }
        return true;
    }

    @Override
//    删除商品
    public boolean deleteProduct(int id) {
        String resource  = "mybatis-config.xml";
        Reader reader =null;
        SqlSession session;
        try {
            reader=Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf  = new SqlSessionFactoryBuilder().build(reader);
        session= ssf.openSession();
        int a =session.delete("com.neuedu.entity.Product.deleteProduct",id);
        session.commit();
        if(a!=1){
            return  false;
        }
        return true;
    }

    @Override
//    查找单个商品
    public Product findById(int id) {
        String resource  = "mybatis-config.xml";
        Reader reader =null;
        SqlSession session;
        try {
            reader=Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf  = new SqlSessionFactoryBuilder().build(reader);
        session= ssf.openSession();

        Object  object =session.selectOne("com.neuedu.entity.Product.findById",id);
        Product p=null;
        if( object instanceof  Product){
             p = (Product)object;
        }
        session.close();
//        System.out.println(p.getName()+"终于找到你");
        return p;
    }

    @Override
//    分页查询
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
        String source = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session = null;

        try {
            reader = Resources.getResourceAsReader(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        session = ssf.openSession();
        int count=session.selectOne("com.neuedu.entity.Product.findCount");
        int totalpage = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
        PageModel<Product> pageModel = new PageModel<Product>();
        pageModel.setTotalPage(totalpage);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pagesize",pageSize);
        List<Product> list=session.selectList("com.neuedu.entity.Product.findPageList",map);
        pageModel.setDate(list);
        pageModel.setCurrentPage(pageNo);
        System.out.println("分页查询成功");
        return pageModel;
    }

    @Override
//    查询几个人
    public int checkName(String name) {
        String source = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session = null;

        try {
            reader = Resources.getResourceAsReader(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        session = ssf.openSession();
        //返回值 是Integer
        Object o = session.selectOne("com.neuedu.entity.Product.checkName", name);
        Integer p = 0;
        if (o instanceof Integer) {
            p = (Integer)o;
            System.out.println("这个总数 " + p);
            return p;
        }
        session.close();
        return  0 ;

    }
}
