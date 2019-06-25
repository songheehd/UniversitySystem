package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class TopPanel extends JPanel 
{
	JLabel lblId;
	JLabel lblName;
	JButton btnHome;
	JButton btnLogout;
	
	/**
	 * Create the panel.
	 */
	
	public TopPanel() 
	{	
		this.setBounds(0, 0, 700, 30);
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		lblId = new JLabel("");
		lblId.setBounds(12, 5, 57, 15);
		add(lblId);
		
		lblName = new JLabel("");
		lblName.setBounds(81, 5, 57, 15);
		add(lblName);
		
		btnHome = new JButton("메인메뉴");		
		btnHome.setBounds(451, 4, 97, 23);
		add(btnHome);
		
		btnLogout = new JButton("로그아웃");		
		btnLogout.setBounds(569, 4, 97, 23);
		add(btnLogout);
	}  

	// 이벤트 리스너 등록
	public void addListener(MouseListener mListener)
	{
		// 메인메뉴 버튼 클릭 시	
		btnHome.addMouseListener(mListener);

		// 로그아웃 버튼 클릭 시
		btnLogout.addMouseListener(mListener); 
	}
	
	public JLabel getLblId() {
		return lblId;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	
}
