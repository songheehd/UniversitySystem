package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Semester;


public class LectureHistoryData 
{
static Logger logger = Logger.getLogger("log");  // 로그를 출력할 로그 객체
    
	private LectureHistoryData() {}
	

	// 수강 신청 내역 추가
	public static boolean addAppliedLecture(String lecno, String id)
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체		
		String quary = null; // 쿼리문을 저장할 변수
		
		try 
		{
			quary = String.format("INSERT INTO LEC_HISTORY VALUES ( '%s', '%s', '%s', default )",
					Semester.SEMESTER.toString(), lecno, id);

			pstm = DBConnection.conn.prepareStatement(quary);

			pstm.executeUpdate(); // insert문 실행

			DBConnection.conn.commit(); // commit 실행
			
			return true;
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			
			return false;
		} 
		finally 
		{
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
	}
	
	// 수강 취소 하기
	public static boolean cancelAppliedLecture(String lecno, String id)
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체		
		String quary = null; // 쿼리문을 저장할 변수
		
		try 
		{
			quary = String.format("DELETE FROM LEC_HISTORY "
					+ "WHERE LECNO = '%s' AND STDNO = '%s' AND SEMESTER = '%s'",
					lecno, id, Semester.SEMESTER.toString());

			pstm = DBConnection.conn.prepareStatement(quary);

			pstm.executeUpdate(); // insert문 실행

			DBConnection.conn.commit(); // commit 실행
			
			return true;
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			
			return false;
		} 
		finally 
		{
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
	}
	
	// 학생이 이번 학기에 수강 신청한 강좌 번호 리스트 가져오기
	public static ArrayList<String> getAppliedLecnoList(String id) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		ArrayList<String> result = new ArrayList<String>();

		try 
		{
			quary = String.format("SELECT LECNO FROM LEC_HISTORY "
					+ "WHERE STDNO = '%s' AND SEMESTER = '%s'", id, Semester.SEMESTER.toString());
			
			pstm = DBConnection.conn.prepareStatement(quary);
			
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				result.add(rs.getString(1));
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
	
	// 학생 성적 리스트 가져오기
	public static ArrayList<String[]> getGradeList(String id, String semester) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		try 
		{
			quary = String.format("SELECT LECTURE.NAME, GRADE "
					+ "FROM LECTURE JOIN LEC_HISTORY ON LECTURE.LECNO = LEC_HISTORY.LECNO "
					+ "WHERE LEC_HISTORY.SEMESTER = '%s' AND LEC_HISTORY.STDNO = '%s'",
					semester, id);
			
			pstm = DBConnection.conn.prepareStatement(quary);
			
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				String[] row = { rs.getString(1), rs.getString(2) };
				result.add(row);
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
	
	// 선택한 강좌를 수강하는 학생 명단 가져오기
	public static ArrayList<String[]> getStudentList(String lecno, Semester semester) 
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String quary = null;
		
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		try 
		{
			quary = String.format("SELECT LEC_HISTORY.STDNO, NAME, GRADE "
					+ "FROM LEC_HISTORY JOIN STUDENTS ON LEC_HISTORY.STDNO = STUDENTS.STDNO "
					+ "WHERE LECNO = '%s' AND SEMESTER = '%s'", lecno, semester.toString());
			
			pstm = DBConnection.conn.prepareStatement(quary);
			
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				String[] row = { rs.getString(1), rs.getString(2), rs.getString(3) };
				result.add(row);
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
	
	// 학생 성적 업데이트
	public static boolean updateGrade(String lecno, String stdno, String grade)
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체		
		String quary = null; // 쿼리문을 저장할 변수
		
		try 
		{
			quary = String.format("UPDATE LEC_HISTORY "
					+ "SET GRADE = '%s' "
					+ "WHERE SEMESTER = '%s' AND LECNO = '%s' AND STDNO = '%s'",
					grade, Semester.SEMESTER.toString(), lecno, stdno);

			pstm = DBConnection.conn.prepareStatement(quary);

			pstm.executeUpdate();

			DBConnection.conn.commit();
			
			return true;
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			
			return false;
		} 
		finally 
		{
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
	}
}
