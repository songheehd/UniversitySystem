package view.courseManagement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class StudentCourseApplyPanel extends JPanel 
{	
	
	/**
	 * Create the panel.
	 */
	DefaultTableModel openLectureModel;
	JTable openLectureTable;
	
	DefaultTableModel appliedLectureModel;
	JTable appliedLectureTable;
	
	JButton btnGrade;
	JButton btnDetailInfo;
	JButton btnLectureApply;
	JButton btnApplyCancel;
	
	
	public StudentCourseApplyPanel() 
	{			 
		setLayout(null);

		JLabel lblTitle = new JLabel("수강 신청");
		lblTitle.setBounds(326, 23, 57, 15);
		add(lblTitle);
		
		JLabel lblOpenLecture = new JLabel("개설된 강의");
		lblOpenLecture.setBounds(29, 48, 123, 15);
		add(lblOpenLecture);
		
		openLectureModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		openLectureTable = new JTable(openLectureModel);		
		
		
		JScrollPane scrollpaneOpenLecture = new JScrollPane(openLectureTable);
		scrollpaneOpenLecture.setBounds(29, 73, 644, 173);
		add(scrollpaneOpenLecture);
		
		btnDetailInfo = new JButton("상세 정보 보기");
		btnDetailInfo.setBounds(403, 256, 127, 23);
		add(btnDetailInfo);
		
		btnLectureApply = new JButton("수강 신청 하기");
		btnLectureApply.setBounds(542, 256, 131, 23);
		add(btnLectureApply);
		
		JLabel lblMyLecture = new JLabel("수강 신청 내역");
		lblMyLecture.setBounds(29, 292, 99, 15);
		add(lblMyLecture);
		
		appliedLectureModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		appliedLectureTable = new JTable(appliedLectureModel);
		
		JScrollPane scrollpaneMyLecture = new JScrollPane(appliedLectureTable);
		scrollpaneMyLecture.setBounds(29, 317, 644, 160);
		add(scrollpaneMyLecture);

		btnApplyCancel = new JButton("수강 취소 하기");
		btnApplyCancel.setBounds(542, 487, 131, 23);
		add(btnApplyCancel);
		
		btnGrade = new JButton("성적 조회");
		btnGrade.setBounds(0, 0, 100, 30);
		add(btnGrade);
		
	}
	
	public void addListener(MouseListener listener)
	{
		btnLectureApply.addMouseListener(listener);
		btnGrade.addMouseListener(listener);
		btnDetailInfo.addMouseListener(listener);
		btnApplyCancel.addMouseListener(listener);
	}


	public JButton getBtnGrade() {
		return btnGrade;
	}

	public JButton getBtnDetailInfo() {
		return btnDetailInfo;
	}

	public JButton getBtnLectureApply() {
		return btnLectureApply;
	}

	public JButton getBtnApplyCancel() {
		return btnApplyCancel;
	}

	public JTable getOpenLectureTable() {
		return openLectureTable;
	}


	public DefaultTableModel getOpenLectureModel() {
		return openLectureModel;
	}


	public void setOpenLectureModel(DefaultTableModel openLectureModel) {
		this.openLectureModel = openLectureModel;
	}


	public void setOpenLectureTable(JTable openLectureTable) {
		this.openLectureTable = openLectureTable;
	}

	
	public DefaultTableModel getAppliedLectureModel() {
		return appliedLectureModel;
	}

	public void setAppliedLectureModel(DefaultTableModel appliedLectureModel) {
		this.appliedLectureModel = appliedLectureModel;
	}

	public JTable getAppliedLectureTable() {
		return appliedLectureTable;
	}

	public void setAppliedLectureTable(JTable appliedLectureTable) {
		this.appliedLectureTable = appliedLectureTable;
	}

	
}
