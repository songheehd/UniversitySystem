package db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;


// 로그인, 로그아웃 기능
public class Access 
{
	static Logger logger = Logger.getLogger("log"); // 로그를 출력할 로그 객체

	private Access() {}
	
	// 유저 로그인
	public static User login(String id, char[] pw) 
	{
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체
		ResultSet rs = null; // 쿼리문을 날린것에 대한 반환값을 담을 객체
		String quary = null;  // 쿼리문을 저장할 변수
		User result = null; // 결과값을 저장할 변수

		String spw = String.valueOf(pw);
		
		try 
		{
			quary = "SELECT ID, PW, AUTHORITY FROM USERS";

			pstm = DBConnection.conn.prepareStatement(quary);

			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				String strId = rs.getString(1).trim();
				String strPw = rs.getString(2).trim();

				// 일치하는 유저를 찾을 시
				if (id.equals(strId) && spw.equals(strPw)) 
				{
					logger.log(Level.INFO, "로그인 성공");

					// 로그인한 정보를 유저 정보로 리턴
					result = new User(strId, strPw, rs.getString(3).trim());														
					return result;
				}
			}
			return result;
		} 
		catch (SQLException sqle) 
		{
			logger.log(Level.SEVERE, "SELECT문에서 예외 발생" + sqle.toString());
			return result;
		} 
		finally 
		{
			if (rs != null) 
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException sqle) 
				{
					logger.log(Level.SEVERE, sqle.toString());
				}
			}
			if (pstm != null) 
			{
				try 
				{
					pstm.close();
				} 
				catch (SQLException sqle) 
				{
					logger.log(Level.SEVERE, sqle.toString());
				}
			}
		}
	}
	
	// 로그아웃
	public static void logout()
	{		
		logger.log(Level.INFO, "로그아웃");
	}

}
