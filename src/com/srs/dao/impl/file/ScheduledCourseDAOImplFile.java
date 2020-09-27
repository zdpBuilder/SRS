package com.srs.dao.impl.file;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.srs.dao.CourseDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  ScheduledCourseDaoImpl   
 * @Description:课程表实现类   
 * @author: zdpBuilder
 * @date:   2020年9月22日 下午2:55:18      
 * @Copyright:
 */
public class ScheduledCourseDAOImplFile implements ScheduledCourseDAO {
	
	private Map<String, ScheduledCourse>  scheduledCourses = new HashMap<>();
	
	/***
	 * 
	 * <p>Title: initialize</p>   
	 * <p>Description: 从课程 安排某学期开出的课程</p>      
	 * @see com.srs.dao.ScheduledCourseDAO#initialize()
	 */
	@Override
	public void initialize(CourseDAO courseDAO) {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Calsses.dat"));
			while(bin.hasNext()) {
				String courseNumber = bin.next();
				int classNo = bin.nextInt();
				String dayOfWeek = bin.next();
				String timeOfDay = bin.next();
				String room = bin.next();
				int seatingCapacity = bin.nextInt();
				Course course = courseDAO.getByCourseNo(courseNumber);
				ScheduledCourse scheduledCourse = new ScheduledCourse(classNo, dayOfWeek, timeOfDay, course, room, seatingCapacity);
				scheduledCourses.put(scheduledCourse.getFullScheduleCourseNo(),scheduledCourse);
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
