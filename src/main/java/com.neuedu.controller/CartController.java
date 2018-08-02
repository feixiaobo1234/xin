package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cart")
public class CartController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String option = req.getParameter("option");
       if("1".equals(option)){
       	findAllCart(req,resp);
	   }else if("2".equals(option)){
       	deleteCart(req,resp);
		}

	}

	CartService cartService=new CartServiceImpl();
	
	/**
	 * 添加购物车
	 **/
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}
	/**
	 * 删除
	 * */
	public boolean  deleteCart(int id) {


		return cartService.deleteCart(id);
	}

	public boolean deleteCart(HttpServletRequest req, HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin" , "*");
		String _id=req.getParameter("id");
		int id = Integer.parseInt(_id);
		cartService.deleteCart(id);
		try {
			resp.getWriter().print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 修改购物车
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * 查询购物车
	 * */
	public List<Cart> findAllCart(){

		return cartService.findAllCart();
	}
//	查询所有订单
	public void findAllCart(HttpServletRequest req, HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin" , "*");
		List<Cart> list=cartService.findAllCart();
//		String callback = req.getParameter("callback");
		Gson json = new Gson();
		String list1=json.toJson(list);
		try {
			PrintWriter writer =resp.getWriter();
			writer.print(list1);
//			writer.print(callback+"("+list1+")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取购物车中商品数量
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**修改购物车商品数量
	 * @param  id  要修改的购物车的Id
	 * @param  num 修改后的数量
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
