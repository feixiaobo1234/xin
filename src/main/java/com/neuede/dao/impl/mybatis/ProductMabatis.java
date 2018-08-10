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
//    �����Ʒ
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
//    ������Ʒ
    public List<Product> findAll() {


        return null;
    }

    @Override
//    ������Ʒ
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
        System.out.println("��Ʒ�޸� ����ֵ��"+a);

        session.commit();
        session.close();
        if(a!=1){
            return false;
        }
        return true;
    }

    @Override
//    ɾ����Ʒ
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
//    ���ҵ�����Ʒ
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
//        System.out.println(p.getName()+"�����ҵ���");
        return p;
    }

    @Override
//    ��ҳ��ѯ
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
        System.out.println("��ҳ��ѯ�ɹ�");
        return pageModel;
    }

    @Override
//    ��ѯ������
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
        //����ֵ ��Integer
        Object o = session.selectOne("com.neuedu.entity.Product.checkName", name);
        Integer p = 0;
        if (o instanceof Integer) {
            p = (Integer)o;
            System.out.println("������� " + p);
            return p;
        }
        session.close();
        return  0 ;

    }
}
