## Inheritance
- 상속은 다른 클래스로부터 새 클래스가 생성되는 프로세스이다.
- 새 클래스는 derived class, 오리지널 클래스는 base 클래스
- 코드의 재사용성 제고

## Derived Class
- subclass라고도 불린다. base class로부터 상속받은 후 추가적인 메서드 및 맴버 함수를 추가한다.
```public clss HourlyEmployee extends Employee```
- **생성자는 상속받지 않는다?**
- 실제로는 상속받지만, 생성자의 이름은 super로 사용된다? (이름대신), 추후 설명
- toStirng, equals는 오버라이딩 된다.

```
public class HourlyEmployee extends Employee
{
	private double wageRate; // 시급
	private double hours; // 근무시간

	public HourlyEmployee( )
	{
		super( );  // 이 줄 없으면 자바는 base class에 대해 no-arg 생성자를 계속 호출한다
		// super는 Employee를 의미한다.
		wageRate = 0;
		hours = 0;
	}
}
```

## 부모, 자식 클래스
- base 클래스: 부모, derived 클래스: 자식
- 부모의 부모는 ancestor class
- A가 B의 ancestor class이면, B는 A의 descendant class

## Overriding a Method Edfinition
- base class의 메서드를 필요에 따라 derived class에서 변경하거나 override할 수 있다.

## Changing the Return Type of an Overridden Method
- 일반적으로 리턴 타입은 오버라이딩된 함수에 의해 바뀌지 않는다.
- 그러나 만약 리턴 타입이 클래스 타입이라면, descendent class의 리턴 타입으로 바뀔 수 있다.
- **covariant return type**이라고 한다.

```
public class BaseClass
{
	...
	public Employee getSomeone(int someKey)
	...
}
```

```
public class DerivedClass extends BaseClass
{
	...
	public HourlyEmployee getSomeone(int someKey)
	// 위 함수 리턴타입이 Employee에서 derived되었으면 리턴타입이 바뀔 수 있다.
	...
}
```

## Changing the Access Permission of an Overridden Method
- overridden 메서드의(오버라이딩된) 접근 권한은 base class에서 private던게 derived class에서는 다른 권한으로 바뀔 수 있다.
- 그러나 overrden 메서드의 접근 권한은 다음과 같이 바뀔 수 없다. base class에서 public이면 derived class에서 private으로 바뀔 수 없다.
(a more restricted acess permission으로 바뀔 수 없다.)

base class
``` private void doeSomething()```  

derived class
``` public void doeSomething()```  
-> 위 경우는 가능하다

base class
``` public void doeSomething()```  

derived class
``` private void doeSomething()```  
-> **위 경우는 불가능하다.**

## Pitfall: Overriding Verssus Overloading
- 오버라이딩은 메서드의 이름이 같고, 파라미터의 타입이 같고, 리턴 타입이 같은 경우에만 가능하다.
- dervied클래스 메서드의 매개변수 개수가 다르면 base class 메서드와 오버라이딩된 것 아님.
- 그러나 ```public String toString()``` 메서드는 오버라이딩된 함수이다.
(Employee, HourlyEmployee 두 클래스 모두 위와 같이 정의하기 때문이다.)

## The final Modifier
- 지정자 final이 붙은 메서드는 derived class에서 재정의할 수 없다
- 지정자 final이 붙은 클래스는 base class로 활용할 수 없다. (상속에 사용할 수 없다.)

## The super Constructor
- derived class의 생성자는 base class의 생성자를 사용한다. (모든 맴버변수 초기화를 위해)
- base class의 생성자를 호출하기 위해 super라는 특별한 문법을 사용한다.
- **super는 반드시 첫번째 라인에서 호출되어야 한다! (중요)**
- 만약 derived class가 super를 호출하지 않으면, 자바는 base class의 no-arg 생성자를 자동으로 호출한다.
	- 만약 base class에 no-arg 생성자가 없으면, 자바는 에러를 발생시킨다.
- **super keyword대신 base class 생성자 이름을 직접 쓰면 illegal하다.**

## The this constructor
- 클래스 내의 생성자 정의내에서, **this**는 같은 클래스의 다른 생성자를 호출하는데 사용될 수 있다.
  - The same restrictions on how to use a call to super apply to the **this** constructor
  - **this** constructor call must be the first statement in the constructor
- this와 super를 둘다 포함하는게 필요하다면, this만 첫번째로 만들고, this가 super를 첫번째로 호출하게 하면 된다.

no-arg 생성자 (invokes explicit-value constructor using this and default args):
```
public ClassName()
{
	this(argument1, argument2);
}
```
  
explicit-value constructor(receives defalut values):
```
public ClassName(type1 param1, type2 param2)
{
	...
}
```  
this 생성자를 호출하면 이에 대응되는 실제 생성자가 호출된다.

## Tip: An Object of a Derived Class Has More than One Type
- derived class의 오브젝트는 derived class의 타입뿐만 아니라 base class 타입도 갖는다.
- 일반적으로 모든 ancestor classes의 타입도 가진다.
- Note: base class 오브젝트는 항상 derived class 오브젝트가 될 수는 없다.

## Pitfall: The Terms "Subclass" and "Superclass"
- The terms subclass and superclass are sometimes mistakenly reversed
  - superclasss or base class는 더 일반적고 포괄적이다. (그리고 덜 복잡하다)
  - subclass는 더 구체적이고 덜 포괄적이다. (그리고 더 복잡하다)