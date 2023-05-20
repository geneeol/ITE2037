public class HourlyEmployee extends Employee {
	private double wageRate;
	private double hours;

	public HourlyEmployee()
	{
		super(); // 생략할 수 있다. (no arg 생성자가 어차피 자동으로 호출되므로)
		wageRate = 0;
		hours = 0;
	}

	public HourlyEmployee(String theName, Date theDate,
							double theWageRate, double theHours)
	{
		super(theName, theDate);
		if (theWageRate >= 0 && theHours >= 0)
		{
			wageRate = theWageRate;
			hours = theHours;
		}
		else
		{
			System.out.println("Fatal Error: creating an illegal hourly employee.");
			System.exit(0);
		}
	}

	public HourlyEmployee(HourlyEmployee originalObject)
	{
		// Employee(Eployee originalobject) -> 상속받은 클래스라 아래 문법 합법 ^_^
		super(originalObject);
		wageRate = originalObject.wageRate;
		hours = originalObject.hours;
	}

	public double getRate()
	{
		return wageRate;
	}

	public double getHours()
	{
		return hours;
	}

	public double getPay()
	{
		return wageRate * hours;
	}

	public void setHours(double hoursWorked)
	{
		if (hoursWorked >= 0)
			hours = hoursWorked;
		else
		{
			System.out.println("Fatal Error: Negative hours worked.");
			System.exit(0);
		}
	}

	public void setRate(double newWageRate)
	{
		if (newWageRate >= 0)
			wageRate = newWageRate;
		else
		{
			System.out.println("Fatal Error: Negative wage rate.");
			System.exit(0);
		}
	}

	public String toString()
	{
		// getHireDate().toString()으로 호출해야한다!
		// 아래는 틀린 방법.
		// name + " "+ hireDate.toString() + ... 프라이빗 인스턴스라 이렇게 하면 틀리다. 
		return (getName() + " " + getHireDate().toString()
				+ "\n$" + wageRate + " per hour for " + hours + " hours");
	}

	public boolean equals(HourlyEmployee other)
	{
		return (getName().equals(other.getName())
				&& getHireDate().equals(other.getHireDate())
				&& wageRate == other.wageRate
				&& hours == other.hours);
	}
	// public boolean equals(Object otherObject) 추가할 것

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			HourlyEmployee otherHourlyEmployee = (HourlyEmployee)otherObject;
			return (super.equals(otherObject)
					&& wageRate == otherHourlyEmployee.wageRate
					&& hours == otherHourlyEmployee.hours);
		}
	}
}
