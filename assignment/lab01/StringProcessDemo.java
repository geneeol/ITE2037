// package assignment.lab01;

public class StringProcessDemo
{
	public static void	main(String[] args)
	{
		String	str = "I hate text processing!";
		int		pos = str.indexOf("hate"); //h indexOf 함수
		String	end = str.substring(pos + "hate".length()); //h 서브스트링함수 사용법
		String	str2 = str.substring(0, pos) + "adore" + end; // 이거 걍 외워

		System.out.println("01234567890123456789012");
		System.out.println("The word \"hate\" starts at index " + pos);
		System.out.println(str);
		System.out.println("The changed string is:");
		System.out.println(str2);
	}
	
}
