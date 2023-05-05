public class EnumDemo {
	// 등호가 없다!!
	enum WorkDay {MONDAY, TUESDAY, WENDNESDAY, THURSDAY, FRIDAY};

	public static void main(String[] args) {
		WorkDay	startDay = WorkDay.MONDAY;
		WorkDay	endDay = WorkDay.FRIDAY;

		System.out.println("Work starts on " + startDay);
		System.out.println("Work ends on " + endDay);
	}
}
