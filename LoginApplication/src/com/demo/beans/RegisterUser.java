package com.demo.beans;

import java.util.Arrays;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class RegisterUser 
{
	private String name,gender,username,password,question,answer;
	private String[] skills;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String name, String gender, String username, String password, String question, String answer,
			String[] skills) {
		super();
		this.name = name;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.skills = skills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "RegisterUser [name=" + name + ", gender=" + gender + ", username=" + username + ", password=" + password
				+ ", question=" + question + ", answer=" + answer + ", skills=" + Arrays.toString(skills) + "]";
	}
	
}
