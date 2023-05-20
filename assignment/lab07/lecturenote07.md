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

## Encapsulation and Inheritance Pitfall
#### :Use of Private Instance Variables from the Base Class
- 베이스 클래스 내의 프라이빗 인스턴스 변수는 다른 클래스의 메서드 정의 내에서도, 파생 클래스의 메서드
정의 내에서도 이름으로 엑세스할 수 없다.
- 대신에 base class의 프라이빗 변수는 오직 해당 클래스에 정의된 public accessor와 mutator 메서드를 통해서만 접근 가능하다.
- 예를 들어 다음과 같은 코드는 HourlyEmployee 오브젝트 joe를 Josephine으로 변경한다.
```joe.setName("Josephine");```
- The private methods of the base class are like private variables in terms of not being directly available.
- However, a private method is completely unavailable, unless invoked indirectly
  - This is possible only if an object of a derived class invokes a public method of the base class that happens to invoke the private method.
- 프라이빗 메서드는 반드시 단지 helping method로서 사용되기에 이것이 문제되진 않는다.
  - 만약 메서드가 helping method가 아니면, 반드시 **public** 이어야 한다.
  
## Protected and Package Acess
- If a method or instance variable is modified by **protected** (rather than public or priavte), then it can be accessed by name
  - Inside its own class definition
  - Inside any class derived from it
  - In the definition of any class in the same package

```
public String toStirng()
{
	// Legal if instance variables in Employee are marked protected
	return (name + " " + hireDate.toString() + ...);
}
```

## Protected and Package Acess
-  **protected** modifier는 **private**에 비해 아주 약한 보호 기능을 갖는다.
   - It allows direct access to any programmer who defines a suitable derived class
   - Therefore, instance variables should normally not be marked protected
- An instance variable or method definition that is not preceded with a modifier has package access
  -  Package access is also known as default or friendly access
- Instance variables or methods having package access can be accessed by name inside the defintion of any class in the same package
- Note that package access is more restrited than protected.
	- package access gives more control to the programmer defining the claases
	- Whoever controls the package directory (or folder) controls the package access


## Access Modifiers
- A B C가 같은 패키지에 속한다고 가정하자. C랑 D는 클래스 A를 상속받는다. E는 독립적인 클래스다.
```
public class A
{
	public int v1
	protected int v2 // 같은 패키지에 속하거나 파생 클래스거나
	int v3 // package access, 같은 패키지에 속한 클래스끼리 접근 가능
	private int v4
}
```
B: v1, v2 ,v3 접근 가능 v4 접근 불가  
C: v1, v2, v3 접근 가능 v4 접근 불가   
D: v1, v2 접근 가능 v3, v4 접근 불가  
E: v1 접근 가능 v2, v3, v4 접근 불가

## Pitfall: Forgetting About the Default Package
- When considering package access, do not forget the default package
- If a class in the current directory is not in any other package, then it is in the default package
	- If an instance variable or methods has package access, it can be accessed by name in the definition of any other class in the default package

## Pitfall: A Restriction on Protected Access
- If a Class B is derived from class A, an Class A has protected instance variable n, but the classes A and B are in different pakcages, then the following is true:
- A method in Class B can access n by name (n is inherited from class A)
- A method in class B can create a local object of itself, which can access n by name(again, n is inherited from class A)
- However, if a method in class B creates an object of class A, it can not access n by name
- A class knows about its own inherited variables and methods
- However, it cannot directly access any instance variable or method of ancestor class unless they are public
- Therefore, B can access n whenever it is used as an instance variable of B, but B cannot access n when it is used as an instance variable of A
- This is true if A and B are not in the same package
	- 두 클래스가 같은 패키지에 속하면 문제 없다. **proteced**는 package access를 포함하기 때문.

## Pitfall: A Restriction on Protected Access
- Suppose class D is derived from class B, the instance variable n has protected access in class B, and the classes B and D are in different packages, so the class definition begin as follows
```
package one;

public class B
{
	protected int n;
	...
}
```
```
package two

import one.B;

public class D extends B
{
	...
}
```

이와 같을 때 클래스 D에 나타날 수 있는 다음 메서드는 정당하다. 
```
public void demo()
{
	n = 42; // n is inherited from B, D 타입 오브젝트
}
```
derived class D의 다음 메서드 정의도 정당하다.
```
public void demo2()
{
	D object = new D(); // D타입 오브젝트
	object.n = 42; // n is inherited from B.
}
```
**그러나 D클래스의 다음 메서드 정의는 정당하지 않다.**
```
public void demo3()
{
	B object = new B();
	object.n = 42; // Error, B타입 오브젝트에 접근한 것이라
}
```

