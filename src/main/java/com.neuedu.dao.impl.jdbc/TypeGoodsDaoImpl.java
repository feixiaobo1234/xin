package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.neuedu.dao.TypeGoodsDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.TypeGoods;
import com.neuedu.utils.DBUtils;

public class TypeGoodsDaoImpl implements TypeGoodsDao {




	@Override
	public boolean addTypeGoods(TypeGoods typegoods) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into typegoods values (null,?,?,?,?,now())";
			st=conn.prepareStatement(sql);
			//占位符赋值
			//st.setLong(1, typegoods.getId());
			st.setString(1, typegoods.getName());
			st.setString(2, typegoods.getDesc());
			st.setString(3, typegoods.getImage());
			st.setInt(4, typegoods.getGrade());
	
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<TypeGoods> findAll() {
		// TODO Auto-generated method stub
		List<TypeGoods> typeGoods=new ArrayList<TypeGoods>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select * from  typegoods";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("gdesc");
			 String  image=rs.getString("image");
			 int grade = rs.getInt("grade");
//			  Date ctime =rs.getDate("ctime");
			 
			 TypeGoods typegood=new TypeGoods(id,name,pdesc,image,grade);
			 typeGoods.add(typegood); 
			}
			
			return typeGoods;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	@Override
	public boolean updateTypeGoods(TypeGoods typegoods) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn =DBUtils.getConnection();
			//2.准备sql语句
			String sql ="update typegoods set name=? , gdesc=?,  image=?, grade=? where id=? ";
			//3.预编译sql语句
			PreparedStatement p =conn.prepareStatement(sql);
			//4.赋值
			
			p.setString(1,typegoods.getName());
			p.setString(2,typegoods.getGdesc());
			p.setString(3, typegoods.getImage());
			p.setInt(4, typegoods.getGrade());
			p.setInt(5, typegoods.getId());
			System.out.println("jdbc中的grade是"+typegoods.getGrade());
			System.out.println(sql);
			
			count = p.executeUpdate();
//			p.execute(sql);
//			p.executeQuery();
//			count =p.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean deleteTypeGoods(int id) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from typegoods where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			System.out.println(sql);
			//创建preparement
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}
		return false;
	}

	@Override
	public TypeGoods findById(int id) {
		// TODO Auto-generated method stub
		TypeGoods typeGood=new TypeGoods();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select * from typegoods where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			
			if(rs.first()) {
				 int  _id= rs.getInt("id");	
				 String  name=rs.getString("name");
				 String pdesc=rs.getString("gdesc");
				 String  image=rs.getString("image"); 
				 int grade = rs.getInt("grade");
				 typeGood.setId(_id);
				 typeGood.setName(name);
                 typeGood.setDesc(pdesc);
                 typeGood.setImage(image);
                 typeGood.setGrade(grade);
			}
			return typeGood;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
return typeGood;
	}

	@Override
	public PageModel<TypeGoods> findTypeByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<TypeGoods>  pageModel = new  PageModel<TypeGoods>();
		
		List<TypeGoods> typeGoods=new ArrayList<TypeGoods>();
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select * from  typegoods limit ?,?";
			
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			 rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("gdesc");
			 String  image=rs.getString("image");
			 int grade = rs.getInt("grade");
//			  Date ctime =rs.getDate("ctime");
			 
			 TypeGoods typegood=new TypeGoods(id,name,pdesc,image,grade);
			 typeGoods.add(typegood); 
			}
//			设置了种类的集合
			pageModel.setDate(typeGoods);
			
			
//			设置每一页的数量
			pageModel.setCurrentPage(pageNo);
			
//			设置当前页
			String totalAccout_sql = "SELECT count(*) FROM typegoods " ;
			st=conn.prepareStatement(totalAccout_sql);
			System.out.println(totalAccout_sql);
			 rs=st.executeQuery();
			if(rs.first()) {
				int totalaccount = rs.getInt(1);
				System.out.println("总数是"+totalaccount);
				int totalPage=((totalaccount%pageSize==0)?totalaccount/pageSize:totalaccount/pageSize+1);
				pageModel.setTotalPage(totalPage);
			}
			System.out.println("pageModel地址是"+pageModel);
			return pageModel;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

}
