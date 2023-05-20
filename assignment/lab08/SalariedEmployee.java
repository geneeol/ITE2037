public class SalariedEmployee extends Employee {
	private double salary; // annual

	public SalariedEmployee() {
		super();
		salary = 0;
	}

	public SalariedEmployee(String theName, Date theDate, double theSalary) {
		super(theName, theDate);
		if (theSalary >= 0)
			salary = theSalary;
		else
		{
			System.out.println("Fatal Error: creating an illegal salaried employee.");
			System.exit(0);
		}
	}

	public SalariedEmployee(SalariedEmployee originalObject) {
		// derived class라 아래 문법 합법
		super(originalObject); // Employee(Employee originalObject) 복사생성자
		salary = originalObject.salary;
	}

	public double getSalary()
	{
		return salary;
	}

	// 현재 getPay는 salary가 정의 되어야만 계산할 수 있다. (Employee는 getPay 메서드가 없다!)
	public double getPay()
	{
		return salary / 12;
	}

	public void setSalary(double newSalary)
	{
		if (newSalary >= 0)
			salary = newSalary;
		else
		{
			System.out.println("Fatal Error: Negative salary.");
			System.exit(0);
		}
	}

	public String toString()
	{
		return (getName() + " " + getHireDate().toString() +
				"\n$" + salary + " per year");
	}
	
	public boolean equals(SalariedEmployee other)
	{
		return (getName().equals(other.getName())
				&& getHireDate().equals(other.getHireDate()) 
				&& salary == other.salary);
	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			SalariedEmployee otherEmployee = (SalariedEmployee)otherObject;
			return (super.equals(otherObject) 
					&& salary == otherEmployee.salary);
		}
	}
}
