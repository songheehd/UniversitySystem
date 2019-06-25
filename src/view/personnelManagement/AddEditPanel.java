package view.personnelManagement;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Department;

import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class AddEditPanel extends JPanel 
{
	JTextField textFieldName;
	JTextField textFieldIdNumber;
	JTextField textFieldJumin;
	JComboBox<Department> comboBoxDept;
	
	JButton btnAdd;
	JButton btnReset;
	JButton btnBack;
	
	ButtonGroup groupRd;
	
	JRadioButton rdbtnProfessor;
	JRadioButton rdbtnStudent;

	/**
	 * 
	 * Create the panel.
	 */
	
	public AddEditPanel() 
	{
		setLayout(null);
		
		rdbtnProfessor = new JRadioButton("교수");
		rdbtnProfessor.setSelected(true);
		rdbtnProfessor.setBounds(48, 124, 57, 27);
		add(rdbtnProfessor);
		
		rdbtnStudent = new JRadioButton("학생");
		rdbtnStudent.setBounds(48, 169, 57, 27);
		add(rdbtnStudent);
		
		//라디오 버튼 그룹화하기 위한 객체 생성
		groupRd = new ButtonGroup();
		
		//그룹에 라디오 버튼 포함
		groupRd.add(rdbtnStudent);
		groupRd.add(rdbtnProfessor);
		
		this.add(rdbtnStudent);
		this.add(rdbtnProfessor);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(163, 80, 62, 18);
		add(lblName);
		
		JLabel lblId = new JLabel("학번/교수번호");
		lblId.setBounds(163, 128, 96, 18);
		add(lblId);
		
		JLabel lblDepartment = new JLabel("학과");
		lblDepartment.setBounds(163, 178, 96, 18);
		add(lblDepartment);
		
		JLabel lblJumin = new JLabel("주민등록 번호");
		lblJumin.setBounds(163, 223, 96, 18);
		add(lblJumin);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(282, 77, 116, 24);
		add(textFieldName); 
		
		textFieldIdNumber = new JTextField();
		textFieldIdNumber.setColumns(10);
		textFieldIdNumber.setBounds(282, 125, 116, 24);
		add(textFieldIdNumber);
		
		textFieldJumin = new JTextField();
		textFieldJumin.setColumns(10);
		textFieldJumin.setBounds(282, 220, 116, 24);
		add(textFieldJumin);
		
		btnAdd = new JButton("등록");
		btnAdd.setBounds(109, 298, 105, 27);
		add(btnAdd);
		
		btnReset = new JButton("재입력");
		btnReset.setBounds(228, 298, 105, 27);
		add(btnReset);
		
		btnBack = new JButton("←");
		btnBack.setBounds(426, 40, 47, 27);
		add(btnBack);
		
		comboBoxDept = new JComboBox<Department>(Department.values());
		comboBoxDept.setBounds(282, 172, 116, 24);
		add(comboBoxDept);
	}
	
	public void addListener(MouseListener listener)
	{
		btnAdd.addMouseListener(listener);
		btnReset.addMouseListener(listener);
		btnBack.addMouseListener(listener);
		rdbtnProfessor.addMouseListener(listener);
		rdbtnStudent.addMouseListener(listener);
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldId() {
		return textFieldIdNumber;
	}

	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldIdNumber = textFieldId;
	}


	public JTextField getTextFieldJumin() {
		return textFieldJumin;
	}

	public void setTextFieldJumin(JTextField textFieldJumin) {
		this.textFieldJumin = textFieldJumin;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JComboBox<Department> getComboBoxDept() {
		return comboBoxDept;
	}

	public void setComboBoxDept(JComboBox<Department> comboBoxDept) {
		this.comboBoxDept = comboBoxDept;
	}

	public JRadioButton getRdbtnProfessor() {
		return rdbtnProfessor;
	}

	public JRadioButton getRdbtnStudent() {
		return rdbtnStudent;
	}
	
	
	
}
