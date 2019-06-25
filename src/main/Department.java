package main;

public enum Department {

	COMPUTATIONAL, ELECTRONIC, CHEMISTRY, MACHINE, AIRLINE;
	
	public String toString() 
	{
		switch (this) 
		{
			// 현재 학기
			case COMPUTATIONAL:
				return "전산학과";
			case ELECTRONIC:
				return "전자공학과";
			case CHEMISTRY:
				return "화학공학과";
			case MACHINE:
				return "기계공학과";
			case AIRLINE:
				return "항공우주공학과";
			default:
				return "학과가 없습니다.";
		}
	}
}
