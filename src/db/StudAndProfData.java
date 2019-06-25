package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



import model.Student;

public class StudAndProfData 
{
	static Logger logger = Logger.getLogger("log"); // 로그를 출력할 로그 객체

	private StudAndProfData() {}

	// 학생, 교수를 추가 하는 기능
	public static boolean addStudentProfessor(Student student, boolean isStud) 
	{
		PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
		PreparedStatement pstmStudents = null;
		String quary = null; // 쿼리문을 저장할 변수
		String table;
		
		// 학생이면
		if(isStud)
			table = "STUDENTS";
		else
			table = "PROFESSORS";
		
		try {
			// USERS 테이블에 레코드 삽입
			quary = String.format("INSERT INTO USERS VALUES ( '%s', '%s', '%s')", student.getId(), student.getPw(),
					student.getAuthority());

			pstmUsers = DBConnection.conn.prepareStatement(quary);

			pstmUsers.executeUpdate(); // insert문 실행

			// STUDENTS 테이블에 레코드 삽입
			quary = String.format("INSERT INTO %s VALUES ( '%s', '%s', '%s', '%s' )",table, student.getId(),
					student.getName(), student.getJumin(), student.getDepartment());

			pstmStudents = DBConnection.conn.prepareStatement(quary);

			pstmStudents.executeUpdate(); // insert문 실행

			DBConnection.conn.commit(); // commit 실행

			return true;
		} catch (SQLException sqle) {
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			return false;
		} finally {
			// pstm을 close한다
			if (pstmUsers != null) {
				try {
					pstmUsers.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstmStudents != null) {
				try {
					pstmStudents.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}
	}
	
	// 학생을 찾는 기능
	public static ArrayList<Student> searchStudent(String id, String name, boolean isStud) 
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체
		ResultSet rs = null; 
		String quary = null; // 쿼리문을 저장할 변수
		String table;
		String column;
		
		// 학생이면
		if(isStud)
		{
			table = "STUDENTS";
			column = "STDNO";
		}			
		else
		{
			table = "PROFESSORS";
			column = "PROFNO";
		}
			
		
		
		ArrayList<Student> result = new ArrayList<Student>();
		
		try 
		{
			if (id.equals("") && name.equals(""))
			{
				quary = String.format("SELECT * FROM %s", table);
			}
			else
			{
				quary = String.format("SELECT * FROM %s WHERE %s = '%s' and name = '%s'", table, column, id, name);
			}
			
		
			pstm = DBConnection.conn.prepareStatement(quary);
			
			rs = pstm.executeQuery();
			
			while (rs.next())
			{
				Student student = new Student(
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				result.add(student);
		
			}
			
			return result;
		} 
		catch (SQLException sqle)   
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			return null;
		} 
		finally 
		{
			// pstm을 close한다
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
		}
		
	}

	//학생을 삭제 하는 기능
	public static boolean deleteStudent(String id, boolean isStud) {
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체 
		String quary = null; // 쿼리문을 저장할 변수
		String table;
		String column;
		
		if(isStud)
		{
			table = "STUDENTS";
			column = "STDNO";
		}			
		else
		{
			table = "PROFESSORS";
			column = "PROFNO";
		}
		
		try 
		{
			quary = String.format("DELETE FROM %s WHERE %s = '%s'", table, column, id);
							
			System.out.println(quary);
			pstm = DBConnection.conn.prepareStatement(quary);
			
			pstm.executeUpdate(); 	
			
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
			// pstm을 close한다
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
	
	//학생 정보 수정하는 기능
	public static boolean editStudent(Student student, boolean isStud) 
	{		
		PreparedStatement pstmStudents = null;
		String quary = null; // 쿼리문을 저장할 변수
		String table;
		String column;
		
		if(isStud)
		{
			table = "STUDENTS";
			column = "STDNO";
		}			
		else
		{
			table = "PROFESSORS";
			column = "PROFNO";
		}
		
		try {
			// STUDENTS 테이블에 레코드 삽입
			quary = String.format("UPDATE %s SET NAME = '%s', JUMIN = '%s', DEPT = '%s' WHERE %s = '%s'",
					table, student.getName(), student.getJumin(), student.getDepartment(), column, student.getId());

			pstmStudents = DBConnection.conn.prepareStatement(quary);

			pstmStudents.executeUpdate(); // update문 실행

			DBConnection.conn.commit(); // commit 실행

			return true;
		} catch (SQLException sqle) {
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
			return false;
		} finally {
			// pstm을 close한다
			if (pstmStudents != null) {
				try {
					pstmStudents.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}
	}
}

