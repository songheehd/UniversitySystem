package main;

public enum Grade 
{
	A, B, C, D, F, UNSPECIFIED;

	public String toString() 
	{
		switch (this) 
		{
			// 성적
			case A:
				return "A";
			case B:
				return "B";
			case C:
				return "C";
			case D:
				return "D";
			case F:
				return "F";
			default:
				return "평가중";
		}
	}
}
