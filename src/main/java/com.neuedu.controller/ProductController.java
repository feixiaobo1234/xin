package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/product")
public class ProductController extends HttpServlet {

	ProductService pService = new ProductServiceImpl();

//    @Override
//    public void init() throws ServletException {
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        pService=webApplicationContext.getBean(ProductService.class);
//    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String option = req.getParameter("option");
		System.out.println(option);
		if ("1".equals(option)) {
			// �����Ʒ
			add(req, resp);
		} else if ("2".equals(option)) {
			// �鿴������Ʒ �з�ҳ��ѯ
//			findAll(req, resp);
			findAll1(req,resp);

		} else if ("3".equals(option)) {
			// ɾ����Ʒ
			deleteProduct(req, resp);
		} else if ("4".equals(option)) {
			// ������Ʒ
			updateProduct(req, resp);
		} else if ("5".equals(option)) {
			findProductById( resp,req);
			// ���ҵ�����Ʒ
		}
	}
//	添加商品jsp
	public void add(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		Integer stock = 0;
		Double price = 0.0;
		String rule = req.getParameter("rule");
		String image = req.getParameter("image");
		try {
			stock = Integer.parseInt(req.getParameter("stock"));
			price = Double.parseDouble(req.getParameter("price"));
		} catch (Exception e) {
			throw new RuntimeException();
		}
		Product product = new Product();
		product.setName(name);
		product.setDesc(desc);
		product.setPrice(price);
		product.setRule(rule);
		product.setImage(image);
		product.setStock(stock);
		System.out.println(product);
		boolean flag = pService.addProduct(product);
		if (flag) {
			findAll(req, resp);
			System.out.println("添加成功");
		} else {
			req.getRequestDispatcher("loginfail.jsp");
			System.out.println("添加失败");
		}
	}

	/** 添加商品  需要输入数据*/
	public boolean addProduct(Product product) {
		return pService.addProduct(product);
	}

	// public boolean addProduct( ) {
	// Product product = new Product();
	//
	//
	//
	// return pService.addProduct(product);
	// }

	public void  findAll1(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin" , "*");


//		List list =pService.findAll();
		ProductDao productDao = new ProductDaoImpl();
		List list = productDao.findAll();
		Gson gson = new Gson();
		String list1=gson.toJson(list);
		try {
			PrintWriter writer =response.getWriter();
			writer.print(list1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




	/** 分页查询jsp */

	@SuppressWarnings("unchecked")

	public void findAll(HttpServletRequest request, HttpServletResponse response) {


		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}

		int _pageSize = 5;
		int _pageNo = 1;
		try {
			_pageNo = Integer.parseInt(pageNo);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		PageModel<Product> pageModel = pService.findProductByPage(_pageNo, _pageSize);

		request.setAttribute("pageModel", pageModel);

		// ��Ϊ��Ҫ��������ʾ��ҳ����������Ҫ������ʾ��Ϣ��jsp
		try {
			request.getRequestDispatcher("showproductByPage.jsp").forward(request, response);
			System.out.println("��ת�ɹ�");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��תʧ��");
		}

	}

	// public void findAll(HttpServletRequest request,HttpServletResponse response){
	// List<Product> list= pService.findAll();
	// request.setAttribute("products", list);
	// //��Ϊ��Ҫ��������ʾ��ҳ����������Ҫ������ʾ��Ϣ��jsp
	// try {
	// request.getRequestDispatcher("showproduct.jsp").forward(request, response);
	// System.out.println("��ת�ɹ�");
	// } catch (ServletException | IOException e) {
	// // TODO Auto-generated catch block
	// System.out.println("��תʧ��");
	// }
	//
	// }
	/** 更新商品 jsp*/
	public void updateProduct(HttpServletRequest req, HttpServletResponse response) {
		String _id = req.getParameter("id");
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		Integer stock = 0;
		Double price = 0.0;
		String rule = req.getParameter("rule");
		String image = req.getParameter("image");
		int id = 0;
		try {
			id = Integer.parseInt(_id);
			stock = Integer.parseInt(req.getParameter("stock"));
			price = Double.parseDouble(req.getParameter("price"));
		} catch (Exception e) {
			throw new RuntimeException();
		}
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDesc(desc);
		product.setPrice(price);
		product.setRule(rule);
		product.setImage(image);
		product.setStock(stock);

		System.out.println("�޸ĵ�ID"+product.getId());
		boolean flag = pService.updateProduct(product);
		if (flag) {
			findAll(req, response);
			System.out.println("�޸ĳɹ�");
		} else {
			req.getRequestDispatcher("loginfail.jsp");
			System.out.println("�޸�ʧ��");
		}

	}

	/**删除商品 jsp */
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = pService.deleteProduct(Integer.parseInt(request.getParameter("id")));

		if (flag) {
			findAll(request, response);
		} else {

			System.out.println("ɾ��ʧ��");
		}
	}

	/*
	 * ��������ʾ��ҳ������Ҫ�õ������� ��Ϊ��Ҫ��������ʾ��ҳ���ϴ�ҳ���ȡ���ݣ�����ҳ�洫���������� 1.�Ƚ�������ʾ������̨
	 */
//	查询单个商品
	public void findProductById(HttpServletRequest request, HttpServletResponse response) {
		// ��ȡidҲ����ͨ����ν�������ʾ��ҳ����
        response.setHeader("Access-Control-Allow-Origin" , "*");
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = pService.findProductById(id);

		request.setAttribute("product", product);

		Gson gson = new Gson();
		String product1=gson.toJson(product);
		try {
		   PrintWriter writer = response.getWriter();
		   writer.print(product1);
			request.getRequestDispatcher("findProductById.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//查询单个商品

	public void findProductById( HttpServletResponse response,HttpServletRequest request) {
		// ��ȡidҲ����ͨ����ν�������ʾ��ҳ����
		response.setHeader("Access-Control-Allow-Origin" , "*");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("这个id是"+id);
		Product product = pService.findProductById(id);
		System.out.println("单个商品名字"+product.getName());
		Gson gson = new Gson();
		String product1=gson.toJson(product);

		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(product1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Product findProductById(int id) {
		return pService.findProductById(id);
	}

}
