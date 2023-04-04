public class DateDemo1 {
	public static void main(String[] args) {
		Date	date1 = new Date();
		Date	date2 = new Date();
		
		date1.readInput();
		date2.setDate(8, 15, 1945);

		if (date1.equals(date2))
			System.out.println(date1 + " equals " + date2);
		else
			System.out.println(date1 + " does not equal " + date2);
		if (date2.precedes(date1))
			System.out.println(date2 + " comes before " + date1);
		else	
			System.out.println(date2 + " comes before or is eqaul to " + date1);
	}
}
