package view;

import java.awt.CardLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

// 수강관리 페이지
@SuppressWarnings("serial")
public class CourseManagementPanel extends JPanel 
{
	
	
	JPanel comContentPane;
	CardLayout comCards;
	
	/**
	 * Create the panel.
	 */
	
	public CourseManagementPanel() 
	{				
		setLayout(null);
		
		// 수강관리패널에서 사용할 카드 레이아웃과 패널 생성
				 			 
		comContentPane = new JPanel(); 
		comCards = new CardLayout();	
		
		comContentPane.setBounds(0, 0, 700, 550);
		comContentPane.setLayout(comCards);
		add(comContentPane);
						
	}

	public void addListener(MouseListener listener)
	{
		
	}

	public JPanel getComContentPane() {
		return comContentPane;
	}

	public CardLayout getComCards() {
		return comCards;
	}
	
	
}
