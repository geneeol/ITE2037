import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// open the file insde a try catch block
// by doing this it jumps to catch blokc if it fails.
public class TextFileDemo {
	public static void main(String[] args) {
		Scanner	fileIn = null;

		try
		{
			//Attempt to open the file
			fileIn = new Scanner(new FileInputStream("playter.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}

		int		highscore;
		String	name;
		System.out.println("Text left to read? " + fileIn.hasNextLine());
		highscore = fileIn.nextInt();
		fileIn.nextLine(); // 이 줄은 개행 제거 하기 위해 존재함
		name = fileIn.nextLine();

		System.out.println("Name: " + name);
		System.out.println("High score: " + highscore);
		System.out.println("Text left to read? " + fileIn.hasNextLine());
		fileIn.close();
	}
}
