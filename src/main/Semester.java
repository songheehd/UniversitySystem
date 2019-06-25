package main;

public enum Semester 
{
	SEMESTER, S1801, S1802;

	public String toString() 
	{
		switch (this) 
		{
			// 현재 학기
			case SEMESTER:
				return "18-2";
			case S1801:
				return "18-1";
			case S1802:
				return "18-2";
			default:
				return "unspecified";
		}
	}
}
