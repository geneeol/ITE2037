import java.util.Random; //h 랜덤 임포트

public class CoinFlipDemo {
	public static void main(String[] args) {
		//h 랜덤 객체 생성
		Random	randomGenerator = new Random(); // 랜덤 객체 생성
		int		counter = 1;

		while (counter <= 5)
		{
			System.out.print("Flip number " + counter + ": ");
			int	coinFlip = randomGenerator.nextInt(2); //h 매개변수가 상한, 열린구간
			if (coinFlip == 1)
				System.out.println("Heads");
			else
				System.out.println("Tails");
			counter++;
		}
		
	}
}
