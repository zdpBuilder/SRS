package com.srs.dao;

import java.util.List;

import com.srs.domain.ScheduledCourse;

/**
 * 
 * @ClassName:  ScheduledCourseDAO   
 * @Description:课程时间表接口类   
 * @author: zdpBuilder
 * @date:   2020年9月22日 上午8:36:51      
 * @Copyright:
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
