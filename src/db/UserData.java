package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserData 
{
	static Logger logger = Logger.getLogger("log");  // 로그를 출력할 로그 객체
    
	private UserData() {}
	
	// DB에서 이름을 가져오는 기능
	public static String getName(String id)
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체
		ResultSet rs = null; // 쿼리문을 날린것에 대한 반환값을 담을 객체
		String quary = null; // 쿼리문을 저장할 변수
		String result = null; // 결과값을 저장할 변수

		try 
		{
			String table = null;
			String column = null;

			// 유저의 타입에 따라 데이터를 가져올 테이블 지정
			switch (id.charAt(0)) 
			{
				case 'S':
					table = "STUDENTS";
					column = "STDNO";
					break;
				case 'P':
					table = "PROFESSORS";
					column = "PROFNO";
					break;
				case 'H':
				case 'G':
					table = "EMPLOYEES";
					column = "EMPNO";
					break;
				default:
					break;
			}

			// DB에서 실행할 sql 쿼리문을 스트링으로 만든다
			quary = String.format("SELECT NAME FROM %s WHERE %s = '%s'", table, column, id);

			// DB의 sql문 형태의 변수 pstm에 쿼리문을 나타내는 스트링을 대입한다
			pstm = DBConnection.conn.prepareStatement(quary);

			// DB에서 pstm에 대입된 sql문을 실행한 결과를 rs로 가져온다
			rs = pstm.executeQuery();

			// 결과로 나온 rs의 레코드 배열을 하나씩 돌린다
			while (rs.next()) 
			{		
				// 결과를 저장한다
				result = rs.getString("NAME");
			}

		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SQL문에서 예외 발생 : " + sqle.toString());
		} 
		finally 
		{
			// rs와 pstm을 close한다
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

	// 비밀번호 변경 기능
	public static boolean changePw(String id, String newPw)
	{
		PreparedStatement pstm = null; 
		String quary = null; 
		
		try 
		{
			// USERS 테이블에서 id와 일치하는 유저의 비밀번호를 업데이트 
			quary = String.format("UPDATE USERS SET PW = '%s' WHERE ID = '%s'", newPw, id); 

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
}
