import java.util.Scanner;

public class Date {
	private String	month;
	private int		day;
	private int		year;

	public String	toString()
	{
		return (month + " " + day + ", " + year);
	}

	public boolean	equals(Date otherDate)
	{
		return ((month.equals(otherDate.month))
				&& (day == otherDate.day)
				&& (year == otherDate.year));
	}
	public boolean	precedes(Date otherDate)
	{
		return ((year < otherDate.year)
				|| ((year == otherDate.year) 
						&& getMonth() < otherDate.getMonth()) // getMonth 함수는 정수 리턴
				|| ((year == otherDate.year)
						&& month.equals(otherDate.month) 
						&& day < otherDate.day));
	}

	public void	setDate(int newMonth, int newDay, int newYear)
	{
		month = monthString(newMonth);
		day = newDay;
		year = newYear;
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
	public void	readInput()
	{
		Scanner	keyboard = new Scanner(System.in);
		System.out.println("Enter month, day, and year.");
		System.out.println("Do not use a comma.");
		month = keyboard.next();
		day = keyboard.nextInt();
		year = keyboard.nextInt();
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
}
