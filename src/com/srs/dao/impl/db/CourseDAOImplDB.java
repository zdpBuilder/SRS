package com.srs.dao.impl.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.srs.dao.CourseDAO;
import com.srs.domain.Course;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/**
 * 
 * @ClassName:  CourseDAOImplDB   
 * @Description:CourseDAO 实现类   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:21:36      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class CourseDAOImplDB implements CourseDAO{
	private Map<String, Course> courses = null;
	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 resultSet = JDBC.QueryBySQL("select * from course_catalog");
			if(EmptyUtils.objectIsEmpty(resultSet))
				return;
			courses = new HashMap<String,Course>();
			for (Map<String, Object> map : resultSet){
				String courseNumber = (String) map.get("course_no");
				String courseName = (String) map.get("course_name");
				double courseCredits = Double.valueOf(map.get("credits").toString());
				Course course = new Course(courseNumber, courseName, courseCredits);
				courses.put(course.getCourseNo(), course);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Course getByCourseNo(String courseNo) {
		 
		return courses.get(courseNo);
	}

	@Override
	public List<Course> getAll() {
		List<Course> c = new LinkedList<>();
		for (Map.Entry<String, Course> course : courses.entrySet()) {
			c.add(course.getValue());
		}
		return c;
	}

}
