package com.Spring.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Advertises")
public class Advertises {
	@GeneratedValue
	@Id
	@Column(name = "Adv_Id")
	private long aid;
	@Column(name = "Category")
	private String category;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String desc;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Id")
	private long id;

	public Advertises() {
	}

	public Advertises(String category, String title, String desc) {
		super();
		this.category = category;
		this.title = title;
		this.desc = desc;
	}

	public Advertises(long aid, String category, String title, String desc) {
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
