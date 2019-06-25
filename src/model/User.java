package model;

import java.io.Serializable;
import java.util.Vector;

import db.Access;
import db.UserData;


// 로그인한 유저를 나타내는 클래스

@SuppressWarnings({ "serial", "rawtypes" })
public class User extends Vector implements Serializable
{
	protected String id;
	protected String pw;
	protected String authority;

	
	public User() {}
	
	public User(String id, String pw, String authority)
	{
		this.id = id;
		this.pw = pw;
		this.authority = authority;
	}
	
	// 유저 로그인
	public boolean login(String id, char[] pw)
	{
		User loginUser = Access.login(id, pw);
		
		// 로그인을 성공한 유저값을 받았을 때		
		if(loginUser != null)
		{
			// 로그인한 유저 정보를 받음
			this.id = loginUser.id;
			this.pw = loginUser.pw;
			this.authority = loginUser.authority;
			
			return true;
		}
		// 로그인이 실패하고 유저값이 null 일 때
		else
		{
			return false;
		}				
	}
	
	// 유저 로그아웃
	public void logout()
	{
		Access.logout();
	}
				
	// 비밀번호 변경
	public String changePw(char[] nowPw, char[] newPw, char[] newPwConfirm)
	{
		// char 배열형을 String 형으로 변환
		String strNowPw = String.valueOf(nowPw);
		String strNewPw = String.valueOf(newPw);
		String strNewPwConfirm = String.valueOf(newPwConfirm);
		
		if(pw.equals(strNowPw))
		{
			// 비밀번호가 맞을 때
			if(strNewPw.equals(strNewPwConfirm))
			{
				// 새 비밀번호와 새 비밀번호 확인이 일치할 때
				if(UserData.changePw(id, strNewPw)) 
				{
					// DB업데이트 성공 시
					pw = strNewPw;
					return "sucess";
				}
				else
				{
					// DB업데이트 실패 시
					return "update error";
				}				
			}
			else
			{
				// 불일치 할 때
				return "confirm error";
			}						
		}
		else
		{
			// 비밀번호가 틀렸을 때
			return "pw error";
		}
	}
	
	public String getPw() 
	{
		return pw;
	}

	public String getId() 
	{
		return id;
	}

	public String getAuthority() 
	{
		return authority;
	}
	
	public String getName()
	{
		String name = UserData.getName(id);			
		return name;
	}
	
	public void setPw(String pw) 
	{
		this.pw = pw;
	}
	
}
