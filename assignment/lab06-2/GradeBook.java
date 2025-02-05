import java.util.Scanner;

public class GradeBook {
	private int	numberOfStudents;
	private int	numberOfQuizzes; 

	private	int[][] grade;
	private	double[] studentAverage;
	private double[] quizAverage;

	public GradeBook(int[][] a)
	{
		// 둘다 0이면  아무 원소가 없다.
		if (a.length == 0 || a[0].length == 0)
		{
			System.out.println("Empty grade records. Aborting");
			System.exit(0);
		}
		numberOfStudents = a.length;
		numberOfQuizzes = a[0].length;
		fillGrade(a);
		fillStudentAverage();
		fillQuizAverage();
	}

	public GradeBook(GradeBook book)
	{
		numberOfStudents = book.numberOfStudents;
		numberOfQuizzes = book.numberOfQuizzes;
		fillGrade(book.grade);
		fillStudentAverage();
		fillQuizAverage();
	}

	public GradeBook()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter number of students:");
		numberOfStudents = keyboard.nextInt();

		System.out.println("Enter number of quizzes:");
		numberOfQuizzes = keyboard.nextInt();

		grade = new int[numberOfStudents][numberOfQuizzes];
		for (int studentNumber = 1; studentNumber <= numberOfStudents; studentNumber++)
		{
			for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
			{
				System.out.println("Enter score for studnet number " 
										+ studentNumber);
				System.out.println("on quiz number " + quizNumber);
				grade[studentNumber - 1][quizNumber - 1] = keyboard.nextInt();

			}
		}
		fillStudentAverage();
		fillQuizAverage();
	}

	private void fillGrade(int[][] a)
	{
		grade = new int[numberOfStudents][numberOfQuizzes];

		// 여기 교수님이 수정함
		for (int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++)
		{
			for (int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++)
				grade[studentNumber][quizNumber] = a[studentNumber][quizNumber];
		}

	}

	private void fillStudentAverage()
	{
		studentAverage = new double[numberOfStudents];

		for (int studentNumber = 1; studentNumber <= numberOfStudents; studentNumber++)
		{
			double sum = 0;
			for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
				sum += grade[studentNumber - 1][quizNumber - 1];
			studentAverage[studentNumber - 1] = sum / numberOfQuizzes;

		}
	}

	private void fillQuizAverage()
	{
		quizAverage = new double[numberOfQuizzes];

		for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
		{
			double sum = 0;
			for (int StudentNumber = 1; StudentNumber <= numberOfStudents; StudentNumber++)
				sum += grade[StudentNumber - 1][quizNumber - 1]; // 교수님은 이렇게 쓰는거 추천 안한대
			quizAverage[quizNumber - 1] = sum / numberOfStudents;
		}
	}

	public void display()
	{
		// 여기 교수님이 수정함
		for (int studentNumber = 1; studentNumber <= numberOfStudents; studentNumber++)
		{
			System.out.print("Student " + studentNumber + " Quizzes: ");
			for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
				System.out.print(grade[studentNumber - 1][quizNumber - 1] + " ");
			System.out.println(" Ave = " + studentAverage[studentNumber - 1]);
		}
		System.out.print("Quiz averages: ");
		for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
			System.out.print("Quiz " + quizNumber + " Ave = " + quizAverage[quizNumber - 1]
								+ " ");
		System.out.println();
	}
}
