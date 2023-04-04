import java.util.Scanner;

public class DateSixthTry {
	private String	month;
	private int		day;
	private int		year;

	public String	toString()
	{
		return (month + " " + day + ", " + year);
	}

	// public void	writeOutput()
	// {
	// 	System.out.println("");
	// }
	public boolean	equals(DateSixthTry otherDate)
	{
		return ((month.equalsIgnoreCase(otherDate.month))
				&& (day == otherDate.day)
				&& (year == otherDate.year));
	}
	public boolean	precedes(DateSixthTry otherDate)
	{
		return ((year < otherDate.year)
				|| ((year == otherDate.year) 
						&& getMonth() < otherDate.getMonth()) // getMonth 함수는 정수 리턴
				|| ((year == otherDate.year)
						&& month.equals(otherDate.month) // 대소무시 안해도 괜찮대 
						&& day < otherDate.day));
	}

	// 인풋이 정상적인지 체크하는 기능 필요 (dateok 함수)
	// mutator 함수
	// mutator 함수가 exit하는 대신 불값을 리턴하게도 처리 가능
	public void	setDate(int month, int day, int year)
	{
		if (dateOK(month, day, year))
		{
			this.month = monthString(month); // 왼쪽 의미는 인스턴스 변수
			this.day = day;
			this.year = year;
		}
		else
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	// 오버로딩
	// 주의! 함수를 구분하는 시그니처에 "리턴 타입"은 포함되지 않는다 (생각해보면 당연)
	// 자바에서는 연산자 오버로딩을 제공하지 않는다
	public void	setDate(String monthString, int day, int year)
	{
		if (dateOK(monthString, day, year))
		{
			this.month = monthString;
			this.day = day;
			this.year = year;
		}
		else
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	//
	public void	setDate(int year)
	{
		setDate(1, 1, year);
	}

	/*
	public boolean	setMonth(int monthNumber)
	{

	}
	*/
	
	// 유저가 해당 클래스를 콜할 때
	// while (!date.setMonth(number)) 반복가능

	public void	setMonth(int monthNumber)
	{
		if (monthNumber <= 0 || monthNumber > 12)
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
		else
			month = monthString(monthNumber);
	}

	public void	setDay(int day)
	{
		if (day <= 0 || day > 31)
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
		else
			this.day = day;
	}

	public void	setYear(int year)
	{
		if (year < 1000 || year > 9999)
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
		else
			this.year = year;
	}


	public String monthString(int monthNumber)
	{
		switch (monthNumber)
		{
			case 1: 
				return ("January");
			case 2:
				return ("February");
			case 3:
				return ("March");
			case 4:
				return ("April");
			case 5:
				return ("May");
			case 6:
				return ("June");
			case 7:
				return ("July");
			case 8:
				return ("August");
			case 9:
				return ("September");
			case 10:
				return ("October");
			case 11:
				return ("November");
			case 12:
				return ("December");
			default:
				System.out.println("Fatal Error");
				System.exit(0);
				return ("Error"); // To make compiler happy ^_^
		}
	}

	public void	writeOutput()
	{
		System.out.println(month + " " + day + ", " + year);
	}

	// 이전 버전에서 일부 수정됨
	public void	readInput()
	{
		boolean	trayAgain = true;
		Scanner	keyboard = new Scanner(System.in);

		while (trayAgain)
		{
			System.out.println("Enter month, day, and year.");
			System.out.println("as three integers:");
			System.out.println("Do not use a comma.");
			int	monthInput = keyboard.nextInt();
			int	dayInput = keyboard.nextInt();
			int	yearInput = keyboard.nextInt();
			if (dateOK(monthInput, dayInput, year))
			{
				setDate(monthInput, dayInput, yearInput);
				trayAgain = false;
			}
			else
				System.out.println("Illegal date. Reenter input.");
		}
	}

	public int	getDay()
	{
		return (day);
	}
	
	public int	getYear()
	{
		return (year);
	}

	public int	getMonth()
	{
		if (month.equalsIgnoreCase("January"))
			return (1);
		else if (month.equalsIgnoreCase("February"))
			return (2);
		else if (month.equalsIgnoreCase("March"))
			return (3);
		else if (month.equalsIgnoreCase("April"))
			return (4);
		else if (month.equalsIgnoreCase("May"))
			return (5);
		else if (month.equalsIgnoreCase("June"))
			return (6);
		else if (month.equalsIgnoreCase("July"))
			return (7);
		else if (month.equalsIgnoreCase("August"))
			return (8);
		else if (month.equalsIgnoreCase("September"))
			return (9);
		else if (month.equalsIgnoreCase("October"))
			return (10);
		else if (month.equalsIgnoreCase("November"))
			return (11);
		else if (month.equalsIgnoreCase("December"))
			return (12);
		else
		{
			System.out.println("Fatal Error");
			System.exit(0);
			return (0); // 컴파일러를 위해 넣는 줄
		}
	}

	private boolean dateOK(int monthInt, int dayInt, int yearInt)
	{
		return ((monthInt >= 1) && (monthInt <= 12)
				&& (dayInt >= 1) && (dayInt <= 31)
				&& (yearInt >= 1000) && (yearInt <= 9999));
	}

	private boolean	dateOK(String monthString, int dayInt, int yearInt)
	{
		return (monthOK(monthString)
				&& (dayInt >= 1) && (dayInt <= 31)
				&& (yearInt >= 1000) && (yearInt <= 9999));
	}

	private boolean	monthOK(String month)
	{
		return (month.equals("January") || month.equals("February")
				|| month.equals("March") || month.equals("April")
				|| month.equals("May") || month.equals("June")
				|| month.equals("July") || month.equals("August")
				|| month.equals("September") || month.equals("October")
				|| month.equals("November") || month.equals("December"));
	}
}
