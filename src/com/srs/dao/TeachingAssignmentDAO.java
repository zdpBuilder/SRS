package com.srs.dao;

/***
 * 
 * @ClassName:  TeachingAssignmentDAO   
 * @Description: 定义教学任务业务操作接口   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:19:38      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface TeachingAssignmentDAO {

	void initialize(ProfessorDAO professorDAO,ScheduledCourseDAO scheduledCourseDAO);
}
