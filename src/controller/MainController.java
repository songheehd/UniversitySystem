package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

import model.User;
import view.MainFrame;
import view.TopPanel;


public class MainController extends Controller
{
	// 컨트롤러
	ArrayList<Controller> controllers;

	// 데이터를 가지는 모델
	User user;				// 로그인한 유저 정보를 가짐
	
	// 화면을 구성하는 요소
	MainFrame frame;
	TopPanel topPanel;
	Container mainContentPane;	// view를 등록하는 컨테이너
	CardLayout mainCards;		// 컨테이너에 등록된 view들 중 하나를 선택하여 보여주는 레이아웃
	
	public MainController(User user, MainFrame frame, ArrayList<Controller> controllers)
	{						
		this.controllers = controllers;
		 
		this.user = user;
		this.frame = frame;
		this.topPanel = frame.getTopPanel();
		
		// 프레임의 카드레이아웃 정보를 가져옴
		mainContentPane = this.frame.getContentPane();
		mainCards = this.frame.getCards();
	}
	
	// GUI 프레임 시작 
	public void start() 
	{			
		frame.getTopPanel().setVisible(false);
		frame.getFrame().setVisible(true);	// 프레임 생성						
		
		mainCards.show(mainContentPane, "login");	// 첫 화면을 로그인 화면으로 설정	
	}
	
	// 카드레이아웃패널에 뷰를 등록
	public void addContentPaneView(JPanel view, String alias)
	{
		mainContentPane.add(view, alias);
	}
	
	// 컨트롤러 마다 사용자 정보 전달
	public void setUser(User user)
	{
		Iterator<Controller> i = controllers.iterator();
		
		while(i.hasNext())
		{			
			Controller controller = i.next();
			controller.setUser(user);
		}
		
	}
	
	public void setControllers(ArrayList<Controller> controllers) 
	{
		this.controllers = controllers;
	}
	
	public TopController getTopController() 
	{
		return (TopController) controllers.get(0);
		
	}

	public CourseManagementController getComController()
	{
		return (CourseManagementController) controllers.get(5);
	}
	
	public JPanel getTopPanel()
	{
		return frame.getTopPanel();
	}

	public Container getMainContentPane() {
		return mainContentPane;
	}

	public CardLayout getMainCards() {
		return mainCards;
	}

	public User getUser() {
		return user;
	}

	@Override
	public JPanel getView() {
		return null;
	}
	
	
	
}
