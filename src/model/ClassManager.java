package model;
///////////////////////////////
//////- 새로운 강좌 등록
//////- 강좌 개설 
//////* 개설시 담당 교수, 수강 가능 최소/최대 수 지정
//////* 매 학기 등록된 강좌에 대해서만
//////- 강좌 관리
//////* 한번도 개설되지 않은 강좌만 강좌번호 제외 다른 정보 변경, 강좌 삭제 가능
//////* 강좌 정보 : 강좌 번호, 강좌 이름, 담당 학과, 학점 수, 강좌 설명
////////////////////////////////////

import java.util.ArrayList;
import db.ClassManagerData;

/**
 * Create the panel.
 * MODEL 실질적인 소스들
 */
@SuppressWarnings("serial")
public class ClassManager extends User
{
	String naem;
	String task;
	String Jumin;

	public ClassManager() {}
	
	public ClassManager(User user)
	{
		this.id = user.id;
		this.pw = user.pw;
		this.authority = user.authority;
		this.task = "ClassManager";
	}
	
	// 강좌 등록 하기
	public boolean addClass(Lecture lecture)
	{
		if(ClassManagerData.addClass(lecture))
		{
			return true;	// 등록 성공
		}
		else
			return false;   // 등록 실패		
	}
	// 강좌 개설 하기
		public boolean openClass(Lecture lecture)
		{
			if(ClassManagerData.openClass(lecture))
			{
				return true;	// 등록 성공
			}
			else
				return false;   // 등록 실패		
		}
		
		//강좌 닫기
		public boolean unopenClass(Lecture lecture)
		{
			if(ClassManagerData.unopenClass(lecture))
			{
				return true;	// 등록 성공
			}
			else
				return false;   // 등록 실패		
		}
	// 개설안한 강좌 리스트 가져오기 
	public static ArrayList<Lecture> m_getLectureList()
	{
		return ClassManagerData.m_getLectureList(); 
	}
	//모든 강좌 리스트 가져오기
	public static ArrayList<Lecture> getLectureList()
	{
		return ClassManagerData.getLectureList(); 
	}

	// 강좌 변경 하기
		public boolean updateClass(Lecture lecture)
		{
			
			if(ClassManagerData.updateClass(lecture))
			{
				return true;	// 등록 성공
			}
			else
				return false;   // 등록 실패		
		}
	// 강좌 삭제 하기
		public boolean deleteClass(Lecture lecture) {
			// TODO Auto-generated method stub
			if(ClassManagerData.deleteClass(lecture))
			{
				return true;	// 등록 성공
			}
			else
				return false;   // 등록 실패		
		}
	

}
