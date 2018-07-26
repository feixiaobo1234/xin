package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * javaʵ���� javaBean ����JavaBean (1)����˽�� (2)�ṩ�в�/�޲εĹ��췽�� ��3���ṩget/set���� ��4��ʵ�����л��ӿ�
 */
public class TypeGoods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5641686548432341362L;

	/**
	 * 
	 */
	private int id; // ��Ʒ����id
	private String name;// ��Ʒ��������
	private String gdesc;// ��Ʒ��������
	private String image;// ��Ʒ����ͼƬ
	private Date ctime;// ��ǰ����ʱ��
	private int grade;//�ȼ�

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
