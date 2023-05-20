public class Sale {
	private String name;
	private double price;

	public Sale()
	{
		name = "No name yet";
		price = 0;
	}

	public Sale(String theName, double thePrice)
	{
		setName(theName);
		setPrice(thePrice);
	}

	public Sale(Sale originalObject)
	{
		if (originalObject == null)
		{
			System.out.println("Error: null Sale object.");
			System.exit(0);
		}
		name = originalObject.name;
		price = originalObject.price;
	}

	public static void announcement()
	{
		System.out.println("This is the Sale class.");
	}

	public double getPrice()
	{
		return (price);
	}

	public void setPrice(double newPrice)
	{
		if (newPrice >= 0)
			price = newPrice;
		else
		{
			System.out.println("Error: Negative price.");
			System.exit(0);
		}
	}

	public String getName()
	{
		return (name);
	}

	public void setName(String newName)
	{
		if (newName != null && newName != "")
			name = newName;
		else
		{
			System.out.println("Error: Improper name value.");
			System.exit(0);
		}
	}

	public String toString()
	{
		return (name + " Prcie and total cost = $" + price);
	}

	public double bill()
	{
		return price;
	}

	public boolean equalsDeals(Sale otherSale)
	{
		if (otherSale == null)
			return false;
		else
			return (name.equals(otherSale.name) && bill() == otherSale.bill());
		// bill()을 호출해서 late binding에서 사용될 수 있다?
	}

	public boolean lessThan(Sale otherSale)
	{
		if (otherSale == null)
		{
			System.out.println("Error: null Sale object.");
			System.exit(0);
			return false;
		}
		return (bill() < otherSale.bill());
	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		// 바로 아래줄 다운 캐스팅 가능한지 아닌지 따지는 거 아주 중요하대!
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			// 아래 다운캐스팅 반드시 필요!
			// Object에는 name, price 인스턴스 변수가 없으므로
			Sale otherSale = (Sale)otherObject;
			return (name.equals(otherSale.name) && (price == otherSale.price));
		}
	}

	public Sale clone()
	{
		return (new Sale(this));
	}
}
