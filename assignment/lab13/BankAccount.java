public class BankAccount {
	private class Money
	{
		private long dollars;
		private int cents;

		public Money(String stringAmount)
		{
			abortOnNull(stringAmount); // 108.99 처럼 인풋이 들어온다고 생각
			int length = stringAmount.length(); // start index, end index
			dollars = Long.parseLong(stringAmount.substring(0, length - 3)); // -> 뒤에서 세글자 제거
			cents = Integer.parseInt(stringAmount.substring(length - 2, length)); // 앞 두글자
		}

		public String getAmount()
		{
			if (cents > 9)
				return (dollars + "." + cents);
			else
				return (dollars + ".0" + cents);
		}

		public void addIn(Money secondAmount)
		{
			abortOnNull(secondAmount);
			int newCents = (cents + secondAmount.cents) % 100;
			long carry = (cents + secondAmount.cents) / 100;
			cents = newCents;
			dollars = dollars + secondAmount.dollars + carry;
		}

		private void abortOnNull(Object o)
		{
			if (o == null)
			{
				System.out.println("Unexpected null argument.");
				System.exit(0);
			}
		}
	}

	private Money balance;

	public BankAccount()
	{
		balance = new Money("0.00");
	}

	public String getBalance()
	{
		return (balance.getAmount());
	}

	public void makeDeposit(String depositAmount)
	{
		balance.addIn(new Money(depositAmount));
	}

	public void classAccount()
	{
		balance.dollars = 0;
		balance.cents = 0;
	}
}
