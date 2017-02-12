package com.ssg.hibernate.helloworld;

import java.sql.Blob;
import java.util.Date;

public class News {
	private Integer id; //field
	private String title;//field
	private String author;//field
	
	private String conts;//field
	
	private Blob picture;
	
	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getConts() {
		return conts;
	}

	public void setConts(String conts) {
		this.conts = conts;
	}
	

	private Date dates;

	


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

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
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
				+ ", date=" + dates + "]";
	}

}
