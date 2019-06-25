package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Semester;
import model.Lecture;

public class LectureData 
{
	static Logger logger = Logger.getLogger("log");  // 로그를 출력할 로그 객체
    
	private LectureData() {}
	
	
	// 강좌 리스트 가져오기
	public static ArrayList<Lecture> getLectureList() {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();

		try {
			quary = String.format("SELECT * FROM LECTURE");
			pstm = DBConnection.conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setLecno(rs.getString(1));
				lecture.setName(rs.getString(2));
				lecture.setDept(rs.getString(3));
				lecture.setProfno(rs.getString(4));
				lecture.setMax(rs.getInt(5));
				lecture.setMin(rs.getInt(6));
				lecture.setGrades(rs.getFloat(7));
				lecture.setExplain(rs.getString(8));
				lecture.setSemester(rs.getString(9));
				lecture.setIsopen(rs.getString(10));
				
				lectureList.add(lecture);
			}

		} catch (SQLException sqle) {
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}

		return lectureList;
	}
	
	// 강좌 상세 정보 가져오기
	public static String getLectureInfo(String lecno) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		String result = null;

		try 
		{
			quary = String.format("SELECT EXPLAIN FROM LECTURE WHERE LECNO = '%s'", lecno);
			pstm = DBConnection.conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				result = rs.getString(1);
			}
			
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
		} 
		finally 
		{
			if (rs != null) 
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstm != null) 
			{
				try 
				{
					pstm.close();
				} 
				catch (SQLException e) 
				{
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}

		return result;
	}
	
	
	// 학생 신청 학점 가져오기
	public static float getTotalGrades(String id) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		
		float result = 0;

		try 
		{
			quary = String.format("SELECT SUM(GRADES) "
					+ "FROM LECTURE JOIN LEC_HISTORY ON LECTURE.LECNO = LEC_HISTORY.LECNO "
					+ "WHERE STDNO = '%s' AND LEC_HISTORY.SEMESTER = '%s'",
					id, Semester.SEMESTER.toString());
			pstm = DBConnection.conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				result = rs.getFloat(1);
			}
			
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
		} 
		finally 
		{
			if (rs != null) 
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstm != null) 
			{
				try 
				{
					pstm.close();
				} 
				catch (SQLException e) 
				{
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}

		return result;
	}
	
	// 자신이 강의하는 강좌 리스트 가져오기
	public static ArrayList<String[]> getMyLectureList(String id, Semester semester) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		ArrayList<String[]> myLectureList = new ArrayList<String[]>();

		try 
		{
			quary = String.format("SELECT LECNO, NAME "
					+ "FROM LECTURE "
					+ "WHERE PROFNO = '%s' AND SEMESTER = '%s'",
					id, semester.toString());
			
			
			pstm = DBConnection.conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				
				String[] row = { rs.getString(1), rs.getString(2) };
				
				myLectureList.add(row);
			}

		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
		} 
		finally 
		{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}

		return myLectureList;
	}
	
}
