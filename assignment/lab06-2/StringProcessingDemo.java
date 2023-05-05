import java.util.Scanner;

public class StringProcessingDemo {
	public static void main(String[] args) {
		System.out.println("What did you eat for dinner?");
		Scanner	keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();
		sentence = Utility2.censor(sentence, "candy", "french fries", 
												"salt", "beer");
		// 아래 줄이 필요하다! (콤마를 제거하진 않았으므로)
		sentence = Utility2.censor(sentence, " ,");
		System.out.println(sentence);
	}
	// Input: I ate slat cod, broccoli, french fries, salt peanuts, and apples. 
}
