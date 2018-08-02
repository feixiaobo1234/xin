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
	 * ��ӹ��ﳵ
	 **/
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}
	/**
	 * ɾ��
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
	 * �޸Ĺ��ﳵ
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * ��ѯ���ﳵ
	 * */
	public List<Cart> findAllCart(){

		return cartService.findAllCart();
	}
//	��ѯ���ж���
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
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
