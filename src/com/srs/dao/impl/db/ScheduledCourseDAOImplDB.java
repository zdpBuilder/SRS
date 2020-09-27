package com.srs.dao.impl.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.srs.dao.CourseDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/***
 * 
 * @ClassName:  ScheduledCourseDaoImpl   
 * @Description:课程表实现类   
 * @author: zdpBuilder
 * @date:   2020年9月22日 下午2:55:18      
 * @Copyright:
 */
public class ScheduledCourseDAOImplDB implements ScheduledCourseDAO {
	
	private Map<String, ScheduledCourse>  scheduledCourses =  new HashMap<>();;
	
	/***
	 * 
	 * <p>Title: initialize</p>   
	 * <p>Description: 从课程 安排某学期开出的课程</p>      
	 * @see com.srs.dao.ScheduledCourseDAO#initialize()
	 */
	@Override
	public void initialize(CourseDAO courseDAO) {
		List<Map<String,Object>> resultSet = null;
		 try {
			resultSet = JDBC.QueryBySQL("select * from schedule_course");
			if(EmptyUtils.objectIsEmpty(resultSet))
				return;
			
			for (Map<String, Object> map : resultSet) {
				String courseNumber = (String) map.get("course_no");
				int classNo = (Integer) map.get("calss_no");
				String dayOfWeek = (String) map.get("day_of_week");
				String timeOfDay = (String) map.get("time_of_day");
				String room = (String) map.get("room");
				int seatingCapacity = (Integer) map.get("capacity");
				Course course = courseDAO.getByCourseNo(courseNumber);
				ScheduledCourse scheduledCourse = course.getScheduleCourse(dayOfWeek, timeOfDay, room, seatingCapacity, classNo);
				scheduledCourses.put(scheduledCourse.getFullScheduleCourseNo(),scheduledCourse);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
