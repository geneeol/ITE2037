public class invocationCounter {
	private static int	numberOfInvocations = 0;

	public void	demoMethod()
	{
		numberOfInvocations++;
	}

	public void	outPutCount()
	{
		numberOfInvocations++;
		System.out.println("Number of invocations so far = " + numberOfInvocations);
	}

	public static int	numberSoFar()
	{
		numberOfInvocations++;
		return (numberOfInvocations);
	}

	public static void main(String[] args) {
		int	i;
		invocationCounter	object1 = new invocationCounter();
		for (i = 1; i <= 5; i++)
			object1.demoMethod(); 
		object1.outPutCount(); // ppt에 인덴테이션 이상한 부분 있대
		invocationCounter	object2 = new invocationCounter();
		for (i = 1; i <= 5; i++)
		{
			object2.demoMethod();
			object2.outPutCount();
		}
		System.out.println("Total number of invocations = " + numberSoFar());

	}
}
