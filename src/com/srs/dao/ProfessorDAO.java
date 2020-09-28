package com.srs.dao;

import java.util.List;

import com.srs.domain.Professor;

/**
 * 
 * @ClassName:  ProfessorDAO   
 * @Description:定义教授对象操作接口   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 下午2:18:22      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface ProfessorDAO {

	/**
	 * 
	 * @Title: initialize   
	 * @Description:初始化若干教授  
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize();	
	/**
	 * 
	 * @Title: getByPID   
	 * @Description: 根据工号返回教授对象
	 * @param: @param pid
	 * @param: @return      
	 * @return: Professor      
	 * @throws
	 */
	Professor getByPID(String pid);
	/**
	 * 
	 * @Title: getAll   
	 * @Description: 返回所有教授
	 * @param: @return      
	 * @return: List<Professor>      
	 * @throws
	 */
	List<Professor> getAll();
}
