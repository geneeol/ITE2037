import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TextFileScannerDemo {
	public static void main(String[] args) {
		System.out.println("I will read three numbers and a line");
		System.out.println("of text from the file morestuff.txt.");

		Scanner inputStream = null;

	try
	{
		inputStream = new Scanner(new FileInputStream("morestuff.txt"));
	}
	catch (FileNotFoundException e)
	{
		System.out.println("File morestuff.txt was not found");
		System.out.println("or could not be opened.");
		System.exit(0);
	}

	int n1 = inputStream.nextInt();
	int n2 = inputStream.nextInt();
	int n3 = inputStream.nextInt();

	// 이 라인 때문에 파일에서 4 스킵됨
	inputStream.nextLine();

	String line = inputStream.nextLine();

	System.out.println("The three numbers read from the file are:");
	System.out.println(n1 + ", " + n2 + ", and " + n3);

	System.out.println("The line read from the file is:");
	System.out.println(line);

	inputStream.close();
	}
}
