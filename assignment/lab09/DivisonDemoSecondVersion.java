import java.util.Scanner;

/**
 * DivisonDemoFirstVersion
 */
public class DivisonDemoSecondVersion {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		try
		{
			System.out.println("Enter numerator:");
			int numerator = keyboard.nextInt();
			System.out.println("Enter denominator:");
			int denominator = keyboard.nextInt();

			double quotient = safeDivide(numerator, denominator);
			System.out.println(numerator + "/" + denominator + " = " + quotient);
		}
		catch (DivisionByZeroException e)
		{
			System.out.println(e.getMessage());
			secondChance();
		}
		System.out.println("End of program");
	}

	// , 로 exception 클래스 추가 가능.
	// catch가 일어나지 않으면 메서드 호출 즉시 종료
	public static double safeDivide(int top, int bottom) throws DivisionByZeroException
	{
		if (bottom == 0)
			throw new DivisionByZeroException();
		return top / (double)bottom;
	}

	// TODO: 9-2강 16분 57초 다시 듣자
	public static void secondChance()
	{
		Scanner keyboard = new Scanner(System.in);

		try
		{
			System.out.println("Enter numerator:");
			int numerator = keyboard.nextInt();
			System.out.println("Enter denominator:");
			int denominator = keyboard.nextInt();
			
			double quotient = safeDivide(numerator, denominator);
			System.out.println(numerator + "/" + denominator + " = " + quotient);
		}
		catch (DivisionByZeroException e)
		{
			System.out.println("I cannot do division by zero.");
			System.out.println("Aborting program.");
			System.exit(0);
		}
	}
}	