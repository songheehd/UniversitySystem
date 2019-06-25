package controller;


import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.User;

public abstract class Controller
{ 
	public void setUser(User user) {}
	
	public abstract JPanel getView();
	
	// 뷰 초기화
	public void init()
	{
		
	}
	
	
	// 전달 받은 스트링 배열 리스트로 테이블을 초기화 하는 메서드
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
}
