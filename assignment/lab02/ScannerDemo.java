import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner	keyboard = new Scanner(System.in); // 선언 외울 것 Scanner keyboard = new Scanner(System.in)

		System.out.println("Enter the number of pods followed by");
		System.out.println("the number of peas in a pod: ");
		int	numberofPods = keyboard.nextInt();
		int	peasPerPod = keyboard.nextInt();

		int	totalNumberofPease = numberofPods * peasPerPod;

		System.out.print(numberofPods + " pods and ");
		System.out.println(peasPerPod + " peas per pod.");
		System.out.println("The total number of peas = " + totalNumberofPease);
	}
}
