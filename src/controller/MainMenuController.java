package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.ClassManager;
import model.PersonnelManager;
import model.User;
import view.MainMenuPanel;


public class MainMenuController extends Controller
{
	MainController mainController;	
	
	User user;
	
	MainMenuPanel view;
	Container contentPane;
	CardLayout cards;
	
	public MainMenuController(User user, MainMenuPanel mainMenuPanel, MainController controller) 
	{	
		this.user = user;
		view = mainMenuPanel;
		mainController = controller;
				
		// 메인 컨트롤러에서 카트레이아웃과 패널을 가져옴
		contentPane = mainController.getMainContentPane();
		cards = mainController.getMainCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener());	
	}
	
	public MainMenuPanel getView()
	{
		return view;
	}
	


	@Override
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
			// 학사 관리 버튼 클릭 시
			if(e.getSource().equals(view.getBtnPersonnelMng()))
			{
				// 학사관리자일 경우
				if(user instanceof PersonnelManager)						
				{				
					cards.show(contentPane, "personnel management");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "권한이 없습니다!", "No Permission",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
			// 수업 관리 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnClassMng()))
			{
				// 수업관리자일 경우
				if(user instanceof ClassManager)
				{
					cards.show(contentPane, "class management");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "권한이 없습니다!", "No Permission",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
			// 수강 관리 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnCourseMng()))
			{				
				if(user instanceof PersonnelManager)
				{
					// 학사 관리자 일경우
					JOptionPane.showMessageDialog(null, "권한이 없습니다!", "No Permission",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					// 유저 타입에 따라 
					mainController.getComController().setUserAndCard(user);
					
					// 그 외 모든 권한
					cards.show(contentPane, "course management");	
					
				}
				
				
			}
			
			// 비밀번호  변경 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnChangePw()))
			{
				cards.show(contentPane, "change password");
			}
		}
	}
}
