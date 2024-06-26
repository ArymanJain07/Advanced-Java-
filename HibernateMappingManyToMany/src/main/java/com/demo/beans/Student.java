package com.demo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	private int sid;
	private String sname;

	@OneToMany(mappedBy="stud")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", laptop=" + laptop + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public Student(int sid, String sname, List<Laptop> laptop) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.laptop = laptop;
	}
	
	
}
