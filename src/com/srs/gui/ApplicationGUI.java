package com.srs.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.srs.dao.CourseDAO;
import com.srs.dao.ProfessorDAO;
import com.srs.dao.ScheduledCourseDAO;
import com.srs.dao.StudentDAO;
import com.srs.dao.TeachingAssignmentDAO;
import com.srs.dao.impl.CourseDAOImpl;
import com.srs.dao.impl.ProfessorDAOImpl;
import com.srs.dao.impl.ScheduledCourseDAOImpl;
import com.srs.dao.impl.StudentDAOImpl;
import com.srs.dao.impl.TeachingAssignmentDAOImpl;
import com.srs.domain.EnrollmentStatus;
import com.srs.domain.ScheduledCourse;
import com.srs.domain.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationGUI {

	private JFrame frame;
	private JTable tableClass;
	private JTable tableStudent;
	ProfessorDAO professorDAO = new ProfessorDAOImpl();
	StudentDAO studentDAO = new StudentDAOImpl();
	CourseDAO courseDAO = new CourseDAOImpl();
	ScheduledCourseDAO scheduledCourseDAO = new ScheduledCourseDAOImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGUI window = new ApplicationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationGUI() {
		
		professorDAO.initialize();
		studentDAO.initialize();
		courseDAO.initialize();
		scheduledCourseDAO.initialize(courseDAO);
		TeachingAssignmentDAO tAssignmentDAO = new TeachingAssignmentDAOImpl();
		tAssignmentDAO.initialize(professorDAO, scheduledCourseDAO);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("学生选课系统\r\n");
		frame.setBounds(100, 100, 818, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel LabelClass = new JLabel("供选择的课程");
		LabelClass.setBounds(70, 29, 86, 15);
		frame.getContentPane().add(LabelClass);
		
		JLabel LabelStudent = new JLabel("学生");
		LabelStudent.setBounds(567, 29, 61, 15);
		frame.getContentPane().add(LabelStudent);
		
		JButton buttonRegist = new JButton("选课");
		buttonRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)tableClass.getModel();
				//完整课程号
				String fullClassNo = null;
				fullClassNo = (String)tableModel.getValueAt(tableClass.getSelectedRow(), 0);
				
				DefaultTableModel tableModelStudent = (DefaultTableModel) tableStudent.getModel();
				String studentName = null;
				studentName = (String)tableModelStudent.getValueAt(tableStudent.getSelectedRow(), 1);
				
				EnrollmentStatus status = scheduledCourseDAO.getByID(fullClassNo).enroll(studentDAO.getByName(studentName));
				JOptionPane.showMessageDialog(null, status.value());
			}
		});
		buttonRegist.setBounds(687, 220, 93, 23);
		frame.getContentPane().add(buttonRegist);
		
		JButton buttonExit = new JButton("结束");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonExit.setBounds(687, 268, 93, 23);
		frame.getContentPane().add(buttonExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 52, 463, 314);
		frame.getContentPane().add(scrollPane);
		
		tableClass = new JTable();
		tableClass.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setColumnHeaderView(tableClass);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(504, 47, 159, 319);
		frame.getContentPane().add(scrollPane_1);
		
		tableStudent = new JTable();
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableStudent);
		
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStudent.setBounds(513,51,157,315);
		DefaultTableModel tableModel = (DefaultTableModel) tableClass.getModel();
		//把开出的课程添加到表模型中
		String[] columnNames = {"完整课程号","课程名","学分","周几","上课时间","地点","授课教师","容量","已选人数"};
		tableModel.setColumnIdentifiers(columnNames);
		for (ScheduledCourse scheduledCourse : scheduledCourseDAO.getAll()) {
			String fullClassNo = scheduledCourse.getFullScheduleCourseNo();
			String courseName = scheduledCourse.getRepresentedCourse().getCourseName();
			Double credits = scheduledCourse.getRepresentedCourse().getCredits();
			String day = scheduledCourse.getDayOfWeek();
			String time = scheduledCourse.getTimeOfDay();
			String room = scheduledCourse.getRoom();
			String proName = scheduledCourse.getInstructor().getName();
			Integer capacity = scheduledCourse.getSeatingCapacity();
			Integer size = scheduledCourse.getTotalEnrollment();
			tableModel.addRow(new Object[] {fullClassNo,courseName,credits,day,time,room,proName,capacity,size});
		}
		DefaultTableModel tableModelStudent = (DefaultTableModel) tableStudent.getModel();
		String[] studentColomnNames = {"学号","姓名"};
		tableModelStudent.setColumnIdentifiers(studentColomnNames);
		
		for (Student student : studentDAO.getAll()) {
			String id  = student.getID();
			String name = student.getName();
			tableModelStudent.addRow(new Object[] {id,name});
			
		}
	}
}
