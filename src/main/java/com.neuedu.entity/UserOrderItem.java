package com.neuedu.entity;

import java.io.Serializable;

/**
 * 订单明细实体类
 * */
public class UserOrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7043733043311467481L;
	private  int  id;
	private  long order_no;//订单编号
	private int user_id;//用户ID
	private int product_id;//商品ID
	private String product_name;//商品名称
	private String product_image;//商品图片
	private double current_unit_price;//商品现在的价格
	private int quantity;//商品数量
	private double total_price;//商品价格
	private long create_time;//创建时间
	private long update_time;//更新时间
	public UserOrderItem(int id, long order_no, int user_id, int product_id, String product_name, String product_image,
			double current_unit_price, int quantity, double total_price, long create_time, long update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public UserOrderItem() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public double getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(double current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "UserOrderItem [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", product_id="
				+ product_id + ", product_name=" + product_name + ", product_image=" + product_image
				+ ", current_unit_price=" + current_unit_price + ", quantity=" + quantity + ", total_price="
				+ total_price + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
	
	
}
