package com.srs.dao.impl.file;

import java.io.File;
import java.util.Scanner;

import com.srs.dao.ProfessorDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.dao.TeachingAssignmentDAO;
import com.srs.domain.Professor;

public class TeachingAssignmentDAOImplFile implements TeachingAssignmentDAO {

	@Override
	public void initialize(ProfessorDAO professorDAO, ScheduledCourseDAO scheduledCourseDAO) {

		Scanner bin = null;
		Professor professor = null;
		try {
			bin = new Scanner(new File("file/TeachingAssignments.dat"));
			while (bin.hasNext()) {
				String pin = bin.next();
				String calssNo = bin.next();

				// 根据工号查找教授对象
				professor = professorDAO.getByPID(pin);
				if (professor != null)
					scheduledCourseDAO.getByID(calssNo).setInstructor(professor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bin.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

	}

}
