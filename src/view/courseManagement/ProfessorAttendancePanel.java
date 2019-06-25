package view.courseManagement;

import javax.swing.JPanel;

import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Semester;

@SuppressWarnings("serial")
public class ProfessorAttendancePanel extends JPanel 
{
	DefaultTableModel myLectureModel;
	JTable myLectureTable;
	
	DefaultTableModel studentListModel;
	JTable studentListTable;
	
	JButton btnLectureManagement;
	JButton btnSearch;
	JComboBox<Semester> comboBoxSemester;
	
	/**
	 * Create the panel.
	 */
	
	public ProfessorAttendancePanel() 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("출석부 조회");
		lblNewLabel.setBounds(317, 35, 78, 15);
		add(lblNewLabel);
		
		btnLectureManagement = new JButton("강좌 관리");
		btnLectureManagement.setBounds(0, 0, 120, 30);
		add(btnLectureManagement);
		
		JLabel lblNewLabel_1 = new JLabel("학기 : ");
		lblNewLabel_1.setBounds(82, 97, 51, 15);
		add(lblNewLabel_1);
		
		comboBoxSemester = new JComboBox<Semester>(Semester.values());
		comboBoxSemester.setBounds(123, 94, 80, 21);
		add(comboBoxSemester);
		
		JLabel lblNewLabel_2 = new JLabel("담당 강의");
		lblNewLabel_2.setBounds(150, 68, 57, 15);
		add(lblNewLabel_2);
		
		btnSearch = new JButton("조회");
		btnSearch.setBounds(215, 93, 60, 23);
		add(btnSearch);
		
		myLectureModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		myLectureTable = new JTable(myLectureModel);		
		
		JScrollPane scrollPaneLecture = new JScrollPane(myLectureTable);
		scrollPaneLecture.setBounds(58, 132, 252, 368);
		add(scrollPaneLecture);
		
		JLabel lblNewLabel_3 = new JLabel("수강 학생");
		lblNewLabel_3.setBounds(489, 68, 57, 15);
		add(lblNewLabel_3);
		
		studentListModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		studentListTable = new JTable(studentListModel);		

		JScrollPane scrollPaneStudent = new JScrollPane(studentListTable);
		scrollPaneStudent.setBounds(385, 94, 260, 406);
		add(scrollPaneStudent);
	
	}
	
	public void addListener(MouseListener listener)
	{
		btnLectureManagement.addMouseListener(listener);
		btnSearch.addMouseListener(listener);
		myLectureTable.addMouseListener(listener);
	}

	public DefaultTableModel getMyLectureModel() {
		return myLectureModel;
	}

	public JTable getMyLectureTable() {
		return myLectureTable;
	}

	public DefaultTableModel getStudentListModel() {
		return studentListModel;
	}

	public JTable getStudentListTable() {
		return studentListTable;
	}

	public JButton getBtnLectureManagement() {
		return btnLectureManagement;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JComboBox<Semester> getComboBoxSemester() {
		return comboBoxSemester;
	}
	
	
}
