//package lab05-1;
import java.util.Scanner;

public class RoundStuff2 {

	public static final double PI = 3.14159;

	public static double	area(double radius){
		return (PI * radius * radius);
	}

	public static double	volume(double radius){
		return ((4.0 / 3.0) * PI * radius * radius * radius);
	}
	public static void main(String[] args) {
		Scanner	keyboard= new Scanner(System.in);
		System.out.println("Enter radius:");
		double	radius = keyboard.nextDouble();

		System.out.println("A circle of radius " + radius + " inches");
		System.out.println("has an area of " 
				+ RoundStuff.area(radius) + " square inches"); // static 함수라 이런식으로 호출 가능
		System.out.println("A sphere of radius " + radius + " inches");
		System.out.println("has a volume of "
				+ RoundStuff.volume(radius) + " cubic inches."); // class이름으로 static 함수 호출 가능

	}
}
