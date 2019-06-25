package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.classManagement.ManageClassController;
import model.ClassManager;
import model.User;
import view.ClassManagementPanel;

public class ClassManagementController extends Controller 
{
	 ArrayList<Controller> controllers;

	ClassManager cm;
	
	ClassManagementPanel view;
	JPanel clmContentPane;
	CardLayout clmCards;
	ManageClassController m_view;
	
	public ClassManagementController(ClassManager cm, 
			ClassManagementPanel clmPanel, ArrayList<Controller> controllers)
	{
		this.controllers = controllers;		
		this.cm = cm;
		view = clmPanel;
		
		// 수업 관리 카드레이아웃을 가져옴
		clmContentPane = view.getClmContentPane();
		clmCards = view.getClmCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new AListener());
	}
	
	// 카드레이아웃패널에 뷰를 등록
	public void addContentPaneView(JPanel view, String alias)
	{
		clmContentPane.add(view, alias);
	}

	// 하위 컨트롤러 리스트 받아오기
	public void setControllers(ArrayList<Controller> controllers) 
	{
		this.controllers = controllers;
	}
	
	
	public ClassManagementPanel getView()
	{
		return view;
	}
	
	public ClassManager getCm() {
		return cm;
	}

	@Override
	public void setUser(User user)
	{
		cm = new ClassManager(user);
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class AListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// 강좌  등록 메뉴 클릭시 ( 액션 리스너 사용 )
			if(e.getSource().equals(view.getClassMenuItemAdd()))
			{
				controllers.get(0).init();
				clmCards.show(clmContentPane, "add class");
				
			}
			
			// 강좌 개설 메뉴 클릭시 ( 액션 리스너 사용 )
			else if(e.getSource().equals(view.getClassMenuItemOpen()))
			{
				controllers.get(1).init();
				clmCards.show(clmContentPane, "open class");
			}
			
			// 강좌 관리 메뉴 클릭시 ( 액션 리스너 사용 )
			else if(e.getSource().equals(view.getClassMenuItemManage()))
			{
			
				controllers.get(2).init();
				clmCards.show(clmContentPane, "manage class");
				
			}
		}	
	}
}
