package model;

import java.util.ArrayList;

import db.LectureData;
import db.LectureHistoryData;
import main.Semester;

@SuppressWarnings("serial")
public class Professor extends User 
{
	String name;
	String department;
	String jumin;
	
	public Professor() {}
	
	public Professor(User user) 
	{
		this.id = user.id;
		this.pw = user.pw;
		this.authority = user.authority;
	}
	
	// 해당 학기에 자신이 강의한 강좌 리스트 가져오기
	public ArrayList<String[]> getMyLectureList(Semester semester)
	{	
		return LectureData.getMyLectureList(this.id, semester);
		
	}
	
	// 선택한 강의를 듣는 학생 명단 가져오기 
	public ArrayList<String[]> getStudentList(String lecno, Semester semester)
	{
		return LectureHistoryData.getStudentList(lecno, semester);
	}

	// 학생 성적 입력
	public boolean updateGrade(String lecno, String stdno, String grade)
	{
		if(LectureHistoryData.updateGrade(lecno, stdno, grade))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
