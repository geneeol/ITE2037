package assignment.lab01;

public class StringProcessDemo
{
	public static void	main(String[] args)
	{
		String	str = "I hate text processing!";
		int		pos = str.indexOf("hate");
		String	end = str.substring(pos + "hate".length());
		String	str2 = str.substring(0, pos) + "adore" + end;

		System.out.println("01234567890123456789012");
		System.out.println("The word \"hate\" starts at index " + pos);
		System.out.println(str);
		System.out.println("The changed string is:");
		System.out.println(str2);
	}
	
}
