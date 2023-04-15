//package lab05-2;

public class ClassParameterDemo {

	public static void main(String[] args) {
		ToyClass anObject = new ToyClass("Mr. Cellophane", 0);
		System.out.println(anObject);
		System.out.println("Now we call changer with anObject as argument.");
		ToyClass.changer((anObject)); // 클래스 이름으로 호출해야함. static 함수라!
		System.out.println(anObject); // changer의 aParemeter 매개변수가 anObject와 같은 객체를 참조함
	}
}
