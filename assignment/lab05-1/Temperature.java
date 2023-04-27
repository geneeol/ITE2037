import java.util.Scanner;

public class Temperature {
	private double	degrees; // In Celsius

	public Temperature(){
		degrees = 0;
	}

	public Temperature(double degrees){
		this.degrees = degrees;
	}

	// mutator
	public void	setDegress(double degrees){
		this.degrees = degrees;
	}

	public double	getDegrees(){
		return (degrees);
	}
	
	public String toString(){
		return (degrees + " C"); //h 이렇게 써도 되네?
	}

	public boolean	equals(Temperature otherTemperature){
		return (degrees == otherTemperature.degrees);
	}

	public static double toCelcius(double degreesF) {
		return (5 * (degreesF - 32) / 9); // 5.0으로 안써도 double로 처리된댕
		
	}
	public static void main(String[] args) {
		double	degreesF, degreesC;
		Scanner	keyboard = new Scanner(System.in);

		System.out.println("Enter degrees Fahrenheit:");
		degreesF = keyboard.nextDouble();
		degreesC = toCelcius(degreesF); //h 같은 클래스 내 함수라 클래스이름 생략 가능 Temperature.toCelsius에서 앞에 생략
		Temperature temperatureObject = new Temperature(degreesC);
		System.out.println("Equivalent Celsius temperature is "
							+ temperatureObject.toString()); //h main문은 static이라 toString 메서드는 반드시 구체적인 calling obejct를 가져야 한다.
	}
}
