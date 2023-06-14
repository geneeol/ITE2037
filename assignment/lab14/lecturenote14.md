## clone 메서드는 얕은 복사를 한다
```
ArrayList<Pet> petList1 = new ArrayList<Pet>();
ArrayList<Pet> petList2 = petList1;

# 위처럼 하면 얕은복사! 아래처럼 깊은복사 하려고 함
ArrayList<Pet> petList2 = petList1.clone;

# 그러나 이것은 틀렸습니다.
```
  
- 만약 배열의 1번 요소가 오브젝트를 가리키는 레퍼런스 변수라면?
- 결국 pet1과 pet2가 같은 오브젝트를 가리키게 됨! (얕은 복사)

```
public class Sample<T>
{
	private T data;

	public void setData(T data)
	{
		this.data = data;
	}
}
```

```
public class MyException<T> extends Exception // Illegal!, 컴파일 에러
```
- 제네릭 클래스는 익셉션, 에러, throwable 혹은 throwable 클래스의 자손과 같이 쓰일 수 없다.  

```
<T extends Comparable>
<T extends Employee>
```
-> 위 같이 타입 파라미터에 제한조건 사용 가능. (인터페이스 기반으로 동작)

