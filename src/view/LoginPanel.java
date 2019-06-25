package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import model.User;

// 로그인 페이지
@SuppressWarnings("serial")
public class LoginPanel extends JPanel 
{
	User user;
	JTextField textFieldId;
	JPasswordField passwordFieldPw;	
	JButton btnLogin;
	private JLabel titleImage;
	
	/**
	 * Create the panel.
	 */

	public LoginPanel() 
	{
		setLayout(null);
		
		JLabel lbId = new JLabel("아이디 : ");
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbId.setBounds(242, 264, 77, 15);
		add(lbId);

		JLabel lbPw = new JLabel("비밀번호 : ");
		lbPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPw.setBounds(242, 299, 77, 15);
		add(lbPw);

		textFieldId = new JTextField();
		textFieldId.setBounds(328, 261, 116, 21);
		add(textFieldId);
		textFieldId.setColumns(10);

		passwordFieldPw = new JPasswordField();
		passwordFieldPw.setBounds(328, 296, 116, 21);
		add(passwordFieldPw);

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(303, 345, 97, 23);
		add(btnLogin);			
		
		ImageIcon ic = new ImageIcon("./img/deu.png");
		
		titleImage = new JLabel(ic);
		titleImage.setBounds(277, 86, 140, 140);
		add(titleImage);
	}
	
	// 이벤트 리스너 등록
	public void addListener(MouseListener mListener, KeyListener kListener)
	{
		// 로그인 버튼 클릭 시		
		btnLogin.addMouseListener(mListener);

		// 로그인 버튼 엔터 키
		btnLogin.addKeyListener(kListener); 
	}
	
	public User getUser() {
		return user;
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public JPasswordField getPasswordFieldPw() {
		return passwordFieldPw;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}


}
