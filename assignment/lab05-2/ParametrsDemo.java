public class ParametrsDemo {
	public static void main(String[] args) {
		ToyClass2 object1 = new ToyClass2(),
				  object2 = new ToyClass2();
		
		object1.set("Scorpius", 1);
		object2.set("John Crichton", 2);
		System.out.println("Value of object2 before called to method:");
		System.out.println(object2);
		object1.makeEqual(object2); //h 이 값은 값 변경 시도후 바뀐다, 인자 object2 변수값을 바꾼다
		System.out.println("Value of object2 after called to method:");
		System.out.println(object2);

		int aNumber = 42; // 이 값은 값 변경 시도 후에도 바뀌지 않는다
		System.out.println("Value of aNumber before called to method:" + aNumber);
		object1.tryToMakeEqual(aNumber);
		System.out.println("Value of aNumber after called to method:" + aNumber);

		
	}
}
