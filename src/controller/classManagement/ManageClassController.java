package controller.classManagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import controller.ClassManagementController;
import controller.Controller;
import model.ClassManager;
import model.Lecture;
import view.classManagement.ManageClassPanel;


//강좌관리만 생각하면 됨
public class ManageClassController extends Controller 
{
	ClassManagementController clmController;
	
	ClassManager cm;
	ManageClassPanel view;
	
	
	
	public ManageClassController(ClassManager cm, 
			ManageClassPanel manageClassPanel, ClassManagementController controller)
	{
		clmController = controller;
		this.cm = cm;
		view = manageClassPanel;
	
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		
		init();
	
					
		view.addListener(new MListener());
	}

	public ManageClassPanel getView() 
	{
		return view;
	}
	


	public void init()
	{
		view.getModel().setRowCount(0);
		
	      
		ArrayList<Lecture> lectureList = ClassManager.m_getLectureList();
	  
		
		
			String[] row = new String[10];
			for(int i = 0; i<lectureList.size(); i++) {
			
				
				row[0] = lectureList.get(i).getLecno();
				row[1] = lectureList.get(i).getName();
				row[2] = lectureList.get(i).getDept();
				row[3] = lectureList.get(i).getProfno();
				row[4] = Integer.toString(lectureList.get(i).getMax());
				row[5] = Integer.toString(lectureList.get(i).getMin());
				row[6] = Float.toString(lectureList.get(i).getGrades());
				row[7] = lectureList.get(i).getExplain();
				row[8] = lectureList.get(i).getSemester();
				row[9] = lectureList.get(i).getIsopen();
				
				
				view.getModel().addRow(row);
	      }
	   
	}
	
	
	public ClassManager getModel() 
	{
		return cm;
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			
			if(e.getSource().equals(view.getBtnDetailInfo()))
			{
				// 강좌 변경
				Lecture lecture = new Lecture();
				
				lecture.setLecno((String)view.getTextFieldNum().getText());
				lecture.setName((String)view.getTextname().getText());
				lecture.setDept((String) view.getTextMajor().getText());
				lecture.setProfno((String) view.getTextProc().getText());
				lecture.setMax(Integer.parseInt(view.getTextMax().getText()));
				lecture.setMin(Integer.parseInt(view.getTextMin().getText()));
				lecture.setGrades((String) view.getTextScore().getText());
				lecture.setExplain((String) view.getTextExplain().getText());
			
				cm.updateClass(lecture);
				view.getModel().setRowCount(0);
				init();
			}
			
			// 강좌 삭제
			else if(e.getSource().equals(view.getBtnApplyCancel()))
			{
				Lecture lecture = new Lecture();

				
				lecture.setLecno((String)view.getTextFieldNum().getText());
				cm.deleteClass(lecture);
				view.getModel().setRowCount(0);
				init();
				
			}
			//행 누르면 칸에 넣기
			else if(e.getSource().equals(view.getTableLecture()))
			{
				
				int row = view.getTableLecture().getSelectedRow();
				
				String num =  (String) view.getTableLecture().getValueAt(row, 0);
				String name = (String) view.getTableLecture().getValueAt(row, 1);
				String major = (String) view.getTableLecture().getValueAt(row, 2);
				String proc = (String) view.getTableLecture().getValueAt(row, 3);
				String max = (String) view.getTableLecture().getValueAt(row, 4);
				String min = (String) view.getTableLecture().getValueAt(row, 5);
				String score = (String) view.getTableLecture().getValueAt(row, 6);
				String explain = (String) view.getTableLecture().getValueAt(row, 7);
		
				
				view.getTextFieldNum().setText(num);
				view.getTextname().setText(name);
				view.getTextMajor().setText(major);
				view.getTextProc().setText(proc);
				view.getTextMax().setText(max);
				view.getTextMin().setText(min);
				view.getTextScore().setText(score);
				view.getTextExplain().setText(explain);
				
				
			}
			
		}
	}
	
}
