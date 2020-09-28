package com.srs.domain;

/***
 * 
 * @ClassName:  Professor   
 * @Description:Professor 类  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:24:50      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class Professor extends Person{

	private String title;
	private String department;
	
	
	public Professor(String name, String ssn, String title, String department) {
		super(name, ssn);
		this.title = title;
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return getName() +"("+getTitle()+","+getDepartment()+")";
	}
	
}
