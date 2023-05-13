public class IsADemo {
	public static void main(String[] args) {
		SalariedEmployee joe = new SalariedEmployee("Josephine",
													new Date("January", 1, 2015),
													100000);
		HourlyEmployee sam = new HourlyEmployee("Sam",
												new Date("February", 1, 2016),
												50.50, 40);

		System.out.println("joe's longer name is " + joe.getName());
		System.out.println("showEmployee(joe) invoked:");
		showEmployee(joe);
		System.out.println("showEmployee(sam) invoked:");
		showEmployee(sam);
		
	}

	// 상속의 이점: showEmpoyee함수를 두개 만들 필요 없이 하나로 통일할 수 있다.
	public static void showEmployee(Employee employeeObject)
	{
		System.out.println(employeeObject.getName());
		System.out.println(employeeObject.getHireDate());
	}
}
