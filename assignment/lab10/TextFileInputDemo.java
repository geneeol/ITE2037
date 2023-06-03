import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileInputDemo {
	public static void main(String[] args) {
		try
		{
			BufferedReader inputStream = 
				new BufferedReader(new FileReader("morestuff2.txt"));

			String line = inputStream.readLine();
			System.out.println("The first line read from the file is:");
			System.out.println(line);
			// morestuff2.txt에 1 2 3만 남기면 null 읽어들임
			// exception 발생 안함
			line = inputStream.readLine();
			System.out.println("The second line read from the file is:");
			System.out.println(line);
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File morestuff2.txt was not found");
			System.out.println("or could not be opened.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading from file morestuff2.txt.");
		}
	}
}
