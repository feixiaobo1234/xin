package ceshi;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

public class json {
		public static void main(String[] args) {
			ProductService pro = new ProductServiceImpl();
			List<Product> list =pro.findAll();
			
			String json=JSONArray.toJSONString(list);
			System.out.println(json);
			
		}
}
