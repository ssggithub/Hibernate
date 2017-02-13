package com.ssg.hibernate.entities;

import java.sql.Blob;
import java.util.Date;


public class News {
	
	private Integer id;
	private String title;
	private String author;
	
	private Date dates;
	
	//大文本
	private String conts;
	//二进制数据
	private Blob image;
	
	
	 

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	 

	public News(String title, String author, Date dates) {
		super();
		this.title = title;
		this.author = author;
		this.dates = dates;
	}
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author
				+ ", dates=" + dates + "]";
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getConts() {
		return conts;
	}

	public void setConts(String conts) {
		this.conts = conts;
	}

	 
	
}
