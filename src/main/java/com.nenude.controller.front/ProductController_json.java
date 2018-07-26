package com.nenude.controller.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/product_json")
public class ProductController_json extends HttpServlet {
	ProductService pService = new ProductServiceImpl();

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
			// 添加商品
			add(req, resp);
		} else if ("2".equals(option)) {
			// 查看所有商品 有分页查询
			findAll(req, resp);

		} else if ("3".equals(option)) {
			// 删除商品
			deleteProduct(req, resp);
		} else if ("4".equals(option)) {
			// 更新商品
			updateProduct(req, resp);
		} else if ("5".equals(option)) {
			findProductById(req, resp);
			// 查找单个商品
		}
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
//		//输出到前台
//		PrintWriter write=resp.getWriter();
//		String json=JSONArray.toJSONString(write);
//		System.out.println(json);
		
		boolean flag = pService.addProduct(product);
		if (flag) {
			findAll(req, resp);
			System.out.println("添加成功");
		} else {
			req.getRequestDispatcher("loginfail.jsp");
			System.out.println("添加失败");
		}
	}

	/** 添加商品 */
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
	/** 查询商品 */

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

		// 因为需要将数据显示在页面上所以需要调用显示信息的jsp
		try {
			request.getRequestDispatcher("showproductByPage.jsp").forward(request, response);
			System.out.println("跳转成功");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("跳转失败");
		}

	}

	// public void findAll(HttpServletRequest request,HttpServletResponse response){
	// List<Product> list= pService.findAll();
	// request.setAttribute("products", list);
	// //因为需要将数据显示在页面上所以需要调用显示信息的jsp
	// try {
	// request.getRequestDispatcher("showproduct.jsp").forward(request, response);
	// System.out.println("跳转成功");
	// } catch (ServletException | IOException e) {
	// // TODO Auto-generated catch block
	// System.out.println("跳转失败");
	// }
	//
	// }
	/** 修改商品 */
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

		System.out.println("修改的ID"+product.getId());
		boolean flag = pService.updateProduct(product);
		if (flag) {
			findAll(req, response);
			System.out.println("修改成功");
		} else {
			req.getRequestDispatcher("loginfail.jsp");
			System.out.println("修改失败");
		}

	}

	/** 删除商品 */
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = pService.deleteProduct(Integer.parseInt(request.getParameter("id")));

		if (flag) {
			findAll(request, response);
		} else {

			System.out.println("删除失败");
		}
	}

	/*
	 * 将数据显示到页面上需要用到作用域 因为需要将数据显示到页面上从页面获取数据，接受页面传过来的数据 1.先将数据显示到控制台
	 */
	public void findProductById(HttpServletRequest request, HttpServletResponse response) {
		// 获取id也可以通过如何将数据显示在页面上
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = pService.findProductById(id);
		request.setAttribute("product", product);
		try {
			request.getRequestDispatcher("findProductById.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Product findProductById(int id) {
		return pService.findProductById(id);
	}

}
