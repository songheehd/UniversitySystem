package view.classManagement;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ManageClassPanel extends JPanel 
{
	
	/**
	 * Create the panel.
	 * View/- GUI를 나타내기만 할 뿐(선언만 해라)
	 */
	DefaultTableModel Model;
	JTable tableLecture;
	String[][] contents;
	JButton btnDetailInfo;
	JButton btnApplyCancel;
	private JTextField textname;
	private JTextField textMajor;
	private JTextField textProc;
	private JTextField textMax;
	private JTextField textMin;
	private JTextField textScore;
	private JTextField textExplain;
	private JTextField textFieldNum;
	
	public  ManageClassPanel() 
	{
					
	
	setLayout(null);
//제목
	JLabel lblTitle = new JLabel("강좌 관리");
	lblTitle.setBounds(327, 10, 83, 15);
	add(lblTitle);
	
	JLabel lblLecture = new JLabel("개설되지 않은 강의");
	lblLecture.setBounds(29, 27, 123, 15);
	add(lblLecture);

	String[] header = {"강좌 번호", "강좌 이름", "학과", "교수 번호", "최대 수강 인원", "현재 수강 인원",
			"학점","강좌설명","학기","개설여부"};
	//10개
	
	
	Model = new DefaultTableModel(contents,header);
	tableLecture = new JTable(Model);		
	
	JScrollPane scrollpaneLecture = new JScrollPane(tableLecture);
	scrollpaneLecture.setBounds(29, 52, 644, 257);
	add(scrollpaneLecture);
	
	btnDetailInfo = new JButton("정보 번경");
	btnDetailInfo.setBounds(402, 451, 127, 23);
	add(btnDetailInfo);
	
	
	btnApplyCancel = new JButton("강좌 삭제");
	btnApplyCancel.setBounds(542, 451, 131, 23);
	add(btnApplyCancel);
	
	JLabel lblName = new JLabel("강좌 이름");
	lblName.setBounds(29, 322, 62, 18);
	add(lblName);
	
	textname = new JTextField();
	textname.setBounds(102, 321, 116, 24);
	add(textname);
	textname.setColumns(10);
	
	
	JLabel lblMajor = new JLabel("담당 학과");
	lblMajor.setBounds(29, 360, 62, 18);
	add(lblMajor);
	
	textMajor = new JTextField();
	textMajor.setBounds(102, 357, 116, 24);
	add(textMajor);
	textMajor.setColumns(10);
	
	JLabel lblProc = new JLabel("교수 번호");
	lblProc.setBounds(29, 398, 62, 18);
	add(lblProc);
	
	textProc = new JTextField();
	textProc.setBounds(102, 395, 116, 24);
	add(textProc);
	textProc.setColumns(10);
	
	JLabel lblMax = new JLabel("최대 수강 인원");
	lblMax.setBounds(232, 322, 94, 18);
	
	add(lblMax);
	textMax = new JTextField();
	textMax.setBounds(336, 321, 116, 24);
	add(textMax);
	textMax.setColumns(10);
	
	
	JLabel lblMin = new JLabel("최소 수강 인원");
	lblMin.setBounds(232, 360, 94, 18);
	add(lblMin);
	
	textMin = new JTextField();
	textMin.setBounds(336, 357, 116, 24);
	add(textMin);
	textMin.setColumns(10);
	
	
	JLabel lblNewLabel_2 = new JLabel("학점 수");
	lblNewLabel_2.setBounds(242, 398, 62, 18);
	add(lblNewLabel_2);
	

	textScore = new JTextField();
	textScore.setBounds(336, 395, 116, 24);
	add(textScore);
	textScore.setColumns(10);
	
	JLabel lblExplain = new JLabel("강좌설명");
	lblExplain.setBounds(467, 322, 62, 18);
	add(lblExplain);
	
	textExplain  = new JTextField();
	textExplain.setText("");
	textExplain.setBounds(542, 321, 127, 63);
	add(textExplain );
	textExplain.setColumns(10);
	
	JLabel lblNum = new JLabel("강좌번호");
	lblNum.setBounds(467, 398, 62, 18);
	add(lblNum);
	
	textFieldNum = new JTextField();
	textFieldNum.setEditable(false);
	textFieldNum.setText("");
	textFieldNum.setBounds(542, 395, 131, 24);
	add(textFieldNum);
	textFieldNum.setColumns(10);
		
	
	
	}
	
	// 이벤트 리스너 등록
	public void addListener(MouseListener listener)
	{
		tableLecture.addMouseListener(listener);
		btnDetailInfo.addMouseListener(listener);
		btnApplyCancel.addMouseListener(listener);
		
	}
	
	public DefaultTableModel getModel() {
		
		return Model;
	}

	public void setModel(DefaultTableModel Model) {
		this.Model = Model;
	}

	public JTable getTableLecture() {
		return tableLecture;
	}

	public void setTableLecture(JTable tableLecture) {
		this.tableLecture = tableLecture;
	}

	public JButton getBtnDetailInfo() {
		return btnDetailInfo;
	}

	public void setBtnDetailInfo(JButton btnDetailInfo) {
		this.btnDetailInfo = btnDetailInfo;
	}

	public JButton getBtnApplyCancel() {
		return btnApplyCancel;
	}

	public void setBtnApplyCancel(JButton btnApplyCancel) {
		this.btnApplyCancel = btnApplyCancel;
	}

	public JTextField getTextname() {
		return textname;
	}

	public void setTextname(JTextField textname) {
		this.textname = textname;
	}

	public JTextField getTextMajor() {
		return textMajor;
	}

	public void setTextMajor(JTextField textMajor) {
		this.textMajor = textMajor;
	}

	public JTextField getTextProc() {
		return textProc;
	}

	public void setTextProc(JTextField textProc) {
		this.textProc = textProc;
	}

	public JTextField getTextMax() {
		return textMax;
	}

	public void setTextMax(JTextField textMax) {
		this.textMax = textMax;
	}

	public JTextField getTextMin() {
		return textMin;
	}

	public void setTextMin(JTextField textMin) {
		this.textMin = textMin;
	}

	public JTextField getTextScore() {
		return textScore;
	}

	public void setTextScore(JTextField textScore) {
		this.textScore = textScore;
	}

	public JTextField getTextExplain() {
		return textExplain;
	}

	public void setTextExplain(JTextField textExplain) {
		this.textExplain = textExplain;
	}

	public JTextField getTextFieldNum() {
		return textFieldNum;
	}

	public void setTextFieldNum(JTextField textFieldNum) {
		this.textFieldNum = textFieldNum;
	}

	public void managerListener()
	{
		
	}
}
