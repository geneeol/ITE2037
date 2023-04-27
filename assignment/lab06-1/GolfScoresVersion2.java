import java.util.Scanner;

public class GolfScoresVersion2 {
	public static final int MAX_NUMBER_SCORES = 10;
	public static void main(String[] args) {
		PartiallyFilledArray score = new PartiallyFilledArray(MAX_NUMBER_SCORES);

		System.out.println("This program reads golf scores and shows");
		System.out.println("how much each differs from the average.");
		System.out.println("Enter golf scores:");
		fillArray(score);
		showDifference(score);
	}
	public static void fillArray(PartiallyFilledArray a)
	{
		System.out.println("Enter up to " + a.getMaxCapacity() + " nonnegative numbers.");
		System.out.println("Mark the end of the list with a negative number.");
		Scanner keyboard = new Scanner(System.in);

		double next = keyboard.nextDouble();
		while ((next >= 0) && !a.full())
		{
			a.add(next);
			next = keyboard.nextDouble();
		}
		if (next >= 0)
			System.out.println("Could only read in " + a.getMaxCapacity() + " input values.");
	}

	public static double computeAverage(PartiallyFilledArray a)
	{
		double total = 0;
		// a.getNumberofElements가 매번 호출됨
		// 따라서 변수를 만들어서 이 값을 저장해두고 쓰는 것이 권장됨
		double numberOfElementsIna = a.getNumerOfElements();
		for (int index = 0; index < numberOfElementsIna; index++)
			total = total + a.getElement(index);
		if (numberOfElementsIna > 0)
			return (total / numberOfElementsIna); // 이게 0일수도 있지만 출력문으로 구분
		else
		{
			System.out.println("ERROR: Trying to average 0 numbers.");
			System.out.println("computeAverage returns 0.");
			return (0);
		}
	}
	public static void showDifference(PartiallyFilledArray a)
	{
		double average = computeAverage(a);
		double numberOfElementsIna = a.getNumerOfElements();
		System.out.println("Average of the " + numberOfElementsIna + " scores = " + average);
		System.out.println("The scores are:");
		for (int index = 0; index < numberOfElementsIna; index++)
			System.out.println(a.getElement(index) + " differs from average by " 
								+ (a.getElement(index)- average));
	}
}
