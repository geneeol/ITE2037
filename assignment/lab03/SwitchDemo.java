import java.util.Scanner;

public class SwitchDemo {
	public static void main(String[] args) {
		Scanner	keyboard = new Scanner(System.in);

		System.out.println("Enter number of ice cream flavors:");
		int	numberOfFlavors = keyboard.nextInt();

		//h 문법 알 것!
		switch (numberOfFlavors)
		{
			case 32:
				System.out.println("Nice selection.");
				break ;
			case 1:
				System.out.println("I bet it's vanilla");
				break ;
			//case 2, 3, 4 <--- Java 표준이 아님. 아래와 같이 작성할 것
			case 2:
			case 3:
			case 4:
				System.out.println(numberOfFlavors + " flavors");
				System.out.println("is acceptable.");
				break ;
			default: 
				System.out.println("I didn't plan for");
				System.out.println(numberOfFlavors + " flavors.");
		}
	}
}
