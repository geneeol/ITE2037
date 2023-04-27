import java.util.Scanner;
import java.io.FileInputStream; //h 헤더
import java.io.FileNotFoundException; //h 헤더 암기

// open the file insde a try catch block
// by doing this it jumps to catch blokc if it fails.
public class TextFileDemo {
	public static void main(String[] args) {
		//h 아래 라인 외울 것
		Scanner	fileIn = null;
		try
		{
			//Attempt to open the file
			//h 아래 라인 외울 것
			fileIn = new Scanner(new FileInputStream("playter.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}

		int		highscore;
		String	name;
		//h hasNextLine함수는 읽지는 않고 다음 줄이 있는지만 검사함
		System.out.println("Text left to read? " + fileIn.hasNextLine()); //h hasNextLine() 함수 암기
		highscore = fileIn.nextInt();
		fileIn.nextLine(); // 이 줄은 개행 제거 하기 위해 존재함 (중요!)
		name = fileIn.nextLine();

		System.out.println("Name: " + name);
		System.out.println("High score: " + highscore);
		System.out.println("Text left to read? " + fileIn.hasNextLine());
		fileIn.close();
	}
	//h 출력
	// Text left to read? true
	// Name: Gordon Freeman
	// High score: 100510
	// Text left to read? false
}
