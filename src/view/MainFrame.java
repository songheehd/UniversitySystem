package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 메인 프레임

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	JFrame frame;
	TopPanel topPanel;
	JPanel contentPane;
	CardLayout cards;
	
	
	/**
	 * Create the frame.
	 */
	
	public MainFrame(TopPanel top) 
	{
		frame = new JFrame("UIS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setBounds(700, 300, 700, 600);
		frame.getContentPane().setLayout(null);
		
		topPanel = top;
		topPanel.setBounds(0, 0, 700, 30);
		frame.getContentPane().add(topPanel);
		
		contentPane = new JPanel();		
		cards = new CardLayout();
		
		contentPane.setBounds(0, 30, 700, 570);
		contentPane.setLayout(cards);
		frame.getContentPane().add(contentPane);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public TopPanel getTopPanel()
	{
		return topPanel;
	}
	
	public void setTopPanel(TopPanel topPanel)
	{
		this.topPanel = topPanel;
		this.topPanel.revalidate();
	}

	public JPanel getContentPane() 
	{
		return contentPane;
	}


	public CardLayout getCards() 
	{
		return cards;
	}
			
}
