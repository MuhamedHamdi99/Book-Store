package com.bookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyBooks")
public class MyBook_List {

	
	@Id
	private int id;
	private String name;
	private String auther;
	private String price;
	public MyBook_List(int id, String name, String auther, String price) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
		this.price = price;
	}
	public MyBook_List() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
