import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class FileClassDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String line = null;
		String fileName = null;

		System.out.println("I will store a line of text for you.");
		System.out.println("Enter the line of text: ");
		line = keyboard.nextLine();
		System.out.println("Enter a file name to hold the line:");
		fileName = keyboard.nextLine();
		File fileObject = new File(fileName);
		while (fileObject.exists())
		{
			System.out.println("There already is a file named " + fileName);
			System.out.println("Enter a different file name:");
			fileName = keyboard.nextLine();
			fileObject = new File(fileName);
		}
		PrintWriter outputStream = null;
		try 
		{
			outputStream = new PrintWriter(new FileOutputStream(fileName));
			// outputStream = new PrintWriter(new FileOutputStream(fileObject));
			// 위처럼 파일이름대신 파일오브젝트를 인자로 넘겨줘도 됨.
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		System.out.println("Writing \"" + line + "\"");
		System.out.println("to the file" + fileName);
		outputStream.println(line);

		outputStream.close();
		System.out.println("Writing completed.");
	}
}
