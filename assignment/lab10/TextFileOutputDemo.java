//h 세 라인 import 필요
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class TextFileOutputDemo {
	public static void main(String[] args) {
		PrintWriter outputStream = null;
		try
		{
			// PrintWriter outputStream = new PrintWrite(new FileOutputStream("stuff.txt"));
			//h try block밖에 변수를 선언해야 함.
			outputStream = new PrintWriter(new FileOutputStream("stuff.txt"));
			// 두번째 인자 true면 appending 모드
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file stuff.txt.");
			System.exit(0);
		}

		System.out.println("Writing to file.");

		outputStream.println("The quick brown fox");
		outputStream.println("jumps over the lazy dog.");

		outputStream.close();

		System.out.println("End of program.");
	}
}
