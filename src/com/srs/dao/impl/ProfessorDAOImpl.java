package com.srs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.srs.dao.ProfessorDAO;
import com.srs.domain.Professor;

/**
 * 
 * @ClassName:  ProfessorDAOImpl   
 * @Description:ProfessorDAO 实现类   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:20:28      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ProfessorDAOImpl implements ProfessorDAO{

	private List<Professor> professors = new ArrayList<>();
	
	@Override
	public void initialize() {
		Professor  p1,p2,p3;
		p1 = new Professor("董永","123401","副教授","计算机科学与技术");
		p2 = new Professor("赵云","123402","教授","计算机科学与技术");
		p3 = new Professor("郭天","123403","教授","数学");
		professors.add(p1);
		professors.add(p2);
		professors.add(p3);
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
