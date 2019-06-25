package controller.courseManagement;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.CourseManagementController;
import model.Lecture;
import model.Student;
import view.courseManagement.StudentCourseApplyPanel;

public class StudentCourseApplyController extends Controller 
{
	CourseManagementController comController;
	
	Student student;
	
	StudentCourseApplyPanel view;
	Container contentPane;
	CardLayout cards;
	
	public StudentCourseApplyController(Student student, 
			StudentCourseApplyPanel view, CourseManagementController controller)
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
		
		// 원래 있던 테이블 정보 지움
		view.getOpenLectureModel().setRowCount(0);
		view.getAppliedLectureModel().setRowCount(0);
		
		initTable(view.getOpenLectureTable(), 
				view.getOpenLectureModel(), student.getOpenLectureList());;
		
		initTable(view.getAppliedLectureTable(),
				view.getAppliedLectureModel(), student.getAppliedLectureList());
					
	}
	
	// 테이블 초기화
	public void initTable(JTable table, DefaultTableModel model, ArrayList<Lecture> list)
	{
		// 테이블 컬럼명 설정 
		String[] header = {"강좌 번호", "강좌 이름", "학과", "교수번호", "최대 수강 인원", "최소 수강 인원", "학점"};				
		
		// 테이블 헤더 설정
		model.setColumnIdentifiers(header);
		
		// 칼럼 위치 고정
		table.getTableHeader().setReorderingAllowed(false);
		
		// 출력할 리스트를 반복해서 접근
		Iterator<Lecture> i = list.iterator();		
		while(i.hasNext())
		{
			// 강좌 하나를 저장할 변수
			Lecture lecture = new Lecture();
			
			// 강좌를 순서대로 하나씩 가져옴
			lecture = i.next();
						
			// 컨텐츠에 추가할 행을 생성
			String[] row = {
					lecture.getLecno(), 
					lecture.getName(), 
					lecture.getDept(), 
					lecture.getProfno(),
					Integer.toString(lecture.getMax()),
					Integer.toString(lecture.getMin()),
					Float.toString(lecture.getGrades())							
			};		
			
			// 테이블에 레코드 행 하나 추가
			model.addRow(row);			
		}
	}
	
	
	public StudentCourseApplyPanel getView() 
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
			// 성적 조회 버튼 클릭 시
			if(e.getSource().equals(view.getBtnGrade()))
			{				
				// 성적 조회 뷰로 이동
				cards.show(contentPane, "student grade");		
				
			}
			
			// 상세 보기 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnDetailInfo()))
			{
				// 테이블에서 선택된 행을 가져옴
				int row = view.getOpenLectureTable().getSelectedRow();
				String lecno = (String) view.getOpenLectureTable().getValueAt(row, 0); 
				String lecname = (String) view.getOpenLectureTable().getValueAt(row, 1);							
				
				// 상세 정보를 가져옴
				String info = student.getLectureInfo(lecno);							
				
				// 상세 정보창 출력
				JOptionPane.showMessageDialog(null, 
						lecname + "\n\n" + "< 상세 정보 >\n\n" + info, "UIS",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			// 수강 신청 하기 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnLectureApply()))
			{												
				int row = view.getOpenLectureTable().getSelectedRow();		
				
				// 선택된 행의 강좌 번호를 가져옴
				String lecno = (String) view.getOpenLectureTable().getValueAt(row, 0); 
												
				// 선택된 행의 학점을 가져옴
				float grades = Float.parseFloat((String) view.getOpenLectureTable().getValueAt(row, 6));			
				
				// 중복 신청 확인
				ArrayList<Lecture> lectureList = student.getAppliedLectureList();				
				Iterator<Lecture> itr = lectureList.iterator();				
				while(itr.hasNext())
				{
					Lecture lecture = itr.next();
					
					// 수강 신청된 강좌 번호들과 비교
					if(lecno.equals(lecture.getLecno()))
					{
						// 이미 신청된 강좌 이면
						JOptionPane.showMessageDialog(null, "이미 수강 신청된 강좌입니다!", "UIS",
								JOptionPane.ERROR_MESSAGE);
						// 종료
						return;
					}
				}
				
				// 최대 신청 가능 학점 
				if((student.getTotalGrades() + grades) <= 18.0)
				{
					// 총 신청 학점이 18학점 이하 일때
					if(student.lectureApply(lecno))
					{
						// 수강 신청 성공					
						JOptionPane.showMessageDialog(null, "수강 신청 완료", "UIS",
								JOptionPane.INFORMATION_MESSAGE);
						
						// 신청한 내용 출력을 업데이트
						init();
					}
					else
					{					
						// 수강 신청 실패						
						JOptionPane.showMessageDialog(null, "수강 신청에 실패하였습니다!", "UIS",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else					
				{
					// 선택된 강좌의 학점을 합하여 18학점을 초과할 때
					JOptionPane.showMessageDialog(null, "신청 학점이 18점을 초과합니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
				}								
			}
			
			// 수강 취소 하기 버튼 클릭 시
			else if(e.getSource().equals(view.getBtnApplyCancel()))
			{
				// 테이블에서 선택된 행을 가져옴
				int row = view.getAppliedLectureTable().getSelectedRow();
				
				// 선택된 행의 강좌 번호를 가져옴
				String lecno = (String) view.getAppliedLectureTable().getValueAt(row, 0);
				
				if(student.applyCancel(lecno))
				{
					// 취소 성공
					JOptionPane.showMessageDialog(null, "수강 취소 완료", "UIS",
							JOptionPane.INFORMATION_MESSAGE);
					// 취소한 내용을 업데이트
					init();
				}
				else
				{
					// 취소 실패
					JOptionPane.showMessageDialog(null, "수강 취소에 실패하였습니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			
		}
	}

}
