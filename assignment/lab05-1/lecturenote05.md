## Static Methods
- A static method is one that can be used without a calling object
- A static method still belongs to a class, and its definition is given inside the class definition

## Pitfall: invoking a Nonstatic Method within a Static Method
- A static method cannot refer to an instance variable of the class,
  and it cannot invoke a nonstatic method of the class
  - static 메서드는 'this를 갖지 않는다. 그래서 this를 명시/암시적으로 갖는 메서드나 인스턴스 변수를 사용할 수 없다.
  - 대신 statc 메서드는 다른 static 메서드를 호출할 수 있다.

## Tip: You can Put a main in any Class
- 비록 메인 메서드를 종종 그 자체로 하나의 클래스로 다른 클래스와 분리하지만, main 메서드도 다른 일반 클래스 정의에 포함될 수 있다.
- 하나의 클래스에 메인 메서드와 일반 메서드가 섞여 있어도 된다.

## Static Variables
- 스태틱 변수는 클래스 전체에서 공유하는 변수이다.
- 모든 클래스의 오브젝트는 스태틱 변수의 값을 읽고 변경할 수 있다.
- 스태틱 메서드는 인스턴스 변수에 접근할 수 없지만, 스태틱 변수에는 접근할 수 있다.
- 스태틱 변수는 인스턴스 변수처럼 선언되며 static이라는 접근 지정자가 추가로 붙는다. ```priviate static int var```
- 스태틱 변수는 선언과 초기화를 동시에 할 수 있다.
- 만약 명시적으로 초기화 하지 않으면 default value(널 또는 0)으로 초기화 된다.
- 명시적으로 초기화하는 것이 선호된다.
- 스태틱 변수는 항상 private으로 초기화 되어야 한다. 만약 constant로 선언된 것이 아니라면(if 절)
  - ```public static final int BIRTH_YEAR =1954``` <- 이 경우 public으로 선언 가능 ~~(private but not final인 경우 가능)~~ (상수로 선언된 경우 퍼블릭 가능)
- ```int year = MyClass.BIRTH_YEAR``` 이런 식으로 정의된 상수를 참조한다. (호출하는 오브젝트 대신 클래스 이름 사용)

## The Math Class
- Math class는 표준 수학 관련 메서드를 제공한다
  - java.lang 패키지에 포함돼 있어서 import할 필요가 없다.
  - 모든 메서드랑 데이터는 static이라 호출할 때 오브젝트 이름 대신 Math 클래스 이름을 사용한다.
  - Math class는 사전에 정의된 상수를 갖는다 (E와 PI) ```area = Math.PI * r * r```

## Some Methods in the Class Math
- ```double pow(double base, double exponent)```
- abs(자료형 별로 오버로딩), min/max(자료형 별로 오버로딩), round(long, int를 반환함), 오버로딩 (double, int를 매개변수로)
- ```long round(double argument), int round(float argument)```
- ceil (double, double 인자, 반환값), floor, sqrt 
- floor or ceil결과물을 int에 저장하려면 형변환을 해야한다.

```
double exact = 7.56;
int lowEstimate = (int)Math.round(Math.floor(exact));
int highEstimate = (int)Math.round(Math.ceil(exact));
```
- round이용해서 정수로 변경. (6.9995를 7.0000으로 맞춰주기 위해서) (int)6.999995하면 7로는 안되나봐

## Random Numbers
- ```double num = Math.random()```
- return x where **0 <= x < 1.0** 

## Wrapper Classes
- Wrapper classes provide a class type corresponding to each of the primitive types
- Wrapper classes also contain a number of useful predefined constants and static methods
  - The wrapper class for the primitive type int is the predefined class Integer.  
  

- **Boxing**: the process of going from a value of a primitive type to an object of its wrapper class
  ```Integer integerObject = new Integer(42);```
- **unboxing**: the process of going from an object of a wrapper class to the corresponding value of a primitive type
  ``` int i = integerObject.intValue();``` 일종의 get method 

  ## Boxing

  - Integer for int
  - Byte for vyte
  - Short for short
  - Long for long
  - Float for float
  - Doubler for double
  - Character for char

  ```
  Integer numberOfSamuri = new Integer(47);
  Double  price = new Double(499.99);
  Character grade = new Character('A');
  ```

## Unboxing
- typeValue for the class type (intValue for the class Integer)
``` double d = price.doubleValue()```

## Automatic Boxing and Unboxing
- Starting with version 5.0, Java can automatically do boxing and unboxing
- Instead of creating a wrapper class object using the new operation (as shown before),
  it can be done as an automatic type cast:
``` Integer integerObject = 42;``` (new를 사용하지 않음)
  
``` int i = integerObject;``` (intValue 메서드 사용할 필요 없음)

```
Double price = 19.90
price = price + 5.12;
```
위 코드는 double형이 아니라 래퍼 클래스 타입이다.
맨 아래 코드는 ```price = new Double(price.doubleValue() + 5.12)```와 같다

## Constants and Static Methods in Wrapper Classes
- 래퍼 클래스는 자료형 별 유용한 상수 (최소/최대값)을 제공한다. ```Integer.MAX_VALUE```
- static 메서드인 **parseDouble**는 문자열을 double형으로 바꾼다.
- 메서드 **trim**은 앞, 뒤에 존재하는 화이트스페이스를 다듬어서 제거한다.
- **toString** 함수도 존재한다 ^_^
- The Character class contains a number of static methods that are useful for string processing
- 래퍼 클래스의 스태틱 메서드를 사용하기 위해 오브젝트 이름이 필요 없다. (그러므로 생성자 호출이 전혀 필요없다)
