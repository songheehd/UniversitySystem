package view.classManagement;

import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OpenClassPanel extends JPanel  
{
	DefaultTableModel Model;
	JTable tableLecture;
	String[][] contents;
	JButton btnOpen;
	JButton btnUnOpen;
	private JTextField textproc;
	private JTextField textmax;
	private JTextField textmin;
	private JLabel lblNewLabel_2;
	private JTextField textLecno;
	
	public OpenClassPanel() 
	{
		setLayout(null);
		
		
		String[] header = {"강좌 번호", "강좌 이름", "학과", "교수 번호", "최대 수강 인원", "현재 수강 인원",
				"학점","강좌설명","학기","개설여부"};
		Model = new DefaultTableModel(contents,header);
		tableLecture = new JTable(Model);		
		
		JScrollPane scrollPane = new JScrollPane(tableLecture);
		scrollPane.setBounds(51, 88, 593, 193);
		add(scrollPane);
		
		
		 btnOpen = new JButton("개설하기");
		 btnOpen.setBounds(417, 397, 105, 27);
		add(btnOpen);
		
		 btnUnOpen = new JButton("개설 취소");
		 btnUnOpen.setBounds(539, 397, 105, 27);
		add(btnUnOpen);
		
		JLabel label = new JLabel("담당교수");
		label.setBounds(51, 341, 62, 18);
		add(label);
		
		textproc = new JTextField();
		textproc.setBounds(164, 338, 116, 24);
		add(textproc);
		textproc.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("최대 수강인원");
		lblNewLabel.setBounds(51, 371, 89, 18);
		add(lblNewLabel);
		
		textmax = new JTextField();
		textmax.setBounds(164, 368, 116, 24);
		add(textmax);
		textmax.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("최소 수강인원");
		lblNewLabel_1.setBounds(51, 401, 89, 18);
		add(lblNewLabel_1);
		
		textmin = new JTextField();
		textmin.setBounds(164, 400, 116, 24);
		add(textmin);
		textmin.setColumns(10);
		
		lblNewLabel_2 = new JLabel("강좌번호");
		lblNewLabel_2.setBounds(51, 307, 62, 18);
		add(lblNewLabel_2);
		
		textLecno = new JTextField();
		textLecno.setText("");
		textLecno.setBounds(164, 304, 116, 24);
		add(textLecno);
		textLecno.setColumns(10);
		
	}
	
	
	// 이벤트 리스너 등록
	public void addListener(MouseListener listener)
	{
		tableLecture.addMouseListener(listener);
		btnOpen.addMouseListener(listener);
		btnUnOpen.addMouseListener(listener);
		
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

	public JButton getBtnOpen() {
		return btnOpen;
	}

	public void setBtnOpen(JButton btnOpen) {
		this.btnOpen = btnOpen;
	}

	public JButton getBtnUnOpen() {
		return btnUnOpen;
	}

	public void setBtnUnOpen(JButton btnUnOpen) {
		this.btnUnOpen = btnUnOpen;
	}


	public JTextField getTextproc() {
		return textproc;
	}


	public void setTextproc(JTextField textproc) {
		this.textproc = textproc;
	}


	public JTextField getTextmax() {
		return textmax;
	}


	public void setTextmax(JTextField textmax) {
		this.textmax = textmax;
	}


	public JTextField getTextmin() {
		return textmin;
	}


	public void setTextmin(JTextField textmin) {
		this.textmin = textmin;
	}


	public JTextField getTextLecno() {
		return textLecno;
	}


	public void setTextLecno(JTextField textLecno) {
		this.textLecno = textLecno;
	}
	
	
}