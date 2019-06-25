package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.personnelManagement.AddEditController;
import controller.personnelManagement.SearchController;
import model.PersonnelManager;
import model.User;
import view.PersonnelManagementPanel;

public class PersonnelManagementController extends Controller 
{
	ArrayList<Controller> controllers;

	PersonnelManager pm;
	
	PersonnelManagementPanel view;	
	JPanel pmContentPane;	
	CardLayout pmCards;		
	
	public PersonnelManagementController(PersonnelManager pm, 
			PersonnelManagementPanel pmPanel, ArrayList<Controller> controllers)
	{	
		this.controllers = controllers;
		this.pm = pm;	
		view = pmPanel;
		
		// 학사 관리 카드레이아웃을 가져옴
		pmContentPane = view.getPmContentPane();
		pmCards = view.getPmCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록		
		view.addListener(new MListener());		
	}
		
	// 카드레이아웃패널에 뷰를 등록
	public void addContentPaneView(JPanel view, String alias)
	{
		pmContentPane.add(view, alias);
	}
	
	
	public PersonnelManagementPanel getView()
	{
		return view;
	}
	
	public void setControllers(ArrayList<Controller> controllers) 
	{
		this.controllers = controllers;
	}
	
	@Override
	public void setUser(User user)
	{
		pm = new PersonnelManager(user);
	}
	
	public Container getPmContentPane() {
		return pmContentPane;
	}

	public CardLayout getPmCards() {
		return pmCards;
	}

	public PersonnelManager getPm() {
		return pm;
	}

	public AddEditController getAddEditController() 
	{
		return (AddEditController) controllers.get(0);
		
	}

	public SearchController getSearchController()
	{
		return (SearchController) controllers.get(1);
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
		}	
	}
}
