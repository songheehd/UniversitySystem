package controller.courseManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import controller.Controller;
import controller.CourseManagementController;
import model.ClassManager;
import view.courseManagement.ClassManagerTuitionPanel;



public class ClassManagerTuitionController extends Controller 
{
	CourseManagementController comController;
	
	ClassManager cm;
	
	ClassManagerTuitionPanel view;
	Container contentPane;
	CardLayout cards;
	
	public ClassManagerTuitionController(ClassManager cm, 
			ClassManagerTuitionPanel view, CourseManagementController controller)
	{
		comController = controller;
		this.cm = cm;
		this.view = view;
		
		// 강좌 관리 컨트롤러에서 카트레이아웃과 패널을 가져옴
		contentPane = comController.getComContentPane();
		cards = comController.getComCards();

		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		this.view.addListener(new MListener());
	}
	
	
	@Override
	public void init() 
	{
		cm = (ClassManager) comController.getUser();
		
		view.getBillModel().setRowCount(0);
	}


	@Override
	public JPanel getView() 
	{
		return view;
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// 조회 버튼 클릭 시
			if(e.getSource().equals(view.getBtnSearch()))
			{				
				
						
				
			}
			
			// 발급 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnPrint()))
			{
				
			}
		}
	}
}
