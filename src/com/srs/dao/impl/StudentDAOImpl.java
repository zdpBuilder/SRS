package com.srs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.srs.dao.StudentDAO;
import com.srs.domain.Student;

/***
 * 
 * @ClassName:  StudentDAOImpl   
 * @Description:学生接口实现类
 * @author: zdpBuilder
 * @date:   2020年9月22日 下午2:49:20      
 * @Copyright:
 */
public class StudentDAOImpl implements StudentDAO {
	private List<Student> students = new ArrayList<>();

	@Override
	public void initialize() {
		Student  s1,s2,s3;
		s1 = new Student("张三","202001001","数学","学士");
		s2 = new Student("李四","202001002","计算机科学与技术","学士");
		s3 = new Student("王五","202001003","计算机科学与技术","学士");
		students.add(s1);
		students.add(s2);
		students.add(s3);	
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
