import java.util.Scanner;

/**
 * EnumSwitchDemo
 */
public class EnumSwitchDemo {
	enum Flavor {VANILLA, CHOCOLATE, STRAWBERRY};

	public static void main(String[] args) {
		Flavor favorite = null;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your favorite flavor?");
		// input PISTACHIO 입력시 에러 발생. exception!
		String answer = keyboard.next();
		answer = answer.toUpperCase(); // (완벽히 모든 글자가 같아야해서 대문자로 바꿈)
		favorite = Flavor.valueOf(answer); // 여기서 input 피스타치오 입력시 에러발생

		switch (favorite)
		{
			case VANILLA:
				System.out.println("Classic");
				break ;
			case CHOCOLATE:
				System.out.println("Rich");
				break;
			default:
				System.out.println("I bet you said STRAWBERRY");
				break ;
		}
	}
}