package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * java实体类 javaBean 定义JavaBean (1)属性私有 (2)提供有参/无参的构造方法 （3）提供get/set方法 （4）实现序列化接口
 */
public class TypeGoods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5641686548432341362L;

	/**
	 * 
	 */
	private int id; // 商品种类id
	private String name;// 商品种类名称
	private String gdesc;// 商品种类描述
	private String image;// 商品种类图片
	private Date ctime;// 当前创建时间
	private int grade;//等级

	public TypeGoods() {
		super();
	}

	public TypeGoods(int id, String name, String desc, String image) {
		this.id = id;
		this.name = name;
		this.gdesc = desc;
		this.image = image;

	}

	public TypeGoods(int id, String name, String gdesc, String image, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.gdesc = gdesc;
		this.image = image;
		this.grade = grade;
	}

	public TypeGoods(int id, String name, String gdesc, String image, Date ctime, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.gdesc = gdesc;
		this.image = image;
		this.ctime = ctime;
		this.grade = grade;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return gdesc;
	}

	public void setDesc(String desc) {
		this.gdesc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
