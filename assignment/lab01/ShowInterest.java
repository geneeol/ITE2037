// package assignment.lab01;

public class ShowInterest {
	public static final double	INTEREST_RATE = 2.5; // public static final 키워드 알 것
	public static void	main(String[] args)
	{
		double	balance = 100;
		double	interest = balance * (INTEREST_RATE / 100.0);

		System.out.println("On a balance of $" + balance);
		System.out.println("you will earn interest of $" + interest);
		System.out.println("All in just one short year.");
	}
	
}
