public class Pair<T> {
	private T first;
	private T second;

	// 생성자에는 T안쓴다!, 인스턴스화할 때는 <>사용
	// <> 안에 int, double 같은 primitive type은 못씀 
	public Pair()
	{
		first = null;
		second = null;
	}

	public Pair(T firstItem, T secondItem)
	{
		first = firstItem;
		second = secondItem;
	}

	public void setFirst(T newFirst)
	{
		first = newFirst;
	}

	public void setSecond(T newSecond)
	{
		second = newSecond;
	}

	public T getFirst()
	{
		return first;
	}

	public T getSecond()
	{
		return second;
	}

	public String toString()
	{
		return ("first: " + first.toString() + "\n"
				+ "second: " + second.toString());

	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			Pair<T> otherPair = (Pair<T>)otherObject;
			return (first.equals(otherPair.first)
					&& second.equals(otherPair.second));
		}
	}
}
