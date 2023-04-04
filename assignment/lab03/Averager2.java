import java.util.Scanner;
import java.util.zip.Inflater;

public class Averager2 {
	public static void main(String[] args) {
		Scanner	keyboard = new Scanner(System.in);
		int		n;

		System.out.println("Enter the number of nonnegative scores.");
		n = keyboard.nextInt();
		System.out.println("Enter a list of " + n + " nonnegative scores.");
		System.out.println("I will compute their average.");

		double	sum = 0;
		double	next;
		int		i;

		for (i = 0; i < n; i++)
		{
			next = keyboard.nextDouble();
			sum += next;
		}

		if (i == 0)
			System.out.println("No scores entered");
		else
		{
			double	average = sum / n;
			System.out.println("The average is " + average);
		}
		
	}
}
