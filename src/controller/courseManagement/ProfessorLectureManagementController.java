 package controller.courseManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.Controller;
import controller.CourseManagementController;
import main.Semester;
import model.Professor;
import view.courseManagement.ProfessorLectureManagementPanel;


public class ProfessorLectureManagementController extends Controller 
{
	CourseManagementController comController;
	
	Professor professor;
	
	ProfessorLectureManagementPanel view;
	Container contentPane;
	CardLayout cards;
	
	public ProfessorLectureManagementController(Professor professor, 
			ProfessorLectureManagementPanel view, CourseManagementController controller)
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
		
		String[] myLectureHeader = {"강좌 번호", "강좌 이름"};
		
		// 내 강좌 리스트 초기화
		initTable(view.getMyLectureTable(), myLectureHeader,
				view.getMyLectureModel(), professor.getMyLectureList(Semester.SEMESTER));
		
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
			// 출석부 조회 버튼 클릭시
			if(e.getSource().equals(view.getBtnAttendance()))
			{
				cards.show(contentPane, "professor attendance");
			}
			
			// 강좌 테이블 클릭 시
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
						view.getStudentListModel(), professor.getStudentList(lecno, Semester.SEMESTER));
			}
			
			// 학생 리스트 테이블 클릭 시
			else if(e.getSource().equals(view.getStudentListTable()))
			{
				int row = view.getStudentListTable().getSelectedRow();
				
				// 선택한 항목의 학생 정보를 가져옴
				String stdno = (String) view.getStudentListTable().getValueAt(row, 0);
				String name = (String) view.getStudentListTable().getValueAt(row, 1);

				// 선택한 학생 정보 출력
				view.getTextFieldId().setText(stdno);
				view.getTextFieldName().setText(name);
			}
			
			// 성적 입력 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnUpdate()))
			{
				int lectureRow = view.getMyLectureTable().getSelectedRow();
				int studentRow = view.getStudentListTable().getSelectedRow();
				
				// 선택한 강좌 번호와 학생 번호 입력할 성적 정보를 가져옴
				String lecno = (String) view.getMyLectureTable().getValueAt(lectureRow, 0);
				String stdno = (String) view.getStudentListTable().getValueAt(studentRow, 0);
				String grade = view.getComboBoxGrade().getSelectedItem().toString();
				
				// 선택한 학생 성적 업데이트 
				if(professor.updateGrade(lecno, stdno, grade))
				{
					// 업데이트 성공 시
					
					// 학생 리스트 초기화 
 					view.getStudentListModel().setRowCount(0);						
					String[] studentListHeader = {"학번", "이름", "학점"};					
					initTable(view.getStudentListTable(), studentListHeader,
							view.getStudentListModel(), professor.getStudentList(lecno, Semester.SEMESTER));
					
					JOptionPane.showMessageDialog(null, 
							"성적 입력 완료", "UIS", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{					
					// 업데이트 실패 시
					JOptionPane.showMessageDialog(null, 
							"성적입력에 실패하였습니다!", "UIS", JOptionPane.ERROR_MESSAGE);										
				}
			}
		}
	}
}
