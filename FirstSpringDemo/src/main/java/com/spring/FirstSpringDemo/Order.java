package com.spring.FirstSpringDemo;

public class Order {

	private int price;
	private String name;

	public Order(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public Order() {
		super();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}