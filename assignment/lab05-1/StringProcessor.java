import java.util.Scanner;

public class StringProcessor {
	public static void main(String[] args) {
		Scanner	keyboard = new Scanner(System.in);
		String	str;
		char	firstCharacter;

		System.out.println("Enter a one line sentence:");
		str = keyboard.nextLine();
		str = str.toLowerCase();
		firstCharacter = str.charAt(0);
		str = Character.toUpperCase(firstCharacter) + str.substring(1);

		System.out.println("The revised sentence is:");
		System.out.println(str);

	}
	
}
