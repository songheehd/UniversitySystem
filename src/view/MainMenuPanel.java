package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseListener;


// 메인 메뉴 페이지
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel 
{
	JButton btnPersonnelMng;
	JButton btnClassMng;
	JButton btnCourseMng;
	JButton btnChangePw;
	
	/**
	 * Create the panel.
	 */
	
	public MainMenuPanel() 
	{
		setLayout(null);	
		
		btnPersonnelMng = new JButton("학사 관리");
		btnPersonnelMng.setBounds(288, 179, 123, 23);
		add(btnPersonnelMng);
		
		btnClassMng = new JButton("수업 관리");		
		btnClassMng.setBounds(288, 228, 123, 23);
		add(btnClassMng);
		
		btnCourseMng = new JButton("수강 관리");
		btnCourseMng.setBounds(288, 278, 123, 23);
		add(btnCourseMng);
		
		btnChangePw = new JButton("비밀번호 변경");		
		btnChangePw.setBounds(288, 327, 123, 23);
		add(btnChangePw);				
	}
	
	public void addListener(MouseListener listener)
	{
		btnPersonnelMng.addMouseListener(listener);
		btnClassMng.addMouseListener(listener);
		btnCourseMng.addMouseListener(listener);
		btnChangePw.addMouseListener(listener);
	}
	
	public JButton getBtnPersonnelMng() {
		return btnPersonnelMng;
	}

	public JButton getBtnClassMng() {
		return btnClassMng;
	}

	public JButton getBtnCourseMng() {
		return btnCourseMng;
	}

	public JButton getBtnChangePw() {
		return btnChangePw;
	}
	
	
	
}
