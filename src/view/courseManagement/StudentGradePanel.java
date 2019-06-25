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
public class StudentGradePanel extends JPanel 
{
	JButton btnLectureApply;
	JComboBox<Semester> comboBoxSemester;
	JButton btnSearch;
	
	DefaultTableModel lectureGradeModel;
	JTable lectureGradeTable;
	
	/**
	 * Create the panel.
	 */
	
	public StudentGradePanel() 
	{
		setLayout(null);
		
		btnLectureApply = new JButton("수강 신청");
		btnLectureApply.setBounds(0, 0, 100, 30);
		add(btnLectureApply);
		
		JLabel lblNewLabel = new JLabel("성적 조회");
		lblNewLabel.setBounds(317, 29, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학기 : ");
		lblNewLabel_1.setBounds(240, 74, 47, 15);
		add(lblNewLabel_1);
		
		comboBoxSemester = new JComboBox<Semester>(Semester.values());
		comboBoxSemester.setBounds(283, 71, 96, 21);
		add(comboBoxSemester);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(390, 70, 65, 23);
		add(btnSearch);
		
		lectureGradeModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		lectureGradeTable = new JTable(lectureGradeModel);
		
		JScrollPane scrollPane = new JScrollPane(lectureGradeTable);
		scrollPane.setBounds(184, 119, 320, 350);
		add(scrollPane);
	}

	public void addListener(MouseListener listener)
	{
		btnSearch.addMouseListener(listener);
		btnLectureApply.addMouseListener(listener);
	}

	public JButton getBtnLectureApply() {
		return btnLectureApply;
	}

	public JComboBox<Semester> getComboBoxSemester() {
		return comboBoxSemester;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public DefaultTableModel getLectureGradeModel() {
		return lectureGradeModel;
	}

	public JTable getLectureGradeTable() {
		return lectureGradeTable;
	}
}