## Tip: static Variables Are inherited
- Static variables in a base class are inherited by any of its derived classes
- The modifiers public, protected, private, and package access have the same meaning for static variables as they do for instance variables

## Tip: "Is a" Versus "Has a"
- A derived class demonstrates an "is a" relationsship between it and its base class
- Forming an "is a" relationship is one way to make a more complex class out of simpler class
- For example, an HourlyEmployee "is an Employee"
- HourlyEmployee is a more complex class compared to the more general Employee class
- 간단한 클래스로부터 복잡한 클래스를 만들어내는 다른 방법은 "has a" 관계를 이용하는 것이다.
- 이런 타입의 관계는 composition이라고도 불린다. 이는 클래스가 클래스 타입 인스턴스 변수를 가질 때 발생한다.
- Employee class는 hireDate라는 Date 타입의 인스턴스 변수를 가진다. 그러므로 "Employee has a Date" 관계를 보여준다.
- 두 종류의 관계는 같은 클래스 내에서 복잡한 클래스를 생성하는데 일반적으로 사용된다.
	- HourlyEmployee 클래스는 Employee 클래스의 파생 클래스이고, Date 클래스를 인스턴스 변수로 갖는다. 그러므로 HourlyEmployee는 Employee 클래스이고 Date 클래스를 갖는다.
## Access to a Redefined Base Method
- 오버라이딩된 함수는 super.toString() 형태로 호출될 수 있다.
- 그러나 파생 클래스 정의 외에서 사용하는 오브젝트는 부모 클래스의 오버라이딩된 메서드를 호출할 수 없다.
- Employee와 HourlyEmployee에 toString이 오버라이딩돼있다.
  
HourlyEmployee에서 다음과 같이도 가능
``` 
public String toString()
{
	return (super.toString() + ...);
}
```

- 직접적으로 부모인 경우만 super를 통해 호출 가능하다. (조상은 호출 불가)
- HourlyEmployee 클래스내에서 Person 클래스 내에 정의된 메서드를 호출할 수 없다.

## The Class Object
- 자바에서 모든 클래스는 class Object의 descendant이다.
	- 모든 클래스는 Object 클래스를 조상으로 갖는다.
	- Every obejct of every class is of type object, as well as being of the type of its own class
- 만약 클래스가 명시적으로 다른 클래스의 파생 클래스가 아니라면, 그것은 자동적으로 Object 클래스의 파생 클래스가 된다.
- 클래스 오브잭트는 java.lang 패키지에 포함되어서 항상 자동적으로 불러와진다.

## The Right Way to Define equals
- equals 메서드는 항상 오브젝트 클래스로부터 상속된다.
- equals 메서드를 오버라이딩 하면 내부에서 타입캐스팅을 거쳐야 한다.  
```public boolean equals(Object otherObject)``` 매개변수 타입이 Object이므로
```
if (obj1.getCalss() == obj2.getClass())
	print("같은 종류의 클래스");
```

## A Better equals Method for the Class Employee
```
public boolean equals(Object otherObject)
{
	if (otherObject == null)
		return false;
	else if (getClass() != otherObject.getClass())
		return false;
	else
	{
		Employee otherEmployee = (Employee)otherObject;
		return (name.equals(otherEmployee.name)
				&& hireDate.equals(otherEmployee.hireDate));
	}
}
```

- instanceof 키워드 참고
```
Employee e = new Employee("Joe", new Date("January", 1, 2004));
HourlyEmployee hourlyE = new HourlyEmployee("Joe", new Date("January", 1, 2004), 50.50, 160);
e.equals(hourlyE); // true 반환!
hourlE.equals(e); // false 반환! (아래 같이 쓰여 있었다면)
```
```
else if (!(otherObject instanceof HourlyEmployee))
		return false;
```
위 라인이 이렇게 쓰여있었다면 false 반환.  
두 오브젝트 타입을 비교하려면 getClass()를 쓰래

## instanceof and getClass
- instanceof 연산자는 오브젝트가 두번째 인자의 타입인지 확인한다.  
``` Object instanceof Class_Name```

```otherObject instanceof Employee```  
위 코드는 otherObject가 Employee 클래스의 자손 클래스라면 true를 반환한다.

- getClass() 메서드는 Object 클래스 내에 final 키워드가 붙어 있어서 오버라이딩할 수 없다.
- object.getClass()는 객체를 생성하기 위해 new와 함께 사용됐던 representation of the class를 반환한다.  

```
Employee employeeObject = new Employee();
HourlyEmployee hourlyEmployeeObject = new HourlyEmployee();

employeeObject.getClass() == HourlyEmployee.class; // false
employeeObject instance of Employee // true
hourlyEmployeeObject instance of Employee // true
employeeObject instance of HourlyEmployee // false
hourlyEmployeeObject instance of HourlyEmployee // true
```
