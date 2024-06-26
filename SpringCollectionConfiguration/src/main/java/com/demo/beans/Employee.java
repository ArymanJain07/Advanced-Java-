package com.demo.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	private int pid;
	private String pname;
	private Set<String> addresses;
	private List<String> phone;
	private Map<String,String> courses;
	
	
	public Employee(int pid, String pname, Set<String> addresses, List<String> phone, Map<String, String> courses) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.addresses = addresses;
		this.phone = phone;
		this.courses = courses;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Employee [pid=" + pid + ", pname=" + pname + ", addresses=" + addresses + ", phone=" + phone
				+ ", courses=" + courses + "]";
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Set<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}

}
