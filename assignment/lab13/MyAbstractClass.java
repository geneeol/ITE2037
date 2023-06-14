//h abstraact 키워드
public abstract class MyAbstractClass implements Ordered {
	private int number;
	private char grade;

	public boolean precedes(Object other)
	{
		if (other == null)
			return (false);
		// else if (!(other instanceof HourlyEmployee)) 강의안
		// else if (!(other instanceof MyAbstract)) 교수님 
		// - > 강의안 오류인듯 
		else if (!(other instanceof MyAbstractClass))
			return (false);
		else
		{
			MyAbstractClass otherMyAbstrctClass =
				(MyAbstractClass)other;
			return (this.number < otherMyAbstrctClass.number);
		}

		public abstract boolean follows(Object other);
	}
}
