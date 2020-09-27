package com.srs.dao.impl.db;

import java.util.List;
import java.util.Map;

import com.srs.dao.ProfessorDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.dao.TeachingAssignmentDAO;
import com.srs.domain.Professor;
import com.srs.domain.ScheduledCourse;
import com.srs.utils.JDBC;
import com.srs.utils.EmptyUtils;

public class TeachingAssignmentDAOImplDB implements TeachingAssignmentDAO {

	@Override
	public void initialize(ProfessorDAO professorDAO, ScheduledCourseDAO scheduledCourseDAO) {

		List<Map<String,Object>> resultSet = null;
		try {
			resultSet = JDBC.QueryBySQL("select * from teaching_assignments");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 for (Map<String, Object> map : resultSet) {
				String pid = (String) map.get("pid");
				String calssNo = (String) map.get("calss_no");

				ScheduledCourse scheduledCourse = scheduledCourseDAO.getByID(calssNo);
				for (Professor professor : professorDAO.getAll()) {
					if(pid.equals(professor.getID()))
						scheduledCourse.setInstructor(professor);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

}
