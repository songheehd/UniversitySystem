package view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class PersonnelManagementPanel extends JPanel 
{
	JPanel pmContentPane;
	CardLayout pmCards;

	/**
	 * Create the panel.
	 */
	public PersonnelManagementPanel() 
	{

		setLayout(null);

		// 학사관리패널에서 사용할 카드 레이아웃과 패널 생성
		pmContentPane = new JPanel();
		pmCards = new CardLayout();

		pmContentPane.setBounds(0, 30, 700, 540);
		pmContentPane.setLayout(pmCards);
		add(pmContentPane);

	}

	public void addListener(ActionListener listener) 
	{

	}

	public JPanel getPmContentPane() {
		return pmContentPane;
	}

	public CardLayout getPmCards() {
		return pmCards;
	}

}




