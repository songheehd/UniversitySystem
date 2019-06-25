package controller.classManagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import controller.ClassManagementController;
import controller.Controller;
import model.ClassManager;
import model.Lecture;
import view.classManagement.AddClassPanel;

public class AddClassController extends Controller 
{
	ClassManagementController clmController;
	
	ClassManager cm;
	
	AddClassPanel view;
	
	public AddClassController(ClassManager cm,
			AddClassPanel addClassPanel, ClassManagementController controller)
	{
		clmController = controller;
		this.cm = cm;
		view = addClassPanel;				
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener());					
	}

	public AddClassPanel getView() 
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
			// 입력한 정보를 바탕으로 등록할 강좌 객체를 생성
			Lecture lecture = new Lecture();	
			
			lecture.setLecno(view.getTextFieldNumber().getText());
			lecture.setName(view.getTextFieldName().getText());
			lecture.setDept(view.getTextFieldMajor().getText());
			lecture.setGrades(view.getTextFieldScore().getText());
			lecture.setExplain(view.getTextFieldExplain().getText());
			
			if(cm.addClass(lecture))
			{
				// 강좌 등록 성공 시
				JOptionPane.showMessageDialog(null, "등록 완료", "강좌 등록",
						JOptionPane.INFORMATION_MESSAGE);
				
				// 텍스트 필드 초기화
				view.getTextFieldNumber().setText("");
				view.getTextFieldName().setText("");
				view.getTextFieldMajor().setText("");
				view.getTextFieldScore().setText("");
				view.getTextFieldExplain().setText("");
				
			}
			else
			{
				// 강좌 등록 실패 시
				JOptionPane.showMessageDialog(null, "등록 도중 오류 발생!", "학생 동록",
						JOptionPane.ERROR_MESSAGE);
			}						
		}
	}
	
}
