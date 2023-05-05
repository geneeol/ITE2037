public class ToyExample {
	private Date[]	a;

	public ToyExample(int arraySize)
	{
		a = new Date[arraySize];
		for (int i = 0; i < arraySize; i++)
			a[i] = new Date();
	}

	public ToyExample(ToyExample object)
	{
		int	lengthOfArrays = object.a.length;
		this.a = new Date[lengthOfArrays]; // 배열 자체도 딥카피
		for (int i = 0; i < lengthOfArrays; i++)
			this.a[i] = new Date(object.a[i]); // 각 오브젝트도 딥카피
	}

	public Date[] getDateArray()
	{
		Date[]	temp = new Date[a.length];
		for (int i = 0; i < a.length; i++)
			temp[i] = new Date(a[i]); // 각 오브젝트도 딥카피
		return (temp);
	}
}
