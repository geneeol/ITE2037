public class Java1st5th {
	public static void main(String[] args) {
		String	greeting = "elloHello";
		String	greeting2 = "Good morning";	
		boolean	check = greeting.toUpperCase().equals(greeting2.toUpperCase());
		//boolean	check = "Hello".equalsIgnoreCase(("hello"));
		int	count = greeting.length();
		System.out.println("Length is " + check);
		//System.out.println(greeting.substring(2));
		//System.out.println(greeting.lastIndexOf("llo"));
		//System.out.println(greeting.substring(1,3));
		//System.out.println(greeting.charAt(2));
		//System.out.println(greeting);
		// System.out.println(greeting.toUpperCase());
		// System.out.println(greeting.toLowerCase());

		System.out.println(greeting.compareTo(greeting2));
	}
}
