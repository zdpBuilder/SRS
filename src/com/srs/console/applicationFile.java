package com.srs.console;

import com.srs.dao.CourseDAO;
import com.srs.dao.ProfessorDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.dao.StudentDAO;
import com.srs.dao.TeachingAssignmentDAO;
import com.srs.dao.impl.file.CourseDAOImplFile;
import com.srs.dao.impl.file.ProfessorDAOImplFile;
import com.srs.dao.impl.file.ScheduledCourseDAOImplFile;
import com.srs.dao.impl.file.StudentDAOImplFile;
import com.srs.dao.impl.file.TeachingAssignmentDAOImplFile;
import com.srs.domain.EnrollmentStatus;
import com.srs.domain.Professor;
import com.srs.domain.ScheduledCourse;
import com.srs.domain.Student;

/***
 * 
 * @ClassName:  applicationFile   
 * @Description:程序入口  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:17:23      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class applicationFile {

	public static void main(String[] args) {
	
		ProfessorDAO professorDAO = new ProfessorDAOImplFile();
		professorDAO.initialize();
		System.out.println("============教授=============");
		for (Professor  entry : professorDAO.getAll())
			System.out.println(entry);
		
		StudentDAO studentDAO = new StudentDAOImplFile();
		studentDAO.initialize();
		System.out.println("============学生=============");
		for (Student  entry : studentDAO.getAll())
			System.out.println(entry);
		
		CourseDAO courseDAO = new CourseDAOImplFile();
		courseDAO.initialize();
		
		ScheduledCourseDAO scheduledCourseDAO = new ScheduledCourseDAOImplFile();
		scheduledCourseDAO.initialize(courseDAO);
		//安排任课教师
		TeachingAssignmentDAO tAssignmentDAO = new TeachingAssignmentDAOImplFile();
		tAssignmentDAO.initialize(professorDAO, scheduledCourseDAO);
		System.out.println("=============开出的课程==============");
		for(ScheduledCourse entry:scheduledCourseDAO.getAll())
			System.out.println(entry);
		
		System.out.println();
		//下面演示学生张三注册了，一门容量为1的课，王五再注册则失败
		EnrollmentStatus status;
		
		System.out.println("学生 张三 试图注册 CS201-1");
		status = scheduledCourseDAO.getByID("CS201-1").enroll(studentDAO.getByName("张三"));
		System.out.println(status.value());
		
		System.out.println("学生 王五 试图注册 CS201-1");
		status = scheduledCourseDAO.getByID("CS201-1").enroll(studentDAO.getByName("王五"));
		System.out.println(status.value());
	}
}
