public class CopyingDemo {
	public static void main(String[] args) {
		Sale[] a = new Sale[2];
		a[0] = new Sale("atomic coffee mug", 130.00);
		a[1] = new DiscountSale("invisible paint", 5.00, 10);
		int i;

		Sale[] b = badCopy(a);
		System.out.println("With copy constructor:");
		for (i = 0; i < a.length; i++)
		{
			System.out.println("a[" + i + "] = " + a[i]);
			System.out.println("b[" + i + "] = " + b[i]); // b[1] 출력시 discount 정보를 잃어버림
			System.out.println();
		}
		System.out.println();

		b = goodCopy(a);
		System.out.println("With clone method:");
		for (i = 0; i < a.length; i++)
		{
			System.out.println("a[" + i + "] = " + a[i]);
			System.out.println("b[" + i + "] = " + b[i]);
			System.out.println();
		}
	}

	public static Sale[] badCopy(Sale[] a)
	{
		Sale[] b = new Sale[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = new Sale(a[i]); // problem here!
		return b;
	}

	public static Sale[] goodCopy(Sale[] a)
	{
		Sale[] b = new Sale[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = a[i].clone(); // clone이 좀 더 유연하다
		return b;
	}
}
