import java.util.Scanner;

public class VariableParameterDemo {
	public static void main(String[] args) {
		System.out.println("Enter scores for Tom, Dick and Harriet:");
		Scanner keyboard = new Scanner(System.in);
		int	tomsScore = keyboard.nextInt();
		int	dicksScore = keyboard.nextInt();
		int	harrietScore = keyboard.nextInt();

		int	highestScore = UtilityClass.max(tomsScore, dicksScore, harrietScore, 4000);
		System.out.println("Highest score = " + highestScore);
		
	}
}
