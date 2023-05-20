public abstract class Employee {
	private String name;
	private Date hireDate;

	//h abstract는 private일 수 없다., 메서드 바디가 없다.
	// 자식 클래스에서 오버라이딩된다.
	public abstract double getPay();
	
	public Employee()
	{
		name = "No name";
		hireDate = new Date("January", 1, 1000);
	}

	// 전제: theName, theDate는 널이 아님
	public Employee(String theName, Date theDate)
	{
		if (theName == null || theDate == null)
		{
			System.out.println("Fatal Error creating employee.");
			System.exit(0);
		}
		name = theName;
		hireDate = new Date(theDate);
	}

	public Employee(Employee originalObject)
	{
		name = originalObject.name;
		hireDate = new Date(originalObject.hireDate);
	}

	public String getName()
	{
		return name;
	}

	public Date getHireDate()
	{
		return new Date(hireDate);
	}

	public void setName(String newName)
	{
		if (newName == null)
		{
			System.out.println("Fatal Error setting employee name.");
			System.exit(0);
		}
		else
			name = newName;
	}

	public void setHireDate(Date newDate)
	{
		if (newDate == null)
		{
			System.out.println("Fatal Error setting employee hire date.");
			System.exit(0);
		}
		else
			hireDate = new Date(newDate);
	}

	public String toString()
	{
		return (name + " " + hireDate.toString());
	}

	public boolean equals(Employee otherEmployee)
	{
		return (name.equals(otherEmployee.name)
				&& hireDate.equals(otherEmployee.hireDate));
	}

	// 추가
	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			Employee otherEmployee = (Employee)otherObject;
			return (name.equals(otherEmployee.name)
					&& hireDate.equals(otherEmployee.hireDate));
		}
	}

	// employee에 getpay 메서드가 없으면 getpay를 호출할 수 없다.
	public boolean samePay(Employee other)
	{
		if (other == null)
		{
			System.out.println("Fatal Error: null employee.");
			System.exit(0);
		}
		return (this.getPay() == other.getPay());
		// getPay 메서드는 나중에 바인딩 된다.
	}
}
