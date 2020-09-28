package com.srs.dao;

import java.util.List;

import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  ScheduledCourseDAO   
 * @Description:定义课程时间表操作类 
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:18:56      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface ScheduledCourseDAO {

	/**
	 * 
	 * @Title: initialize   
	 * @Description:初始化某学期拟开出的若干们课，这些课必须是教学计划的课程
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize(CourseDAO courseDAO);	
	/**
	 * 
	 * @Title: getByPID   
	 * @Description: 根据课程好查课
	 * @param: @param id
	 * @param: @return      
	 * @return: ScheduledCourse      
	 * @throws
	 */
	ScheduledCourse getByID(String id);
	/**
	 * 
	 * @Title: getAll   
	 * @Description: 返回所有课对象
	 * @param: @return      
	 * @return: List<ScheduledCourse>      
	 * @throws
	 */
	List<ScheduledCourse> getAll();
}
