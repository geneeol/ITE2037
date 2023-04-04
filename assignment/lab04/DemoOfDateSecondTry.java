// java에는 전역변수 없대

public class DemoOfDateSecondTry {
	
	public static void main(String[] args) {
		DateSecondTry	date = new DateSecondTry();
		date.readInput();
		
		int	dayNumber = date.getDay();
		//  dayNumber = date.day <--- 프라이빗 맴버라 접근 불가능 dayNumber = date.day <--- 프라이빗 맴버라 접근 불가능
		System.out.println("That is the " + dayNumber + "th day of the month");
	}
}
