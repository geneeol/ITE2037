import java.util.Scanner;

public class GolfScores {
	public static final int MAX_NUMBER_SCORES = 10;
	public static void main(String[] args) {
		double[] scores = new double[MAX_NUMBER_SCORES];
		int numberUsed = 0;

		System.out.println("This program reads golf scores and shows");
		System.out.println("how much each differs from the average.");
		System.out.println("Enter golf scores:");
		numberUsed = fillArray(scores);
		showDifference(scores, numberUsed);
	}
	public static int fillArray(double[] a)
	{
		System.out.println("Enter up to " + a.length + " nonnegative numbers.");
		System.out.println("Mark the end of the list with a negative number.");
		Scanner keyboard = new Scanner(System.in);

		double next;
		int index;
		index = 0;
		next = keyboard.nextDouble();
		while ((next >= 0) && (index < a.length))
		{
			a[index] = next;
			index++;
			next = keyboard.nextDouble();
		}
		if (next >= 0)
			System.out.println("Could only read in " + a.length + " input values.");
		return (index);
	}
	public static double computeAverage(double[] a, int numberUsed)
	{
		double total = 0;
		for (int index = 0; index < numberUsed; index++)
			total = total + a[index];
		if (numberUsed > 0)
			return (total / numberUsed); // 이게 0일수도 있지만 출력문으로 구분
		else
		{
			System.out.println("ERROR: Trying to average 0 numbers.");
			System.out.println("computeAverage returns 0.");
			return (0);
		}
	}
	public static void showDifference(double[] a, int numberUsed)
	{
		double average = computeAverage(a, numberUsed);
		System.out.println("Average of the " + numberUsed + " scores = " + average);
		System.out.println("The scores are:");
		for (int index = 0; index < numberUsed; index++)
			System.out.println(a[index] + " differs from average by " + (a[index] - average));
	}
}
