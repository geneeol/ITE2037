import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class TextEOFDemo {
	public static void main(String[] args) {
		try
		{
			// try 블락 내에 정의된 변수. 밖에서 못씀
			BufferedReader inputStream =
				new BufferedReader(new FileReader("original.txt"));
			PrintWriter outputStream =
				new PrintWriter(new FileOutputStream("numbered.txt"));
			
			int count = 0;
			String line = inputStream.readLine();
			while (line != null)
			{
				count++;
				outputStream.println(count + " " + line);
				line = inputStream.readLine();
			}
			inputStream.close();
			outputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
		}
		catch (IOException e)
		{
			System.out.println("Error reading from original.txt");
		}
	}
}
