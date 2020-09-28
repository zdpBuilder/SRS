package com.srs.dao.impl.db;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.srs.dao.ProfessorDAO;
import com.srs.domain.Professor;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/***
 * 
 * @ClassName:  ProfessorDAOImplDB   
 * @Description: ProfessorDAO实现类   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:21:55      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ProfessorDAOImplDB implements ProfessorDAO {

	private List<Professor> professors = null;

	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 
			 resultSet = JDBC.QueryBySQL("select * from faculty");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 professors = new ArrayList<>();
			 for (Map<String, Object> map : resultSet) {
					String name = (String) map.get("name");
					String pin = (String) map.get("pid");
					String tilte = (String) map.get("title");
					String department = (String) map.get("dept");
					Professor professor = new Professor(name, pin, tilte,department);
					professors.add(professor);
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Professor getByPID(String pid) {
		ListIterator<Professor> iterator = professors.listIterator();
		Professor professor = null;
		while (iterator.hasNext()) {
			professor = iterator.next();
			if (pid.equals(professor.getID()))
				break;
		}
		return professor;
	}

	@Override
	public List<Professor> getAll() {
		// TODO Auto-generated method stub
		return professors;
	}

}
