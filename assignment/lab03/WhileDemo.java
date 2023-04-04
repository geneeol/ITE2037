public class WhileDemo {
	public static void main(String[] args) {
		int	countDown;

		System.out.println("First While loop");
		countDown = 3;
		while (countDown > 0)
		{
			System.out.println("Hello");
			countDown = countDown - 1;
		}
		System.out.println("Second while loop:");
		countDown = 0;
		while (countDown > 0)
		{
			System.out.println("Hello");
			countDown = countDown - 1;
		}
		System.out.println("First do-while loop:");
		countDown = 3;
		do
		{
			System.out.println("Hello");
			countDown = countDown - 1;
		} while (countDown > 0);
		System.out.println("Second do-while loop:");
		countDown = 0;
		// do while은 루프 바디를 최소한 한 번은 실행한다.
		do
		{
			System.out.println("Hello");
			countDown = countDown - 1;
		} while (countDown > 0);

		
	}
	
}
