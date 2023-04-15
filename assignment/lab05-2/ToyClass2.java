//package lab05-2;

public class ToyClass2 {
	private String	name;
	private int		number;

	public ToyClass2(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public ToyClass2()
	{
		name = "No name yet.";
		number = 0;
	}
	
	public void set(String name, int number)
	{
		this.name = name;
		this.number = number;
	}

	public String toString()
	{
		return (name + " " + number);
	}

	public void makeEqual(ToyClass2 anObject)
	{
		anObject.name = this.name;
		anObject.number = this.number;
	}

	public void tryToMakeEqual(int aNumber)
	{
		aNumber = this.number;
	}

	public static void changer(ToyClass2 aParameter)
	{
		aParameter.name = "Hot Shot";
		aParameter.number = 42;
	}

	public boolean equals(ToyClass2 otherObject)
	{
		return (name.equals(otherObject.name)
				&& number == otherObject.number);
	}
}
