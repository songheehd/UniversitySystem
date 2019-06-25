package controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.ClassManager;
import model.Professor;
import model.Student;
import model.User;
import view.CourseManagementPanel;

public class CourseManagementController extends Controller
{
	ArrayList<Controller> controllers;
	
	User user;
	Student student;
	Professor professor;
	ClassManager cm;
	
	CourseManagementPanel view;	
	JPanel comContentPane;
	CardLayout comCards;
	
	public CourseManagementController(User user, 
			CourseManagementPanel comPanel, ArrayList<Controller> controllers)
	{				
		this.controllers = controllers;
		this.user = user;
		view = comPanel;
		
		// 강좌 관리 카드레이아웃을 가져옴
		comContentPane = view.getComContentPane();
		comCards = view.getComCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록		
		view.addListener(new MListener());
	}
	
	// 카드레이아웃패널에 뷰를 등록
	public void addContentPaneView(JPanel view, String alias)
	{
		comContentPane.add(view, alias);
	}
	
	// 하위 컨트롤러 리스트 받아오기
	public void setControllers(ArrayList<Controller> controllers) 
	{
		this.controllers = controllers;
	}
	
	// 받아온 사용자 타입에따라 보여줄 카드 지정
	public void setUserAndCard(User user) 
	{	
		this.user = user;
		
		// 사용자 타입 받음
		if(user instanceof Student)
		{
			student  = (Student) user;
			
			User u = (User)student;
			
			System.out.println(u.getId());
			
			// 초기화
			controllers.get(0).init();
			controllers.get(1).init();
			comCards.show(comContentPane, "student course apply");			
			
		}			
		else if(user instanceof Professor)
		{
			professor = (Professor) user;
			
			// 초기화
			controllers.get(2).init();
			controllers.get(3).init();
			comCards.show(comContentPane, "professor lecture management");
		}			
		else if(user instanceof ClassManager)
		{
			cm = (ClassManager) user;
			
			// 초기화
			controllers.get(4).init();
			
			comCards.show(comContentPane, "class manager tuition");
		}
			
	}
	
	public CourseManagementPanel getView()
	{
		return view;
	}
	
	public User getUser()
	{
		if(user instanceof Student)		
			return student;		
		else if(user instanceof Professor)		
			return professor;		
		else if(user instanceof ClassManager)		
			return cm;		
		else
			return user;		
	}
	

	
	public JPanel getComContentPane() {
		return comContentPane;
	}

	public CardLayout getComCards() {
		return comCards;
	}




	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			
		}	
	}
}
