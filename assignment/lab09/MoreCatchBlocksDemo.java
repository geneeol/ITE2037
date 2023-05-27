import java.util.Scanner;

public class MoreCatchBlocksDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		try
		{
			System.out.println("How many pencils do you have?");
			int pencils = keyboard.nextInt();

			if (pencils < 0)
			{
				// 이 부분 인자로 정수 보낼 수 있음.
				throw new NegativeNumberException(pencils);
			}

			System.out.println("How many erasers do you have?");

			int erasers = keyboard.nextInt();
			double pencilsPerEraser;

			if (erasers < 0)
				throw new NegativeNumberException("erasers");
			else if (erasers != 0)
				pencilsPerEraser = pencils / (double)erasers;
			else
				throw new DivisionByZeroException();
			System.out.println("Each eraser must last through " + pencilsPerEraser + " pencils.");
		} // catch 블락  순서가 중요하다! 먼저 캐치된 부분이 실행됨.
		// catch (Exception e)가 캐치블락 제일 앞에 오면 아래 캐치블락에 도달하지 못함
		catch(NegativeNumberException e)
		{
			// 정수면 accessor로 접근
			System.out.println("Cannot have negative number of " + e.getNegativeNumber());
		}
		catch (DivisionByZeroException e)
		{
			System.out.println("Do not make any mistakes.");
		}
		System.out.println("End of program.");
	}
}
