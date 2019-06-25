package controller.personnelManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

import controller.Controller;
import controller.PersonnelManagementController;
import main.Department;
import model.PersonnelManager;
import model.Student;
import view.personnelManagement.SearchPanel;

public class SearchController extends Controller 
{
	PersonnelManagementController pmController;
	
	PersonnelManager pm;
	
	SearchPanel view;
	Container contentPane;
	CardLayout cards;
	
	public SearchController(PersonnelManager pm, 
			SearchPanel searchPanel, PersonnelManagementController controller)
	{
		pmController = controller;
		this.pm = pm;
		view = searchPanel;
		
		contentPane = pmController.getPmContentPane();
		cards = pmController.getPmCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener());					
	}

	@Override
	public void init() 
	{
		view.getSearchStudentModel().setRowCount(0);
	}

	public JPanel getView() 
	{
		return view;
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		PersonnelManager pm = pmController.getPm();
		
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			// 추가 버튼 클릭 시
			if(e.getSource().equals(view.getBtnAdd()))
			{		
				pmController.getAddEditController().getView().getTextFieldId().setText("");
				pmController.getAddEditController().getView().getTextFieldName().setText("");
				pmController.getAddEditController().getView().getComboBoxDept().setSelectedIndex(0);
				pmController.getAddEditController().getView().getTextFieldJumin().setText("");
				
				pmController.getAddEditController().getView().getTextFieldId().setEditable(true);
				
				pmController.getAddEditController().setIsAdd(true);
				
				cards.show(contentPane, "add edit");
			}
			
			// 검색 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnSearch()))
			{
				view.getSearchStudentModel().setRowCount(0);
				
				boolean isStud = true;
				String id = view.getTextFieldNumber().getText();
				String name = view.getTextFieldName().getText();
				
				if(!id.equals(""))
				{
					if(id.charAt(0) == 'S')
					{
						isStud = true;
					}
					else
					{
						isStud = false;
					}
				}
					
				
				String[] header = { "학번", "이름", "주민번호", "학과"};

					
				view.getSearchStudentModel().setColumnIdentifiers(header); 
				
				view.getSearchStudentTable().getTableHeader().setReorderingAllowed(false);
				
				
				// 테이블에 넣을 컨텐츠 값을 저장하는 변수				
				ArrayList<Student> list = new ArrayList<Student>(); 
				
				list = pm.searchS(id, name, isStud);
				
				Iterator<Student> i = list.iterator();
				while (i.hasNext())
				{
					Student student = new Student();
					
					student = i.next();
					
					String[] row = { 
					student.getId(),
					student.getName(),
					student.getJumin(),
					student.getDepartment()
					
				};
					
				view.getSearchStudentModel().addRow(row);
				
			}
			}
			
			// 수정 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnEdit()))
			{
				
				int row = view.getSearchStudentTable().getSelectedRow();
				
				String id = (String) view.getSearchStudentTable().getValueAt(row, 0);
				String name = (String) view.getSearchStudentTable().getValueAt(row, 1);
				String jumin = (String) view.getSearchStudentTable().getValueAt(row, 2);
				String department = (String) view.getSearchStudentTable().getValueAt(row, 3);
				
				switch(department)
				{
					case "전산학과":
						pmController.getAddEditController().getView().getComboBoxDept().setSelectedItem(Department.COMPUTATIONAL);
						break;
					case "전자공학과":
						pmController.getAddEditController().getView().getComboBoxDept().setSelectedItem(Department.ELECTRONIC);
						break;
					case "화학공학과":
						pmController.getAddEditController().getView().getComboBoxDept().setSelectedItem(Department.CHEMISTRY);
						break;
					case "기계공학과":
						pmController.getAddEditController().getView().getComboBoxDept().setSelectedItem(Department.MACHINE);
						break;
					case "항공우주공학과":
						pmController.getAddEditController().getView().getComboBoxDept().setSelectedItem(Department.AIRLINE);
					default:						
				}
				
				pmController.getAddEditController().getView().getTextFieldName().setText(name);
				pmController.getAddEditController().getView().getTextFieldId().setText(id);
				pmController.getAddEditController().getView().getTextFieldJumin().setText(jumin);
				
				pmController.getAddEditController().setIsAdd(false);
			
				pmController.getAddEditController().getView().getTextFieldId().setEditable(false);
				
				cards.show(contentPane, "add edit");
			}
			
			// 삭제 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnDelete()))
			{
											
				int row = view.getSearchStudentTable().getSelectedRow();
				
				boolean isStud;
				String id = (String) view.getSearchStudentTable().getValueAt(row, 0);	
				
				if(id.charAt(0) == 'S')
				{
					isStud = true;
				}
				else
				{
					isStud = false;
				}
				
				pm.deleteStudent(id, isStud);
				
				pmController.getAddEditController().getView().getTextFieldName().setText(id);
				
				view.getSearchStudentModel().removeRow(row);
			}
		}
	}
}
