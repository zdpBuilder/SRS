package com.srs.dao.impl.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
public class StudentDAOImplFile implements StudentDAO {
	private List<Student> students = new ArrayList<>();

	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Students.dat"));
			while(bin.hasNext()) {
				String id = bin.next();
				String name = bin.next();
				String major = bin.next();
				String degree = bin.next();
				Student student = new Student(id,name,major,degree);
				students.add(student);
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
