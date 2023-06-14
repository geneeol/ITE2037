import java.util.ArrayList;

public class ArrayListTest {
	// 꺽쇠안에 매개변수 타입?
	public static void main(String[] args) {
		
		// capacity와 size는 다르다. 사이즈가 7이면 9번 인덱스에 삽입하려고 하면 에러
		ArrayList<String> aList = new ArrayList<String>();
		// ArrayList<String> list = new ArrayList<String>(20); // 초기 용량(capacity)을 20으로 설정

		aList.add("one");
		aList.add("two");
		aList.add("three");
		aList.add("four");
		aList.add("five");
		aList.add("six");

		System.out.println(aList.size());
		System.out.println(aList);
		
		// 0번위치에 추가하고 나머지 전부 오른쪽으로 쉬프트
		aList.add(0, "zero");
		System.out.println(aList.size());
		System.out.println(aList);

		// aList.add(8, "seven"); -> 인덱스 바운드 에러 (익셉션) 발생!
		aList.add(7, "seven");
		System.out.println(aList);

		// // aList.set(7, "ZERO"); -> 인덱스 바운드 에러 (익셉션)
		aList.set(0, "ZERO");
		System.out.println(aList.size());
		System.out.println(aList);

		// System.out.println(aList.get(0)); //인덱스가 범위내에 존재해야 에러 예외발생안함
		// System.out.println("-----------\n");

		// // aList.remove(0);
		// System.out.println(aList.remove(1));
		// System.out.println(aList.size());
		// System.out.println(aList);

		// 중요! removeRange fromidx toidx | fromidx <= i < toidx 범위 주의
		System.out.println("-----------\n");

		aList.set(6, "ZERO");
		System.out.println(aList.size());
		System.out.println(aList);

		// 만약 같은 키값이 두개 있으면?, 앞에부터 지우는듯
		// aList.remove("ZERO");
		System.out.println(aList.size());
		System.out.println(aList);

		System.out.println("-----------\n");

		if (aList.contains("ZERO"))
			System.out.println("aList contatins ZERO");
		
		// 못찾으면 -1 리턴
		System.out.println("The first index of ZERO is " + aList.indexOf("ZERO") + ".");
		System.out.println("The last index of ZERO is " + aList.lastIndexOf("ZERO") + ".");


		// aList.clear();
		// System.out.println(aList.size());
		// System.out.println(aList);
		// if (aList.isEmpty())
		// 	System.out.println("aList is empty");
		// else
		// 	System.out.println("aList is not empty");

		/*
		 * toArray()
		 * clone
		 * equalsa -> 같은 사이즈고 요소가 전부 같은 순서로 있으면
		 */
	}

	
}
