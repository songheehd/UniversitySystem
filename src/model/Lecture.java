package model;

import java.util.Vector;

import main.Semester;

@SuppressWarnings({ "serial", "rawtypes" })
public class Lecture extends Vector
{
	String lecno;
	String name;
	String dept;
	String profno;
	int max;
	int min;
	float grades;
	String explain;
	String semester;
	String isopen;
	
	public Lecture()
	{
		semester = Semester.SEMESTER.toString(); 
	}

	public String getLecno() {
		return lecno;
	}

	public void setLecno(String lecno) {
		this.lecno = lecno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getProfno() {
		return profno;
	}

	public void setProfno(String profno) {
		this.profno = profno;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int now) {
		this.min = now;
	}

	public float getGrades() {
		return grades;
	}

	public void setGrades(float grades)
	{
		this.grades = grades;
	}
	
	public void setGrades(String grades) 
	{
		Float g = Float.parseFloat(grades);
		this.grades = g;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	
	
	
}
