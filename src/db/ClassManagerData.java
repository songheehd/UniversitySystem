package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.classManagement.ManageClassController;
import model.Lecture;


/**
 * Create the panel.
 * View/- GUI를 나타내기만 할 뿐(선언만 해라)
 */
public class ClassManagerData 
{
	static Logger logger = Logger.getLogger("log"); // 로그를 출력할 로그 객체
	ManageClassController mcc;
	private ClassManagerData() {}

	// 강좌 등록
	public static boolean addClass(Lecture lecture) 
	{
		PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
		String quary = null; // 쿼리문을 저장할 변수

		try 
		{
			// LECUTRE 테이블에 레코드 삽입
			quary = String.format("INSERT INTO LECTURE VALUES "
					+ "( '%s','%s','%s', default, default, default, '%.1f', '%s', '%s', default )",
					lecture.getLecno(),lecture.getName(), lecture.getDept(),
					lecture.getGrades(), lecture.getExplain(), lecture.getSemester());

			pstmUsers = DBConnection.conn.prepareStatement(quary);

			pstmUsers.executeUpdate(); // insert문 실행

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
			if (pstmUsers != null) {
				try {
					pstmUsers.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
			if (pstmUsers != null) {
				try {
					pstmUsers.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Close Fail : " + e.toString());
				}
			}
		}
	}
//////////////////////////////////////////////////////////////		
	//강좌 변경
		public static boolean updateClass(Lecture lecture) 
		{
			PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
			String quary = null; // 쿼리문을 저장할 변수

			try 
			{
				
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("UPDATE LECTURE SET NAME = '%s' ,DEPT = '%s', PROFNO = '%s', "
						+ "MAX = '%d', MIN = '%d', GRADES = '%.1f', EXPLAIN = '%s' WHERE LECNO = '%s'",
						lecture.getName(), lecture.getDept(), lecture.getProfno(),
						lecture.getMax(),lecture.getMin(),
						lecture.getGrades(), lecture.getExplain(), lecture.getLecno());

				
				
				pstmUsers = DBConnection.conn.prepareStatement(quary);

				pstmUsers.executeUpdate(); // update문 실행

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
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
					
				}
			}
			
		}
	
	
		
	
		// 강좌 관리
		public static ArrayList<Lecture> m_getLectureList() {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			String quary = null;
	
			ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
	
			try 
			{
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("SELECT * FROM LECTURE  WHERE ISOPEN = 'close'");
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
			//모든 강좌 조회
		public static ArrayList<Lecture> getLectureList() {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			String quary = null;
	
			ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
	
			try 
			{
				// LECUTRE 테이블에 레코드 삽입
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

			//강좌 삭제
		public static boolean deleteClass(Lecture lecture) 
		{
			PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
			String quary = null; // 쿼리문을 저장할 변수

			try 
			{
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("Delete FROM LECTURE WHERE LECNO='%s'",lecture.getLecno());
				
				pstmUsers = DBConnection.conn.prepareStatement(quary);
				
				pstmUsers.executeUpdate(); // update문 실행

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
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
			}
			
		}
		
		
//강좌 개설
		
		public static boolean openClass(Lecture lecture) 
		{
			PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
			PreparedStatement pstmOpen = null;
			String quary = null; // 쿼리문을 저장할 변수

			try 
			{
				
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("UPDATE LECTURE SET  PROFNO = '%s', MAX = '%d', MIN = '%d' "
						+ "WHERE LECNO = '%s'",lecture.getProfno(),
						lecture.getMax(),lecture.getMin(),lecture.getLecno());


				pstmUsers = DBConnection.conn.prepareStatement(quary);
				pstmUsers.executeUpdate(); // update문 실행
				
				DBConnection.conn.commit(); // commit 실행

				quary = null;
				
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("UPDATE LECTURE SET ISOPEN = 'open'  WHERE LECNO = '%s'",
						 lecture.getLecno());

				pstmOpen = DBConnection.conn.prepareStatement(quary);
				
				pstmOpen.executeUpdate(); // update문 실행

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
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
				if (pstmOpen != null) {
					try {
						pstmOpen.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
			}
			
		}
		
		
		//강좌 닫는 곳
		public static boolean unopenClass(Lecture lecture) {
			PreparedStatement pstmUsers = null; // SQL 문을 나타내는 객체
			String quary = null; // 쿼리문을 저장할 변수

			try 
			{
				
				// LECUTRE 테이블에 레코드 삽입
				quary = String.format("UPDATE LECTURE SET ISOPEN = 'close'  WHERE LECNO = '%s'",
						 lecture.getLecno());


				pstmUsers = DBConnection.conn.prepareStatement(quary);

				pstmUsers.executeUpdate(); // update문 실행

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
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
				if (pstmUsers != null) {
					try {
						pstmUsers.close();
					} catch (SQLException e) {
						logger.log(Level.SEVERE, "Close Fail : " + e.toString());
					}
				}
			}
		}
	
}
					
