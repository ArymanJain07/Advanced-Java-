package com.demo.beans;

public class Movies {

	private int mId;
	private String title;
	private String category;
	
	
	public Movies(int mId, String title, String category) {
		super();
		this.mId = mId;
		this.title = title;
		this.category = category;
	}
	public Movies() {
		
	}
	public Movies(int mId) {
		super();
		this.mId = mId;
	}
	
	@Override
	public String toString() {
		return "Movies [mId=" + mId + ", title=" + title + ", category=" + category + "]";
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
