package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.TypeGoods;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartMybatis implements CartDao {
    @Override
//    添加购物车
    public boolean addCart(Cart cart) {

        SqlSession session =null;
        session= Mybatis.getSession();

        int a =session.insert("com.neuedu.entity.Cart.addCart",cart);
        System.out.println(a);
        session.commit();
        session.close();
        if(a!=1){
            System.out.println("添加购物车失败");
            return  false;
        }
        return   true;
    }

    @Override
//    删除购物车
    public boolean deleteCart(int id) {
        SqlSession session = Mybatis.getSession();
        int a =session.delete("com.neuedu.entity.Cart.deleteCart",id);
        session.commit();
        session.close();
        if(a!=0){
            System.out.println("删除购物车失败");
            return false;
        }
        return true;
    }

    @Override
//    （未完成 ）更新购物车        这个失败了    属性里面有product的方法
    public boolean updataeCart(Cart cart) {
        SqlSession session = Mybatis.getSession();
        int a =session.update("com.neuedu.entity.Cart.updateCart",cart);
        session.commit();
        session.close();
        if(a!=0){
            System.out.println("更新种类失败");
            return false;

        }
        return true;
    }

    @Override
//    （未完成 ）查询 所有        但是完成了 分页查询  看下面
    public List<Cart> findAllCart() {
        SqlSession session = Mybatis.getSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        List<Cart> list=cartDao.findAllCart();
        session.commit();
        session.close();

        return list;
    }

    @Override
//    获取购物车的商品数量
    public int getCartNum() {
        SqlSession session = Mybatis.getSession();
//        a是购物车的数量
        int a =session.update("com.neuedu.entity.Cart.getCartNum");

        session.commit();
        session.close();
        System.out.println("购物车的数量是"+a);
        return a;

    }

    @Override
//    更新购物车数量
    public boolean updateCart(int id, int num) {
        SqlSession session = Mybatis.getSession();
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("id",id);
        map.put("num",num);
        int a =session.update("com.neuedu.entity.Cart.updateCart",map);
        session.commit();
        session.close();
        if(a!=0){
            System.out.println("更新购物车数量失败");
            return false;

        }
        return true;
    }

    @Override
//    清空购物车
    public void clearCart() {
        SqlSession session = Mybatis.getSession();
//        a是购物车的数量
        int a =session.update("com.neuedu.entity.Cart.clearCart");

        session.commit();
        session.close();
        if(a!=1){
            System.out.println("购物车没有清空");
        }
        System.out.println("购物车已经清空");
        ;
    }

    @Override
//    分页查询购物车
    public PageModel<Cart> findCartByPage(int pageNo, int pageSize) {
        SqlSession session = Mybatis.getSession();
//        就是给pageModel赋值  totalpage   currentpage  date(list)
        PageModel<Cart> pageModel = new PageModel<Cart>();
//        给当前页赋值   currentPage
        int totalAccount=session.selectOne("com.neuedu.entity.Cart.findTotle");
        int totalPage = (totalAccount%pageSize==0)?(totalAccount/pageSize):(totalAccount/pageSize+1);
//        给当前页 和 总页数 赋值
        pageModel.setTotalPage(totalPage);
        pageModel.setCurrentPage(pageNo);

        Map<String,Integer> map = new HashMap<String,Integer>();
        int offset = (pageNo-1)*pageSize;
        map.put("offset",offset);
        map.put("pagesize",pageSize);
        List<Cart> list = null;
        list=session.selectList("com.neuedu.entity.Cart.findPageList",map);
//       给每一页  的list赋值
        pageModel.setDate(list);
        session.commit();
        session.close();
        return pageModel;
    }
}
