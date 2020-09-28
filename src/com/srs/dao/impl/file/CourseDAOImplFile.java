package com.srs.dao.impl.file;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.srs.dao.CourseDAO;
import com.srs.domain.Course;

/***
 * 
 * @ClassName:  CourseDAOImplFile   
 * @Description: CourseDAO实现类   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:22:50      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class CourseDAOImplFile implements CourseDAO{
	private Map<String, Course> courses =  new HashMap<String,Course>();
	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Courses.dat"));
			while(bin.hasNext()) {
				String courseNumber = bin.next();
				String courseName = bin.next();
				double courseCredits = bin.nextDouble();
				Course course = new Course(courseNumber, courseName, courseCredits);
				courses.put(course.getCourseNo(), course);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bin.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
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
