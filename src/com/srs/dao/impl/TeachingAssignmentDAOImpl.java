package com.srs.dao.impl;

import com.srs.dao.ProfessorDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.dao.TeachingAssignmentDAO;

public class TeachingAssignmentDAOImpl implements TeachingAssignmentDAO {

	@Override
	public void initialize(ProfessorDAO professorDAO, ScheduledCourseDAO scheduledCourseDAO) {
		//根据工号查找教授对象，安排所任课程
		scheduledCourseDAO.getByID("CS101-1").setInstructor(professorDAO.getByPID("123403"));
		scheduledCourseDAO.getByID("CS101-2").setInstructor(professorDAO.getByPID("123402"));
		scheduledCourseDAO.getByID("CS102-1").setInstructor(professorDAO.getByPID("123401"));
		scheduledCourseDAO.getByID("CS102-2").setInstructor(professorDAO.getByPID("123403"));
		scheduledCourseDAO.getByID("CS103-1").setInstructor(professorDAO.getByPID("123401"));
		scheduledCourseDAO.getByID("MAT101-1").setInstructor(professorDAO.getByPID("123402"));
		scheduledCourseDAO.getByID("CS201-1").setInstructor(professorDAO.getByPID("123403"));
		
	}

}
