package lab00;
public class Java1st5th {
	public static void main(String[] args) {
		String	greeting = "elloHello";
		String	greeting2 = "Good morning";	
		boolean	check = greeting.toUpperCase().equals(greeting2.toUpperCase());
		// boolean	check = "Hello".equalsIgnoreCase(("hello"));
		int	count = greeting.length();
		System.out.println("Length is " + count);
		System.out.println(greeting.substring(2)); // 2번 인덱스부터 끝까지
		System.out.println(greeting.lastIndexOf("llo")); // 마지막 llo 시작 인덱스 (l인덱스j)
		System.out.println(greeting.substring(1,3)); // [1, 3) 인겍스
		System.out.println(greeting.charAt(2)); // 해당 인덱스 위치의 문자 반환
		System.out.println(greeting);
		System.out.println(greeting.toUpperCase());
		System.out.println(greeting.toLowerCase());

		System.out.println(greeting.compareTo(greeting2)); // strcmp와 유사, 소문자가 더 사전식 빠름
	}
}
