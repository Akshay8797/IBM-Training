package com.Spring.Json;

public class Advertise {
	private long aid;
	private String category;
	private String title;
	private String desc;

	public Advertise() {
	}

	public Advertise(String category, String title, String desc) {
		super();
		this.category = category;
		this.title = title;
		this.desc = desc;
	}

	public Advertise(long aid, String category, String title, String desc) {
		this.aid = aid;
		this.category = category;
		this.title = title;
		this.desc = desc;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + aid + ", category=" + category + ", title=" + title + ", desc=" + desc + "]";
	}
}