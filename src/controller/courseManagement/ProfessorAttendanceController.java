package controller.courseManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import controller.Controller;
import controller.CourseManagementController;
import main.Semester;
import model.Professor;
import view.courseManagement.ProfessorAttendancePanel;


public class ProfessorAttendanceController extends Controller {

	CourseManagementController comController;
	
	Professor professor;
	
	ProfessorAttendancePanel view;
	Container contentPane;
	CardLayout cards;
	
	public ProfessorAttendanceController(Professor professor, 
			ProfessorAttendancePanel view, CourseManagementController controller)
	{
		comController = controller;
		this.professor = professor;
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
		professor = (Professor) comController.getUser();
		
		// 원래 있던 테이블 정보 지움
		view.getMyLectureModel().setRowCount(0);
		view.getStudentListModel().setRowCount(0);
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
			// 강좌 관리 버튼 클릭 시
			if(e.getSource().equals(view.getBtnLectureManagement()))
			{
				cards.show(contentPane, "professor lecture management");
			}
			
			// 조회 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnSearch()))
			{
				view.getMyLectureModel().setRowCount(0);
				view.getStudentListModel().setRowCount(0);
				
				String[] header = {"강좌 번호", "강좌 이름"};	
				
				// 선택된 학기에 맞는 강좌 리스트를 가져옴
				initTable(view.getMyLectureTable(),
						header,
						view.getMyLectureModel(),
						professor.getMyLectureList
						((Semester)view.getComboBoxSemester().getSelectedItem()));				
			}
			
			// 내 강좌 리스트 클릭 시
			else if(e.getSource().equals(view.getMyLectureTable()))
			{
				// 학생 리스트를 초기화 함
				view.getStudentListModel().setRowCount(0);
				
				int row = view.getMyLectureTable().getSelectedRow();
				
				// 선택한 항목의 강좌 번호를 가져옴
				String lecno = (String) view.getMyLectureTable().getValueAt(row, 0);
				
				// 학생 리스트 초기화
				String[] studentListHeader = {"학번", "이름", "학점"};
				
				initTable(view.getStudentListTable(), studentListHeader,
						view.getStudentListModel(), 
						professor.getStudentList
						(lecno, (Semester)view.getComboBoxSemester().getSelectedItem()));
			}
		}
	}

}
