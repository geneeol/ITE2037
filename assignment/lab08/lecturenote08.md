## 다형성 소개
- 캡슐화, 상속, 다형성은 객체지향의 주요 특징이다.
- 다형성은 하나의 메서드와 연관된 여러 기능을 의미한다.
	- late binding을 통해 이루어진다.

## Late Binding
- run time에 바인딩되면 late(dynamic) binding이라고 한다.
- 자바는 private, final, static 메서드를 제외한 모든 메서드를 late binding한다.

## The final Modifier
- final 키워드로 마크된 메서드는 파생 클래스에서 오버라이딩 될 수 없다.
- 클래스에 final 키워드를 붙여서 상속할 수 없게할 수 있다.

## The Slae and DiscountSale Classes
- lessThan 메서드가 실행될 때 어느 bill() 메서드가 호출돼야 하는지 안다?
- Sale 클래스와 DiscountSale의 bill() 메서드 중 무엇이 호출돼야 하는지 컴파일 단계에선 모른다.
- 이는 런타임 때 결정된다.
```
public void println(Object theObject)
{
	println(theObject.toString());
}
```  
위와 같이 println이 정의돼있다. 오브젝트 타입은 런타임시에 결정된다. (레이트 바인딩)

## Pitfall: No Late Binding for Static Methods
- 컴파일 시에 어떤 메서드 정의를 사용할 건지 결정되는 것을 static binding이라고 한다.
- java는 static, not late, binding with private, final, and static methods를 사용한다.
	- private, final 메서드의 경우 late binding would serve no purpose (레이트 바인딩이 특별한 용도나 기능이 없다.)

아래 메서드를 Sale 클래스에 추가했다고 하자.
```
public void showAdvertisement()
{
	announcement();
	println(toString());
}
```
```
Sale s = new Sale
DiscountSale discount = new DiscountSale
s.showAdvertisement(); // Sale의 announcement()과 toString() 호출
discountshowAdvertisement(); // Sale의 announcement() 출력, toString만 동적바인딩 됨.
```
- 자바는 레이트 바인딩을 스태틱 메서드가 아닌 toString에 사용했지만, 스태틱 메서드인 announcement에는 정적 바인딩을 적용한다.  
  ```simple = discount;```
  두 변수가 같은 오브젝트를 가리킨다. 특히 Sale class 변수가 DiscountSale 오브젝트를 가리킨다.  
  ```simple.announcement();```  
  출력은 Sale class이다.

- announcement is a static method invoked by a caling object (instead of its class name)
	- 그러므로 simple의 타입은 변수 이름에 의해 결정된다. 해당 오브젝트의 레퍼런스에 의해서가 아니라
- 클래스 변수의 타입은 어떤 메서드가 그 변수와 같이 사용될지 결정한다.
	- However, the obeject name by the variable determines which definition with the same method name is used (그러나 만약 객체가 파생 클래스를 가리키고 있다면, 파생 클래스의 메서드가 사용된다는 뜻.)
- A special case of this rule is as follows
	- The type of a class parameter determines which method names can be used with the parameter
	- The argument determines which definition of the method is used

## Upcasting and Downcasting
- Upcasting은 파생 클래스가 조상 클래스에 할당되는 경우를 의미한다.

```
Sale s;
DiscountSale d;
s = d;
print(s);
```
- late binding 때문에 DiscountSale의 toString 메서드가 사용된다.
- 다운캐스팅은 조상 클래스가 파생 클래스에 할당되는 경우를 의미한다.
- 다운캐스팅을 올바르게 사용할 책임은 컴파일러가 아닌 프로그래머에게 있다.
```
Sale s = new Sale("paint", 15);
DiscountSale d;
d = (DiscountSale)s; // error!
// 위 경우는 s가 d의 인스턴스 변수를 갖고 있지 않기 때문에 에러라고 함
```
- 말이 되는 상황에서만 다운캐스팅을 할 수 있다  
```d = s``` 이 경우 컴파일에러 발생시킴.

## Tip: Checking to See if Downcasting is Legitimate
- Downcasting to a specific type is only sensible if the object being cast is an instance of that type
	- This is exactly what the instanceof operator tests for:
	- ``` Object instanceof Class_Name```
- So the following will return true if someObject is of type DiscountSale:  
``` someObject instanceof DiscountSale```  
object of DiscountSale이거나 파생클래스인 경우 true 반환.

```
if (someObject instanceof DiscountSale)
{
	DiscountSale d = (DiscountSale)someObject;
	...
}
```

## A First Look at the clone Method
- 모든 오브젝트는 clone 메서드를 Object 클래스로부터 상속받는다.
- clone 메서드는 매개변수가 없고, calling object의 딥카피를 반환한다.
- 그 자체로 사용하기 보다 적절히 오버라이딩 해서 사용할 것으로 기대한다.

```
OldClass copy = original.clone(); // 컴파일 에러 발생 (리턴타입이 오브젝트이므로)
OldClass copy = (OldClass)original.clone(); // 이렇게 사용해야 함 (자바 5.0 이후로는 굳이 타입캐스팅 안해도 된대)
```

// 그냥 복사생성자만으로는 에러가 발생하는 상황이 존재한다.
```
public static Sale[] goodCopy(Sale[]a)
{
	Sale[] b = new Sale[a.length];
	for (int i = 0; i < a.length; i++)
	// a가 discountSale타입이면 해당 객체를 반환한다. (레이트 바인딩)
		b[i] = a[i].clone();
	return (b);
}
```
## Abstract Class
- 적어도 하나의 추상 메서드를 가진 클래스는 추상 클래스이다.
- 추상 클래스는 클래스 정의에 abstract 키워드를 포함해야한다.

## Pitfall: You Cannot Create Instances of an Abstract Class
- 추상 클래스는 인스턴스화 될 수 없다.
- 추상 클래스는 오직 구체화된 파생클래스에서 사용된다.
- 추상 클래스의 생성자는 파생 클래스에서 super를 통해 호출된다.

## Tip: An Abstract Cass Is a Type
- 추상클래스는 인스턴스화될 수 없지만, 매개변수로 추상 클래스 타입을 갖는 것은 괜찮다.
(이는 아무 자손 클래스나 매개변수로 받을 수 있다는 뜻이다.)
- it is also fine to use a variable of an abstract class type, as long is it names objects of its concrete descendent classes only (추상 클래스 유형의 변수를 사용해도 좋습니다. 구체적인 하위 클래스의 개체 이름만 지정하면 됩니다)