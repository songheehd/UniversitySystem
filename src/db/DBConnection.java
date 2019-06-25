package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


// 데이터베이스 연결 관련 기능
public class DBConnection 
{	
	static Connection conn;  // DB연결된 상태(세션)을 담은 객체   
	static Logger logger = Logger.getLogger("log");
	
	private DBConnection() {}	
	
	
	// 데이터베이스와 연결
	public static void connect()  
	{
		// Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
		// java 표준인 java.sql.Connection 클래스를 import해야 한다.
		try 
		{
			// 연결하기
			// 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
			// Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
			// mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
			String user = "b20143262";
			String pw = "20143262";
			String url = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl";
			
			
			// 1. 드라이버 로딩
			// 드라이버 인터페이스를 구현한 클래스를 로딩
			// mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
			// mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
			// 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.		
			
			// @return Connection
			// 연결 세션을 받아옴
			conn = DriverManager.getConnection(url, user, pw);
			
			logger.log(Level.INFO, "Database에 연결되었습니다.\n");
		} 
		catch (SQLException sqle) 
		{			
			logger.log(Level.SEVERE, "DB 접속실패 : " + sqle.toString());
		} 
		catch (Exception e) 
		{										
			logger.log(Level.SEVERE, "Unkonwn error : " + e.toString());
		}
	}
	
	// 데이터베이스와 연결 종료
	public static void close(Connection conn)
	{
		try 
		{
			conn.close();
			logger.log(Level.INFO, "Database와 연결이 종료되었습니다.\n");
		} 
		catch (SQLException e) 
		{			
			logger.log(Level.INFO, e.toString());
		}
	}
	
	// 데이터베이스와의 연결 세션 반환
	public static Connection getConnection()
	{
		return conn;
	}
}
