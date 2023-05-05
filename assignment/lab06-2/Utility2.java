public class Utility2 {
	public static String censor(String sentence, String... unwanted)
	{
		for (int i = 0; i < unwanted.length; i++)
			sentence = deleteOne(sentence, unwanted[i]);
		return (sentence);
	}
	private static String deleteOne(String sentence, String oneUnwanted)
	{
		String ending;
		int position = sentence.indexOf(oneUnwanted);
		System.out.println("position: " + position);
		while (position >= 0)
		{
			// french fries 바로 뒤의 ,부터 ending 시작.
			ending = sentence.substring(position + oneUnwanted.length());
			sentence = sentence.substring(0, position) + ending;
			position = sentence.indexOf(oneUnwanted);
			// 전부 제거했으면 position값 -1
		}
		return (sentence);
	}
}
