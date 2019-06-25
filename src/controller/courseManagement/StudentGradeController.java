package controller.courseManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.CourseManagementController;
import model.Student;
import view.courseManagement.StudentGradePanel;

public class StudentGradeController extends Controller 
{
	CourseManagementController comController;
	
	Student student;
	
	StudentGradePanel view;
	Container contentPane;
	CardLayout cards;
	
	public StudentGradeController(Student student, 
			StudentGradePanel view, CourseManagementController controller)
	{
		comController = controller;
		this.student = student;
		this.view = view;
		
		// 강좌 관리 컨트롤러에서 카트레이아웃과 패널을 가져옴
		contentPane = comController.getComContentPane();
		cards = comController.getComCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		this.view.addListener(new MListener());
	}
	
	// 뷰 초기화
	@Override
	public void init()
	{
		student = (Student) comController.getUser();
		
		view.getLectureGradeModel().setRowCount(0);
	}
	
	// 검색하기 
	public void search()
	{
		view.getLectureGradeModel().setRowCount(0);
		
		// 테이블 컬럼명 설정 
		String[] header = {"강의 이름", "학점"};		
		
		initTable(view.getLectureGradeTable(),
				header,
				view.getLectureGradeModel(),
				student.searchGrade
				(view.getComboBoxSemester().getSelectedItem().toString()));
	
	}
	
	// 테이블 초기화
	@Override
	public void initTable(JTable table, String[] header, 
			DefaultTableModel model, ArrayList<String[]> list)
	{
		// 테이블 헤더 설정
		model.setColumnIdentifiers(header);
		
		// 칼럼 위치 고정
		table.getTableHeader().setReorderingAllowed(false);
		
		// 출력할 리스트를 반복해서 접근
		Iterator<String[]> i = list.iterator();		
		while(i.hasNext())
		{
			// 테이블에 레코드 행 하나 추가
			model.addRow(i.next());			
		}
	}
	
	@Override
	public StudentGradePanel getView() 
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
			// 수강 신청 버튼 클릭시
			if(e.getSource().equals(view.getBtnLectureApply()))
			{
				cards.show(contentPane, "student course apply");
			}
			
			// 검색 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnSearch()))
			{
				search();
			}
		}
	}
}
