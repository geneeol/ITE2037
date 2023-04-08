package lab00;
/**
 * StringProcessingDemo
 */
public class StringProcessingDemo {
	public static void main(String[] args) {
		String sentence = "I hate text processing!";
		int	pos = sentence.indexOf("hate");
		String	ending = sentence.substring(pos + "hate".length());
		System.out.println("01234567890123456789012");
		System.out.println(sentence);
		System.out.println("The word \"hate\" starts at index " + pos);
		sentence = sentence.substring(0, pos) + "adore" + ending;
		System.out.println(sentence);
	}
}