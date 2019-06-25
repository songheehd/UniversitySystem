package controller.personnelManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import controller.Controller;
import controller.PersonnelManagementController;
import model.PersonnelManager;
import model.Student;
import view.personnelManagement.AddEditPanel;


public class AddEditController extends Controller 
{	
	PersonnelManager pm;
	
	AddEditPanel view;
	Container contentPane;
	CardLayout cards;
	
	PersonnelManagementController pmController;
	
	Boolean isAdd;
	Boolean isStud;
	
	public AddEditController(PersonnelManager pm, 
			AddEditPanel addEditPanel, PersonnelManagementController controller)
	{		
		pmController = controller;
		//pm = pmController.getPm();
		this.pm = pm;
		view = addEditPanel;
		
		contentPane = pmController.getPmContentPane();
		cards = pmController.getPmCards();
		
		isAdd = true;
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener());					
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public AddEditPanel getView() 
	{
		return view;
	}
	
	
	
	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}



	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		PersonnelManager pm = pmController.getPm();
				
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			// 등록하기 버튼 클릭 시
			if(e.getSource().equals(view.getBtnAdd()))
			{
				if(isAdd)
				{
					// 추가시
					// 텍스트 필드에 입력된 정보로 학생 객체 생성
					Student student = new Student(
							view.getTextFieldId().getText(),
							view.getTextFieldName().getText(),
							view.getTextFieldJumin().getText(),
							view.getComboBoxDept().getSelectedItem().toString());
					
					// 만들어진 학생 객체를 데이터베이스에 등록
					if(pm.addStudentProfessor(student, isStud))
					{
						// 등록 성공 시					
						// 메세지 출력
						JOptionPane.showMessageDialog(null, "등록 완료", "UIS",
								JOptionPane.INFORMATION_MESSAGE);
						
						// 텍스트필드 초기화
						view.getTextFieldName().setText("");
						view.getTextFieldId().setText("");
						view.getComboBoxDept().setSelectedIndex(0);
						view.getTextFieldJumin().setText("");
					}
					else
					{
						// 등록 실패 시
						// 메세지 출력
						JOptionPane.showMessageDialog(null, "등록 실패", "UIS",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else
				{
					// 수정시
					// 텍스트 필드에 입력된 정보로 학생 객체 생성
					Student student = new Student(
							view.getTextFieldId().getText(),
							view.getTextFieldName().getText(),
							view.getTextFieldJumin().getText(),
							view.getComboBoxDept().getSelectedItem().toString());
					
					
					if(pm.editStudent(student, isStud))
					{
						// 수정 성공 시					
						// 메세지 출력
						JOptionPane.showMessageDialog(null, "수정 완료", "UIS",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						// 수정 실패 시
						// 메세지 출력
						JOptionPane.showMessageDialog(null, "수정 실패", "UIS",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
			
			// 재입력 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnReset()))
			{
				view.getTextFieldName().setText("");
				view.getTextFieldId().setText("");
				view.getComboBoxDept().setSelectedIndex(0);
				view.getTextFieldJumin().setText("");
			}
			
			// 뒤로가기 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnBack()))
			{
				pmController.getAddEditController().init();
				cards.show(contentPane, "search");
			}
			
			else if(e.getSource().equals(view.getRdbtnProfessor()))
			{
				isStud = false;
			}
			else if(e.getSource().equals(view.getRdbtnStudent()))
			{
				isStud = true;
			}
		}
	}
}
