// 전부다 인터페이스, 메서드 전부 퍼블릭 
public interface Ordered {
	// o1.follows(o2) == o2.precedes(o1)
	public boolean precedes(Object other); // 세미콜론 빼먹지 말것, 헤더 선언과 유사
	public boolean follows(Object other);

	
}