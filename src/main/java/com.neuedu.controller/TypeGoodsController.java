package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.TypeGoods;
import com.neuedu.service.TypeGoodsService;
import com.neuedu.service.impl.TypeGoodsServiceImpl;

@WebServlet("/typegoods")
public class TypeGoodsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String option = request.getParameter("option");
		if ("1".equals(option)) {
			 addTypeGoods(request,response);
		} else if ("2".equals(option)) {
//			ɾ������
			deleteTypeGoods(request, response);
			System.out.println("ɾ��");
		} else if ("3".equals(option)) {
			
			updateTypeGoods(request, response);
			System.out.println("�޸�");
		} else if ("4".equals(option)) {
			findAll(request, response);
			System.out.println("�鿴����");
		} else if ("5".equals(option)) {
			findTypeGoodsById(request, response);
			System.out.println("����Id��ѯ");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	TypeGoodsService typegoodsService = new TypeGoodsServiceImpl();

	/**
	 * ��������
	 * 
	 */
	public boolean addTypeGoods(TypeGoods typegoods) {
		return typegoodsService.addTypeGoods(typegoods);
	}

	public boolean addTypeGoods(HttpServletRequest request, HttpServletResponse response) {
		TypeGoods typegoods = new TypeGoods();

		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String image = request.getParameter("image");
		String _grade = request.getParameter("grade");
		
		try {
			int grade = Integer.parseInt(_grade);
			System.out.println(name + desc + image + grade);
			typegoods.setDesc(desc);
			typegoods.setImage(image);
			typegoods.setName(name);
			typegoods.setGrade(grade);
			typegoodsService.addTypeGoods(typegoods);
			findAll(request,response);
			return true;
		} catch (NumberFormatException E) {
			E.printStackTrace();
		}
//		��ת��findAllҳ��
		return false;

	}

	/**
	 * ��ѯ����
	 * 
	 */
	public void findAll() {
		typegoodsService.findAll();
	}
//��ҳ��ѯ
	public void findAll(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
//		����pageNo
		String _pageNo=request.getParameter("pageNO");
		if(_pageNo==null) {
			_pageNo="1";
		}
		int pageNo =1;
		 pageNo= Integer.parseInt(_pageNo);
//		����pageSize
		 int pageSize=5;
		PageModel<TypeGoods> pageModel = typegoodsService.findTypeByPage(pageNo, pageSize);
		System.out.println(pageModel.getDate().size()+"���������");
		request.setAttribute("pageModel", pageModel);
		
		request.getRequestDispatcher("showTypeByPage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ɾ������
	 * 
	 */
	public boolean deleteTypeGoods(int id) {
		return typegoodsService.deleteTypeGoods(id);
	}
	
	public boolean deleteTypeGoods(HttpServletRequest request,HttpServletResponse response) {
		String  _id =request.getParameter("id");
		try {
			int id = Integer.parseInt(_id);
			typegoodsService.deleteTypeGoods(id);
			findAll(request, response);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}

	/**
	 * ��������
	 * 
	 */
	public boolean updateTypeGoods(TypeGoods typegoods) {
		return typegoodsService.updateTypeGoods(typegoods);
	}
	
	public boolean updateTypeGoods(HttpServletRequest request,HttpServletResponse response) {
		String _id=request.getParameter("id");
		String name=request.getParameter("name");
		String gdesc=request.getParameter("gdesc");
		String image=request.getParameter("image");
		String _grade=request.getParameter("grade");
		try {
			int id= Integer.parseInt(_id);
			System.out.println("�õ���id");
			int grade=Integer.parseInt(_grade);
			System.out.println("updateType��������"+gdesc);
			System.out.println("grade��������"+grade);
			TypeGoods typegoods = new TypeGoods( id,  name,  gdesc,  image,  grade);
			boolean flag =typegoodsService.updateTypeGoods(typegoods);
			if(flag) {
				System.out.println("�޸�����ɹ�");
			}else {
				System.out.println("�޸�����ʧ��");
			}
			findAll(request, response);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
		
		return false;
	}

	/**
	 * ����id��ѯ����
	 * 
	 */
	public TypeGoods findTypeGoodsById(int id) {
		return typegoodsService.findTypeGoodsById(id);
	}
	
	public TypeGoods findTypeGoodsById(HttpServletRequest request,HttpServletResponse response) {
		TypeGoods typegoods = new TypeGoods();
		String  _id=request.getParameter("id");
		try {
			int id=Integer.parseInt(_id);
			typegoods =typegoodsService.findTypeGoodsById(id);
			System.out.println(typegoods+"�õ���typegoods");
			request.setAttribute("typegoods", typegoods);
			request.getRequestDispatcher("findTypeById.jsp").forward(request,  response);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return typegoods;
	}
	/**
	 * ��ҳ��ѯ
	 * 
	 */
	
	
}
