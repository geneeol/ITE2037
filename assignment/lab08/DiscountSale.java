public class DiscountSale extends Sale {
	private double discount;

	public DiscountSale()
	{
		super(); // 이 라인 생략되어도 동일한 의미를 갖는다
		discount = 0;
	}

	/**
	 * precondition: theName is a nonempty string; thePrice is nonnegative;
	 * theDiscount is expressed as a percent of the price and is nonnegative.
	 */
	public DiscountSale(String theName, double thePrice, double theDiscount)
	{
		super(theName, thePrice);
		setDiscount(theDiscount);
	}

	public DiscountSale(DiscountSale originalObject)
	{
		super(originalObject); // 업캐스팅
		discount = originalObject.discount;
	}

	public static void announcement()
	{
		System.out.println("This is the DiscountSale class.");
	}

	public double bill()
	{
		double fraction = discount / 100;
		return ((1 - fraction) * getPrice());
	}

	public double getDiscount()
	{
		return discount;
	}

	public void setDiscount(double newDiscount)
	{
		if (newDiscount >= 0)
			discount = newDiscount;
		else
		{
			System.out.println("Error: Negative discount.");
			System.exit(0);
		}
	}

	public String toString()
	{
		return (getName() + " Price = $" + getPrice()
				+ " Discount = " + discount + "%\n"
				+ " Total cost = $" + bill());
	}

	// 오버라이딩 돼야하지만 여기서 중요하지 않으므로 스킵한대
	//public boolean equals(Object otherObject)

	public DiscountSale clone()
	{
		return (new DiscountSale(this));
	}
}
