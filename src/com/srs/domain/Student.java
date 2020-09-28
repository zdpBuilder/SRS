package com.srs.domain;

/***
 * 
 * @ClassName:  Student   
 * @Description:    Student 类
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:25:16      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class Student extends Person{

	private String major;
	private String degree;
	
	
	public Student() {
		super();
		
	}
	public Student(String name, String ssn,String major,String degree) {
		super(name, ssn);
		this.setMajor(major);
		this.setDegree(degree);
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * 
	 * Title: toString  
	 * Description:   返回如下格式的字符串表示：张三 (201901001)[硕士-计算机科学与技术]
	 * @return   
	 * @see com.srs.domain.Person#toString()
	 */
	@Override
	public String toString() {
		return this.getName()+"("+this.getID()+")["+this.getDegree()+"-"+this.getMajor()+"]";
	}
	@Override
	public int hashCode() {
		return this.getID().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Student student = (Student)obj;
		
		return this.getID().equals(student.getID());
//		if(this.getID().equals(student.getID()))
//			return true;
//		else 
//			return false;
	}
	
	
}
