public class OrderedHourlyEmployee
	extends HourlyEmployee implements Ordered
{
	public boolean precedes(Object other)
	{
		if (other == null)
			return (false);
		else if (!(other instanceof OrderedHourlyEmployee))
			return (false);
		else
		{
			OrderedHourlyEmployee otherOrderedHourlyEmployee =
				(OrderedHourlyEmployee)other;
			return (getPay() < otherOrderedHourlyEmployee.getpay());
		}
	}

	public boolean follows(Object other)
	{
		if (other == null)
			return (false);
		else if (!(other instanceof OrderedHourlyEmployee))
			return (false);
		else
		{
			OrderedHourlyEmployee otherOrderedHourlyEmployee =
				(OrderedHourlyEmployee)other;
			return (otherOrderedHourlyEmployee.precedes(this));
		}
	}
}
		