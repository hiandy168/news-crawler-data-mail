package com.onemt.news.crawler.entity;

import java.io.Serializable;

public class Book implements Serializable {

	
	private static final long serialVersionUID = -8414055789329701202L;
	private String id;
	private String name;
	private Double price;
	
	public Book(){}
	
	public Book(String id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
