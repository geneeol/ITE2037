public class ComparableDemo {
	public static void main(String[] args) {
		// 수정전
		// double[] b = {7.7, 5.5, 11, 3, 16, 4.4, 20, 14, 13, 42};
		Double[] d = new Double[10];
		
		for (int i = 0; i < d.length; i++)
			// d[i] = new Double(d.length - i); //이걸 바꾸재
			d[i] = Double.valueOf(d.length - i); //생성자 사용하는 위 방법보다 이게 낫대.

		System.out.println("Before sorting:");
		
		int	i;
		for (i = 0; i < d.length; i++)
			System.out.print(d[i].doubleValue() + " ");
		System.out.println();

		GeneralizedSelectionSort.sort(d, d.length);

		System.out.println("Sorted array values:");
		for (i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();

		// 문자 정렬
		String[] a = new String[10];
		a[0] = "dog";
		a[1] = "cat";
		a[2] = "cornish game hen";
		int numberUsed = 3;

		System.out.println("Before sorting");
		for (i = 0; i < numberUsed; i++)
			System.out.print(a[i] + ", ");
		System.out.println();
		GeneralizedSelectionSort.sort(a, numberUsed);
		System.out.println("After sorting");
		for (i = 0; i < numberUsed; i++)
			System.out.print(a[i] + ", ");
		System.out.println();
	}
	
}
