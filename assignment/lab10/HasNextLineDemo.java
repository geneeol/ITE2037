import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;


public class HasNextLineDemo {
	public static void main(String[] args) {
		Scanner inputStream = null;
		PrintWriter outputStream = null;

		try
		{
			inputStream = new Scanner(new FileInputStream("original.txt"));
			outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
			// 둘 중 뭐에서 익셉션 발생했는지 모름.
			// 구분하려면 두개의 캐치 블락을 생성해야함.
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
			System.exit(0);
		}

		String line = null;
		int count = 0;

		while (inputStream.hasNextLine())
		{
			line = inputStream.nextLine();
			count++;
			outputStream.println(count + " " + line);
		}

		inputStream.close();
		outputStream.close();
	}
}
