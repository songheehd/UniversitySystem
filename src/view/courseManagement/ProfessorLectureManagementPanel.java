package view.courseManagement;

import javax.swing.JPanel;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import main.Grade;


@SuppressWarnings("serial")
public class ProfessorLectureManagementPanel extends JPanel 
{
	DefaultTableModel myLectureModel;
	JTable myLectureTable;
	
	DefaultTableModel studentListModel;
	JTable studentListTable;
	
	JTextField textFieldId;
	JTextField textFieldName;
	
	JButton btnAttendance;
	JComboBox<Grade> comboBoxGrade;
	JButton btnUpdate;
	
	/**
	 * Create the panel.
	 */
	
	public ProfessorLectureManagementPanel() 
	{
		setLayout(null);
		
		btnAttendance = new JButton("출석부 조회");
		btnAttendance.setBounds(0, 0, 120, 30);
		add(btnAttendance);
		
		JLabel lblNewLabel = new JLabel("강좌 관리");
		lblNewLabel.setBounds(320, 23, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("내 강좌");
		lblNewLabel_1.setBounds(140, 61, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("수강 학생");
		lblNewLabel_2.setBounds(472, 61, 65, 15);
		add(lblNewLabel_2);
		
		myLectureModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		myLectureTable = new JTable(myLectureModel);		
				
		studentListModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		studentListTable = new JTable(studentListModel);		
		
		JScrollPane scrollPaneLecture = new JScrollPane(myLectureTable);
		scrollPaneLecture.setBounds(41, 93, 258, 402);
		add(scrollPaneLecture);
		
		JScrollPane scrollPaneStudent = new JScrollPane(studentListTable);
		scrollPaneStudent.setBounds(335, 93, 327, 336);
		add(scrollPaneStudent);
		
		comboBoxGrade = new JComboBox<Grade>(Grade.values());
		comboBoxGrade.setBounds(510, 473, 80, 21);
		add(comboBoxGrade);
		
		btnUpdate = new JButton("입력");
		btnUpdate.setBounds(602, 473, 60, 23);
		add(btnUpdate);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(335, 473, 71, 21);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setEditable(false);
		textFieldName.setBounds(418, 473, 80, 21);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("학번");
		lblNewLabel_3.setBounds(340, 448, 42, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setBounds(423, 448, 48, 15);
		add(lblNewLabel_4);
		
		JLabel label = new JLabel("학점");
		label.setBounds(518, 448, 57, 15);
		add(label);

	}
	
	public void addListener(MouseListener listener)
	{
		btnAttendance.addMouseListener(listener);
		btnUpdate.addMouseListener(listener);
		comboBoxGrade.addMouseListener(listener);
		myLectureTable.addMouseListener(listener);
		studentListTable.addMouseListener(listener);		
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JButton getBtnAttendance() {
		return btnAttendance;
	}

	public JComboBox<Grade> getComboBoxGrade() {
		return comboBoxGrade;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
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
	
	
	
}
