package model;

import java.util.ArrayList;

import db.StudAndProfData;

@SuppressWarnings("serial")
public class PersonnelManager extends User 
{
	String name;
	String task;
	String jumin;
	
	public PersonnelManager() {}
	
	public PersonnelManager(User user)
	{
		this.id = user.id;
		this.pw = user.pw;
		this.authority = user.authority;
		this.task = "PersonnelManager";
	}
	
	
	// 학생 교수 등록 하기
	public boolean addStudentProfessor(Student student, boolean isStud)
	{
		if(StudAndProfData.addStudentProfessor(student, isStud))
		{
			return true;	// 등록 성공
		}
		else
			return false;   // 등록 실패
	}
	
	// 학생 검색하기 
	public ArrayList<Student> searchS(String id, String name, boolean isStud)
	{
		return StudAndProfData.searchStudent(id, name, isStud);
	}
	
	// 학생 삭제하기
	public boolean deleteStudent(String id, boolean isStud)
	{
		if(StudAndProfData.deleteStudent(id, isStud))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//학생 수정하기
	public boolean editStudent(Student student, boolean isStud)
	{
		if(StudAndProfData.editStudent(student, isStud))
		{
			return true;	// 수정 성공
		}
		else
			return false;   // 수정 실패
	}
	
}
