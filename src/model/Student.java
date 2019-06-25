package model;

import java.util.ArrayList;
import java.util.Iterator;
import db.LectureData;
import db.LectureHistoryData;
import db.UserData;

@SuppressWarnings("serial")
public class Student extends User
{
	String name;
	String jumin;
	String department;
	
	public Student() { }
	
	public Student(User user)
	{
		this.id = user.id;
		this.pw = user.pw;
		this.authority = user.authority;
		
		this.name = UserData.getName(user.id);
	}
	
	public Student(String id, String name, String jumin, String department) 
	{ 
		this.id = id;
		this.pw = jumin.substring(7, 14);  // 기본 비밀번호
		this.authority = id.substring(0, 1);
		
		this.name = name;
		this.jumin = jumin;
		this.department = department;
	}
	
	// 성적표 가져옴
	public ArrayList<String[]> searchGrade(String semester)
	{
		return LectureHistoryData.getGradeList(this.id, semester);		
	}
	
	// 수강 신청
	public boolean lectureApply(String lecno)
	{	
		if(LectureHistoryData.addAppliedLecture(lecno, this.id))
		{
			return true;
		}
		else
		{
			// 수강 신청 실패
			return false;
		}
	}
	

	// 수강 신청 내역 리스트 가져오기
	public ArrayList<Lecture> getAppliedLectureList()
	{		
		ArrayList<Lecture> appliedLectureList = new ArrayList<Lecture>();		
		
		// 강좌 리스트가져옴
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();		
		lectureList = LectureData.getLectureList();
		
		// 수강 신청한 강좌 번호 리스트 가져옴
		ArrayList<String> lecnoList = new ArrayList<String>();
		lecnoList = LectureHistoryData.getAppliedLecnoList(this.id);
		
		Iterator<String> lecnoItr = lecnoList.iterator();
		
		
		while(lecnoItr.hasNext())
		{
			String no = lecnoItr.next();
			
			Iterator<Lecture> lectureItr = lectureList.iterator();
			
			while(lectureItr.hasNext())
			{
				Lecture lecture = lectureItr.next();
				
				// 강좌 리스트중 찾는 강좌 번호와 일치하는 강좌일 경우
				if(lecture.getLecno().equals(no))
				{
					appliedLectureList.add(lecture);
				}
			}
		}
		
		// 수강 신청한 강좌 리스트 반환
		return appliedLectureList;
	}
	
	// 개설된 강좌 리스트 가져오기
	public ArrayList<Lecture> getOpenLectureList()
	{		
		ArrayList<Lecture> openLectureList = new ArrayList<Lecture>();		
		
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		
		lectureList = LectureData.getLectureList();
		
		for(Iterator<Lecture> i = lectureList.iterator(); i.hasNext();)
		{			
			Lecture lecture = new Lecture();		
			
			lecture = i.next();
			if(lecture.getIsopen().equals("open"))
			{
				openLectureList.add(lecture);
			}			
		}			
				
		return openLectureList; 
	}
	
	// 선택한 강좌 상세 정보 가져오기
	public String getLectureInfo(String lecno)
	{
		return LectureData.getLectureInfo(lecno);
	}
	
	// 수강 취소 하기
	public boolean applyCancel(String lecno)
	{
		if(LectureHistoryData.cancelAppliedLecture(lecno, this.id))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// 수강 신청 학점 합 가져오기
	public float getTotalGrades()
	{
		return LectureData.getTotalGrades(this.id);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDepartment() {
		return department;
	}


	public String getJumin() {
		return jumin;
	}
	
	
}
