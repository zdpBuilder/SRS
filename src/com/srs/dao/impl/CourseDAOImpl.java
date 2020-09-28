package com.srs.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.srs.dao.CourseDAO;
import com.srs.domain.Course;

/***
 * 
 * @ClassName:  CourseDAOImpl   
 * @Description:CourseDAO 实现类  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:20:06      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class CourseDAOImpl implements CourseDAO{
	private Map<String, Course> courses =  new HashMap<String,Course>();
	@Override
	public void initialize() {
		Course c1,c2,c3,c4,c5;
		c1 = new Course("CS101", "C 程序设计", 3.0);
		c2 = new Course("CS102", "面向对象程序设计", 3.0);
		c3 = new Course("CS103", "数据机构与算法", 4.0);
		c4 = new Course("MAT101", "概率与统计", 3.0);
		c5 = new Course("CS201", "离散数学", 3.0);
		
		courses.put(c1.getCourseNo(), c1);
		courses.put(c2.getCourseNo(), c2);
		courses.put(c3.getCourseNo(), c3);
		courses.put(c4.getCourseNo(), c4);
		courses.put(c5.getCourseNo(), c5);
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
