public class DateFirstTryDemo {
	public static void main(String[] args) {
		DateFirstTry date1, date2; // DateFirstTry.java에서 구현한 클래스

		date1 = new DateFirstTry();
		date2 = new DateFirstTry();
		date1.month = "December";
		date1.day = 31;
		date1.year = 2022;	
		System.out.println("date1:");
		date1.writeOutput();

		date2.month = "August";
		date2.day = 15;
		date2.year = 1994;	
		System.out.println("date2:");
		date2.writeOutput();
	}
	
}
