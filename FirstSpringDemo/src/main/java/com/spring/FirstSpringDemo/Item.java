package com.spring.FirstSpringDemo;

public class Item {
	private int itemPrice;
	public void setItemName(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Item Price: " + itemPrice;
	}
}