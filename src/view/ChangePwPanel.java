package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseListener;
import javax.swing.JButton;


// 비밀번호 변경 페이지 뷰
@SuppressWarnings("serial")
public class ChangePwPanel extends JPanel 
{
	private JPasswordField passwordFieldNow;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldNewConfirm;
	private JButton btnChange;
	
	/**
	 * Create the panel.
	 */
	
	public ChangePwPanel() 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("비밀번호 변경");
		lblNewLabel.setBounds(312, 10, 85, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("현재 비밀번호     : ");
		lblNewLabel_1.setBounds(233, 160, 110, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("새 비밀번호        :");
		lblNewLabel_2.setBounds(233, 201, 110, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("새 비밀번호 확인 :");
		lblNewLabel_3.setBounds(233, 242, 110, 15);
		add(lblNewLabel_3);
		
		passwordFieldNow = new JPasswordField();
		passwordFieldNow.setBounds(348, 157, 117, 21);
		add(passwordFieldNow);
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setBounds(348, 198, 117, 21);
		add(passwordFieldNew);
		
		passwordFieldNewConfirm = new JPasswordField();
		passwordFieldNewConfirm.setBounds(348, 239, 117, 21);
		add(passwordFieldNewConfirm);
		
		btnChange = new JButton("변경하기");
		btnChange.setBounds(300, 318, 97, 23);
		add(btnChange);
		
	}
	
	public void addListener(MouseListener listener)
	{
		btnChange.addMouseListener(listener);		
	}

	public JPasswordField getPasswordFieldNow() {
		return passwordFieldNow;
	}

	public JPasswordField getPasswordFieldNew() {
		return passwordFieldNew;
	}

	public JPasswordField getPasswordFieldNewConfirm() {
		return passwordFieldNewConfirm;
	}

	public JButton getBtnChange() {
		return btnChange;
	}
	
	
}
