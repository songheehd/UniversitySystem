package controller.classManagement;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ClassManagementController;
import controller.Controller;
import model.ClassManager;
import model.Lecture;
import view.classManagement.OpenClassPanel;

public class OpenClassController extends Controller 
{
	ClassManagementController clmController;
	
	ClassManager cm;
	
	OpenClassPanel view;
	JPanel clmContentPane;
	CardLayout clmCards;
	
	public OpenClassController(ClassManager cm, 
			OpenClassPanel openClassPanel, ClassManagementController controller)
	{
		clmController = controller;
		this.cm = cm;
		view = openClassPanel;
	
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		init();
		
		view.addListener(new MListener());					
	}
	
	public OpenClassPanel getView() 
	{
		return view;
	}
	
	public void init()
	{
		view.getModel().setRowCount(0);
		
		ArrayList<Lecture> lectureList = ClassManager.getLectureList();
	  
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
	/******* 이벤트 리스너용 내부 클래스 *******/
	String isopen;
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			
			
	
			
			if(e.getSource().equals(view.getBtnOpen()))
			{
				String open = "open";
				
				int row = view.getTableLecture().getSelectedRow();

			
			// 강좌 개설
				Lecture lecture = new Lecture();
				String open_bp = (String) view.getTableLecture().getValueAt(row,9);
				
		
				//OPEN인데 강좌 개설시
				lecture.setLecno((String)view.getTextLecno().getText());
				lecture.setProfno((String) view.getTextproc().getText());
				lecture.setMax(Integer.parseInt(view.getTextmax().getText()));
				lecture.setMin(Integer.parseInt(view.getTextmin().getText()));
				
			    if(open_bp.equals(open))
				{
					
					JOptionPane.showMessageDialog(null, 
							"이미 개설한 강좌입니다",
							"개설된 강좌입니다", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else 
				{
					
					JOptionPane.showMessageDialog(null, 
							"해당 강좌가 개설 되었습니다");
					
				}
				
					lecture.setLecno((String) view.getTableLecture().getValueAt(row, 0));
					cm.openClass(lecture);
					view.getModel().setRowCount(0);	
				
				init();
			}
			
			//강좌 닫음
			else if(e.getSource().equals(view.getBtnUnOpen()))
			{
				
				String close = "close";
		
				int row = view.getTableLecture().getSelectedRow();
				
				
				Lecture lecture = new Lecture();
				String close_bp = (String) view.getTableLecture().getValueAt(row, 9);
				
				//OPEN인데 강좌 개설시
				if( close_bp.equals(close))
				{
					
					JOptionPane.showMessageDialog(null, 
							"이미 닫힌 강좌입니다",
							"이미 닫힌강좌입니다", JOptionPane.ERROR_MESSAGE);
					
					
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, 
							"강좌가 닫혔습니다");
					
					
				}

					lecture.setLecno((String) view.getTableLecture().getValueAt(row, 0));
					cm.unopenClass(lecture);
					view.getModel().setRowCount(0);
					
				
				init();
			}
			
			//행 누르면 칸에 넣기
			
			if(e.getSource().equals(view.getTableLecture()))
			{
				
				int row = view.getTableLecture().getSelectedRow();
				String num =  (String) view.getTableLecture().getValueAt(row, 0);
				String proc = (String) view.getTableLecture().getValueAt(row, 3);
				String max = (String) view.getTableLecture().getValueAt(row, 4);
				String min = (String) view.getTableLecture().getValueAt(row, 5);
				
				
				view.getTextLecno().setText(num);
				view.getTextproc().setText(proc);
				view.getTextmax().setText(max);
				view.getTextmin().setText(min);
				
			}
	
			
		}
	}
}
