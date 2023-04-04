import java.util.Scanner;

public class DateSecondTry {
	private String	month;
	private int		day;
	private int		year;

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
		else
		{
			System.out.println("Fatal Error");
			System.exit(0);
			return (0); // 컴파일러를 위해 넣는 줄
		}
		/*
		 * 다른 월들도 다 넣기
		 */
	}
	
}
