package com.srs.dao.impl.db;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.srs.dao.StudentDAO;
import com.srs.domain.Student;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/***
 * 
 * @ClassName:  StudentDAOImpl   
 * @Description:学生接口实现类
 * @author: zdpBuilder
 * @date:   2020年9月22日 下午2:49:20      
 * @Copyright:
 */
public class StudentDAOImplDB implements StudentDAO {
	private List<Student> students = new ArrayList<>();

	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 resultSet = JDBC.QueryBySQL("select * from student");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 students = new ArrayList<>();
			 for (Map<String, Object> map : resultSet) {
				String id = (String) map.get("id");
				String name = (String) map.get("name");
				String major = (String) map.get("major");
				String degree = (String) map.get("degree");
				Student student = new Student(id,name,major,degree);
				students.add(student);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Student getByName(String name) {
		ListIterator<Student> iterator  =students.listIterator();
		Student student  =null;
		while(iterator.hasNext()) {
			student = iterator.next();
			if(name.equals(student.getName())) 
				break;
		}
		return student;
	}

	@Override
	public List<Student> getAll() {
		return students;
	}

}
