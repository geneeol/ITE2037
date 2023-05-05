public class UtilityClass {
	public static int max(int ... arg) // 가변인자 받는 법인듯
	{
		if (arg.length == 0)
		{
			System.out.println("Fatal Error: maximum of zero values.");
			System.exit(0);
		}

		int	largest = arg[0];
		for (int i = 1; i < arg.length; i++)
			if (arg[i] > largest)
				largest = arg[i];
		return (largest);
	}
}
