import java.util.Scanner;

public class DelimiterDemo {
	public static void main(String[] args) {
		Scanner	keyboard1 = new Scanner(System.in);
		Scanner	keyboard2 = new Scanner(System.in);
		keyboard2.useDelimiter("##");

		String	word1, word2;
		System.out.println("Entter a line of text:");
		word1 = keyboard1.next();
		word2 = keyboard1.next();
		System.out.println("For keyboard1 the two words read are:");
		System.out.println(word1);
		System.out.println(word2);
		String junk = keyboard1.nextLine(); //이 줄은 개행 정크를 제거하기 위해 필수

		System.out.println("Reenter the same line of text:");
		word1 = keyboard2.next();
		word2 = keyboard2.next();
		System.out.println("For keyboard2 the two words read are: ");
		System.out.println(word1);
		System.out.println(word2);
	}
}
