package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.User;
import view.TopPanel;


public class TopController extends Controller 
{	
	User user;
	
	TopPanel view;
	Container contentPane;
	CardLayout cards;
	
	public TopController(User user, TopPanel topPanel)
	{		
		this.user = user;
		view = topPanel;		
		
		view.addListener(new MListener());
	} 
	
	public void setLayout(JPanel contentPane, CardLayout cards)
	{
		this.contentPane = contentPane;
		this.cards = cards;
	}
	
	// 로그인한 사용자 정보 표시 갱신
	public void refresh()
	{
		view.getLblId().setText(user.getId());
		view.getLblName().setText(user.getName());		
	}
	
	public TopPanel getView() 
	{
		return view;
	}
	
	public void setCards(CardLayout cards) 
	{
		this.cards = cards;
	}

	public void setContentPane(Container contentPane) 
	{
		this.contentPane = contentPane;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			// 메인 메뉴 버튼 클릭 시
			if(e.getSource().equals(view.getBtnHome()))
			{
				// 메인 메뉴 패널로 이동
				cards.show(contentPane, "main menu");	
			}
			
			// 로그 아웃 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnLogout()))
			{
				user.logout();	
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다!", "Logout",
						JOptionPane.INFORMATION_MESSAGE);
				// 로그인 패널에서 안보이게
				view.setVisible(false);				
				// 로그인 패널로 이동
				cards.show(contentPane, "login");
			}
			
		}
	}
}
