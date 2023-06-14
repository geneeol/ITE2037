import java.util.Scanner;

public class GenericPairDemo {
	public static void main(String[] args) {
		// Pair<String> secretPair = new Pair<String>("Happy", "Day");
		// var 쓰면 자동으로 타입 찾음
		var secretPair = new Pair<String>("Happy", "Day");

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter two words");
		String word1 = keyboard.next();
		String word2 = keyboard.next();
		Pair<String> inputpair = new Pair<String>(word1, word2);
		if (inputpair.equals(secretPair))
		{
			System.out.println("You guessed the secret words!");
			System.out.println("in the correct order!");
		}
		else
		{
			System.out.println("You guessed incorrectly.");
			System.out.println("You guessed");
			System.out.println(inputpair);
			System.out.println("The secret words are");
			System.out.println(secretPair);
		}
	}
}
