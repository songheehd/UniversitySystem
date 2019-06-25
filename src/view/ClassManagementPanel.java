package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ClassManagementPanel extends JPanel 
{
	JMenuBar menuBar;
	JMenu classMenu;
	JMenuItem classMenuItemAdd;
	JMenuItem classMenuItemOpen;
	JMenuItem classMenuItemManage;
	
	// 수강관리패널에서 사용할 카드 레이아웃과 패널
	JPanel clmContentPane;
	CardLayout clmCards;
	 
	/**
	 * Create the panel.
	 */
	
	public ClassManagementPanel() 
	{	
		setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 700, 30);
		add(menuBar);
		
		classMenu = new JMenu("   수업관리   ");
		menuBar.add(classMenu);
		
		classMenuItemAdd = new JMenuItem("강좌 등록");				
		classMenu.add(classMenuItemAdd);
		
		classMenuItemOpen = new JMenuItem("강좌 개설");
		classMenu.add(classMenuItemOpen);
		
		classMenuItemManage = new JMenuItem("강좌 관리");
		classMenu.add(classMenuItemManage);
		
		clmContentPane = new JPanel();
		clmCards = new CardLayout();
		
		clmContentPane.setBounds(0, 30, 700, 540);
		clmContentPane.setLayout(clmCards);
		add(clmContentPane);
		
	}
	
	public void addListener(ActionListener listener)
	{
		classMenuItemAdd.addActionListener(listener); 
		classMenuItemOpen.addActionListener(listener);
		classMenuItemManage.addActionListener(listener);
	}


	public JPanel getClmContentPane() {
		return clmContentPane;
	}

	public CardLayout getClmCards() {
		return clmCards;
	}

	public JMenuItem getClassMenuItemAdd() {
		return classMenuItemAdd;
	}

	public JMenuItem getClassMenuItemOpen() {
		return classMenuItemOpen;
	}

	public JMenuItem getClassMenuItemManage() {
		return classMenuItemManage;
	}
	
	
}


	