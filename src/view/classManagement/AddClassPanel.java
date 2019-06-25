package view.classManagement;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddClassPanel extends JPanel  
{
	JTextField textFieldNumber;
	JTextField textFieldName;
	JTextField textFieldMajor;
	JTextField textFieldScore;
	JTextField textFieldExplain;

	JButton btnAdd;
	
	/**
	 * Create the panel.
	 */
	
	public AddClassPanel() 
	{
		setLayout(null);
		
		btnAdd = new JButton("등록하기");		
		btnAdd.setBounds(289, 405, 97, 23);
		add(btnAdd);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(324, 85, 116, 21);
		add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(324, 135, 116, 21);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldMajor = new JTextField();
		textFieldMajor.setBounds(324, 186, 116, 21);
		add(textFieldMajor);
		textFieldMajor.setColumns(10);
		
		textFieldScore = new JTextField();
		textFieldScore.setBounds(324, 237, 116, 21);
		add(textFieldScore);
		textFieldScore.setColumns(10);
		
		textFieldExplain = new JTextField();
		textFieldExplain.setBounds(324, 287, 218, 78);
		add(textFieldExplain);
		textFieldExplain.setColumns(10);
		
		
		JLabel lblId = new JLabel("강좌번호");
		lblId.setBounds(209, 89, 57, 15);
		add(lblId);
		
		JLabel lblName = new JLabel("강좌이름");
		lblName.setBounds(209, 139, 57, 15);
		add(lblName);
		
		JLabel lblMajor = new JLabel("담당학과");
		lblMajor.setBounds(209, 186, 57, 15);
		add(lblMajor);
		
		JLabel lblScore = new JLabel("학점수");
		lblScore.setBounds(209, 241, 57, 15);
		add(lblScore);
		
		JLabel lblExplain = new JLabel("강좌설명");
		lblExplain.setBounds(209, 287, 57, 15);
		add(lblExplain);

	}
	
	// 이벤트 리스너 등록
	public void addListener(MouseListener listener)
	{
		btnAdd.addMouseListener(listener);
	}

	
	
	public JTextField getTextFieldNumber() {
		return textFieldNumber;
	}

	public void setTextFieldNumber(JTextField textFieldNumber) {
		this.textFieldNumber = textFieldNumber;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldMajor() {
		return textFieldMajor;
	}

	public void setTextFieldMajor(JTextField textFieldMajor) {
		this.textFieldMajor = textFieldMajor;
	}

	public JTextField getTextFieldScore() {
		return textFieldScore;
	}

	public void setTextFieldScore(JTextField textFieldScore) {
		this.textFieldScore = textFieldScore;
	}

	public JTextField getTextFieldExplain() {
		return textFieldExplain;
	}

	public void setTextFieldExplain(JTextField textFieldExplain) {
		this.textFieldExplain = textFieldExplain;
	}
	
	
}
