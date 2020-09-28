package com.srs.dao;

import java.util.List;

import com.srs.domain.Course;

/***
 * 
 * @ClassName:  CourseDAO   
 * @Description: 定义课程业务操作   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:17:49      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface CourseDAO {

	/**
	 * 
	 * @Title: initialize   
	 * @Description:初始化教学计划中的课程  
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize();	
	/**
	 * 
	 * @Title: getByCourseNo   
	 * @Description: 根据课程号查询课程对象，如果没有该对象则返回 null
	 * @param: @param courseNo
	 * @param: @return      
	 * @return: Course      
	 * @throws
	 */
	Course getByCourseNo(String courseNo);
	/**
	 * 
	 * @Title: getAll   
	 * @Description: 返回所有课程   
	 * @param: @return      
	 * @return: List<Course>      
	 * @throws
	 */
	List<Course> getAll();
}
