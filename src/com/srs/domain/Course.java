package com.srs.domain;

/***
 * 
 * @ClassName:  Course   
 * @Description:课程类  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:24:03      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class Course {

	private String courseNo;
	private String courseName;
	private double credits;
	
	public Course(String courseNo, String courseName, double credits) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.credits = credits;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	
	public String toString() {
		return getCourseNo() +":"+getCourseName()+","+getCredits()+"学分";
	}
	
	public ScheduledCourse getScheduleCourse(String day,String time,String room,int capacity,int classNo) {
		ScheduledCourse scheduledCourse= new ScheduledCourse(classNo,day,time,this,room,capacity);
		return scheduledCourse;
	}
}
