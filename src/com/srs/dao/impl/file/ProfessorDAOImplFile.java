package com.srs.dao.impl.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.srs.dao.ProfessorDAO;
import com.srs.domain.Professor;

/**
 * 
 * @ClassName:  ProfessorDAOImplFile   
 * @Description:ProfessorDAO 实现类  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:23:02      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ProfessorDAOImplFile implements ProfessorDAO{

	private List<Professor> professors = new ArrayList<>();
	
	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Professors.dat"));
			while(bin.hasNext()) {
				String name = bin.next();
				String pin = bin.next();
				String tilte = bin.next();
				String department = bin.next();
				Professor professor = new Professor(name, pin, tilte,department);
				professors.add(professor);
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
	public Professor getByPID(String pid) {
		ListIterator<Professor> iterator  =professors.listIterator();
		Professor professor  =null;
		while(iterator.hasNext()) {
			professor = iterator.next();
			if(pid.equals(professor.getID())) 
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
