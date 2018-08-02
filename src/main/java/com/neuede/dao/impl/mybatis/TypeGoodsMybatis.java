package com.neuede.dao.impl.mybatis;

import com.neuedu.dao.TypeGoodsDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.TypeGoods;
import com.neuedu.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeGoodsMybatis implements TypeGoodsDao {


    @Override
//    添加种类
    public boolean addTypeGoods(TypeGoods typegoods) {
//        获取了session
        SqlSession session = Mybatis.getSession();
//        成功返回值是1  如果不需要返回值的话
        int a =session.insert("com.neuedu.entity.TypeGoods.addTypeGoods",typegoods);
        session.commit();
        session.close();

        if(a!=1){
            return false;
        }
        return true;
    }

    @Override
//    所有种类
    public List<TypeGoods> findAll() {
        return null;
    }

    @Override
//    更新种类
    public boolean updateTypeGoods(TypeGoods typegoods) {
        SqlSession session = Mybatis.getSession();
        int a =session.update("com.neuedu.entity.TypeGoods.updateTypeGoods",typegoods);
        session.commit();
        session.close();
        if(a!=0){
            System.out.println("更新种类失败");
            return false;

        }
        return true;

    }

    @Override
//    删除种类
    public boolean deleteTypeGoods(int id) {
        SqlSession session = Mybatis.getSession();
        int a =session.delete("com.neuedu.entity.TypeGoods.deleteTypeGoods",id);
        session.commit();
        session.close();
        if(a!=0){
            System.out.println("删除种类失败");
            return false;
        }
        return true;
    }

    @Override
//    查找单个种类
    public TypeGoods findById(int id) {
        SqlSession session = Mybatis.getSession();
        Object obj =session.selectOne("com.neuedu.entity.TypeGoods.findById",id);
        session.commit();
        session.close();
        if(obj instanceof TypeGoods){
            TypeGoods typegoods = (TypeGoods)obj;
            return typegoods;
        }
        System.out.println("查询单个种类失败");
        return null;
    }

    @Override
//    分页查询
    public PageModel<TypeGoods> findTypeByPage(int pageNo, int pageSize) {
        SqlSession session = Mybatis.getSession();
//        就是给pageModel赋值  totalpage   currentpage  date(list)
        PageModel<TypeGoods> pageModel = new PageModel<TypeGoods>();
//        给当前页赋值   currentPage
        int totalAccount=session.selectOne("com.neuedu.entity.TypeGoods.findTotle");
        int totalPage = (totalAccount%pageSize==0)?(totalAccount/pageSize):(totalAccount/pageSize+1);
//        给当前页 和 总页数 赋值
        pageModel.setTotalPage(totalPage);
        pageModel.setCurrentPage(pageNo);

        Map<String,Integer> map = new HashMap<String,Integer>();
        int offset = (pageNo-1)*pageSize;
        map.put("offset",offset);
        map.put("pagesize",pageSize);
        List<TypeGoods> list = null;
        list=session.selectList("com.neuedu.entity.TypeGoods.findTypeByPage",map);
//       给每一页  的list赋值
        pageModel.setDate(list);
        session.commit();
        session.close();
        return pageModel;
    }





}
