public class GeneralizedSelectionSort {
	//h Comparable 타입으로 변경
	public static void sort(Comparable[] a, int numberUsed)
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
											Comparable[] a,
											int numberUsed)
	{
		Comparable	min = a[startIndex];
		int	indexOfMin = startIndex;
		int	index;

		for (index = startIndex + 1; index < numberUsed; index++)
		{
			if (a[index].compareTo(min) < 0)
			{
				min = a[index];
				indexOfMin = index;
			}
		}
		return (indexOfMin);
	}

	private static void interchange(int i, int j, Comparable[] a)
	{
		Comparable	temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
