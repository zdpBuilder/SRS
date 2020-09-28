package com.srs.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.srs.dao.CourseDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  ScheduledCourseDAOImpl   
 * @Description:ScheduledCourseDAO 实现类   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:20:43      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ScheduledCourseDAOImpl implements ScheduledCourseDAO {
	
	private Map<String, ScheduledCourse>  scheduledCourses = new HashMap<>();
	
	/***
	 * 
	 * <p>Title: initialize</p>   
	 * <p>Description: 从课程 安排某学期开出的课程</p>      
	 * @see com.srs.dao.ScheduledCourseDAO#initialize()
	 */
	@Override
	public void initialize(CourseDAO courseDAO) {
		ScheduledCourse calss1,calss2,calss3,calss4,calss5,calss6,calss7;
		Course course = courseDAO.getByCourseNo("CS101");
		calss1 = course.getScheduleCourse("周一", "上午 8：00-10：00", "A101", 30, 1);
		calss2 = course.getScheduleCourse("周二", "上午 8：00-10：00", "C202",30, 2);

		course = courseDAO.getByCourseNo("CS102");
		calss3 = course.getScheduleCourse("周三", "下午 2：00-4：00", "C05", 25, 1);
		calss4 = course.getScheduleCourse("周四", "下午 4：00-6：00", "D330",25, 2);
		
		course = courseDAO.getByCourseNo("CS103");
		calss5 = course.getScheduleCourse("周一", "下午 6：00-8：00", "E101", 20, 1);
		
		course = courseDAO.getByCourseNo("MAT101");
		calss6 = course.getScheduleCourse("周五", "下午 4：00-6：00", "D", 15, 1);
		
		course = courseDAO.getByCourseNo("CS201");
		calss7 = course.getScheduleCourse("周一", "下午 4：00-6：00", "A205", 1, 1);
		scheduledCourses.put(calss1.getFullScheduleCourseNo(), calss1);
		scheduledCourses.put(calss2.getFullScheduleCourseNo(), calss2);
		scheduledCourses.put(calss3.getFullScheduleCourseNo(), calss3);
		scheduledCourses.put(calss4.getFullScheduleCourseNo(), calss4);
		scheduledCourses.put(calss5.getFullScheduleCourseNo(), calss5);
		scheduledCourses.put(calss6.getFullScheduleCourseNo(), calss6);
		scheduledCourses.put(calss7.getFullScheduleCourseNo(), calss7);
	}

	@Override
	public ScheduledCourse getByID(String id) {
		
		return scheduledCourses.get(id);
	}

	@Override
	public List<ScheduledCourse> getAll() {
		List<ScheduledCourse> s = new LinkedList<>();
		for (Map.Entry<String, ScheduledCourse> entry : scheduledCourses.entrySet()) {
			s.add(entry.getValue());
		}
		return s;
	}

}
