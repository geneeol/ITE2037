public class SelectionSort {
	public static void sort(double[] a, int numberUsed)
	{
		int	index, indexOfNextSmallest;
		for (index = 0; index < numberUsed - 1; index++)
		{
			indexOfNextSmallest = indexOfNextSmallest(index, a, numberUsed);
			interchange(index, indexOfNextSmallest, a);
			// a[0] < = a[1] <= ... <= a[index] and these are the smallest
			// of the original elems. The remaining positions 
			// contatin the rest of the original array elems.
		}
	}
	private static int indexOfNextSmallest(int startIndex,
											double[] a,
											int numberUsed)
	{
		double	min = a[startIndex];
		int	indexOfMin = startIndex;
		int	index;

		for (index = startIndex + 1; index < numberUsed; index++)
		{
			if (a[index] < min)
			{
				min = a[index];
				indexOfMin = index;
			}
		}
		return (indexOfMin);
	}

	private static void interchange(int i, int j, double[] a)
	{
		double	temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
