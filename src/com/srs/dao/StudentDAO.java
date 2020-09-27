package com.srs.dao;

import java.util.List;

import com.srs.domain.Student;

public interface StudentDAO {

	/**
	 * 
	 * @Title: initialize   
	 * @Description:初始化若干教授
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize();	
	/**
	 * 
	 * @Title: getByName   
	 * @Description: 根据姓名返回学生信息
	 * @param: @param name
	 * @param: @return      
	 * @return: Student      
	 * @throws
	 */
	Student getByName(String name);
	/**
	 * 
	 * @Title: getAll   
	 * @Description: 返回所有学生对象
	 * @param: @return      
	 * @return: List<Student>      
	 * @throws
	 */
	List<Student> getAll();
}
