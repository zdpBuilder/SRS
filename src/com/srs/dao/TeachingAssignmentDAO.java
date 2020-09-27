package com.srs.dao;

/***
 * 
 * @ClassName:  TeachingAssignmentDAO   
 * @Description:教学任务接口  
 * @author: zdpBuilder
 * @date:   2020年9月22日 上午8:39:57      
 * @Copyright:
 */
public interface TeachingAssignmentDAO {

	void initialize(ProfessorDAO professorDAO,ScheduledCourseDAO scheduledCourseDAO);
}
