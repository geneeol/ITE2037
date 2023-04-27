// package assignment.lab02;

public class PrintfDemo {
	public static void	main(String[] args)
	{
		String	aString = "abc";
		char	oneCharacter = 'Z';
		double	d = 12345.123456789;

		System.out.println("String output:");
		System.out.println("START1234567890");
		System.out.printf("START%sEND %n", aString);
		System.out.printf("START%4sEND %n", aString); //최소 4칸을 쓰게하는 옵션
		System.out.printf("START%2sEND %n%n", aString); //최소 2칸을 쓰게 하는 옵션

		System.out.println("Character output:");
		System.out.println("START1234567890");
		System.out.printf("START%cEND %n", oneCharacter);
		System.out.printf("START%4cEND %n%n", oneCharacter);
		
		System.out.println("Floating-point output:");
		System.out.println("START1234567890");
		System.out.printf("START%fEND %n", d);
		System.out.printf("START%.4fEND %n", d); // 소수 4자리
		System.out.printf("START%.2fEND %n", d); // 소수 2자리
		System.out.printf("START%12.4fEND %n", d); // 12칸 + 소수 4자리
		System.out.printf("START%eEND %n", d); // e지수 표기법, 1.234512e+04
		System.out.printf("START%12.5eEND %n", d); // 1.23451e+04 <<- 이거 왜? 위랑 차이가 뭐지, 정밀도 차이

	}
	
}
