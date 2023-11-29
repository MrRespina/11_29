package com.ji.spring002.book;

import java.math.BigDecimal;

public class Book {

	private String name;
	private BigDecimal price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
