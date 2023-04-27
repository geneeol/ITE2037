## Referecnces

## Class Type Variables Store a Reference
- 변수 선언시 메모리상에 공간을 할당한다 (할당 전에도)
- 이제 new를 이용해 할당하면 변수 공간에는 해당 객체의 주소가 담겨있다.
- 변수의 이름이 곧 레퍼런스가 되는 것 같다?
- 할당연산시 전체 복사가 아니라 주소만 복사!
- (메모리 주소를 가리키는 포인터를 레퍼런스라고 하는듯)

```
ToyClass variable1;
ToyClass variable2;
variable1 = new ToyClass("Joe", 42); **변수에 4068이란 객체의 주소 할당**
variable2 = variable1; **변수에 4068이란 주소 할당**
```
이제 variable2를 변경하면 variable1도 변경된다.

## Class Parameters
- 모든 자바 매개변수는 call-by-value 방식이다
- class type 매개변수는 call-by-reference 매커니즘처럼 비슷하게 동작한다
- class type parameter은 메모리 주소와 연결된다
- **NOTE!** 여전히 call-by-value parameter 방식이다.
- 클래스 타입 매개변수 가해진 어떤 변화도, 그 자체로를 인자를 바꾸진 못한다.

## primitive와 class-type 매개변수의 차이
- 메서드는 인자로 전해진 기본형 타입 변수의 값을 바꾸진 못한다.
- 메서드는 인자로 전해진 클래스 타입의 인스턴스 변수의 값을 바꿀 수 있다.

## Pitfall: use of = and == with variables of a class type
- 클래스 타입 변수에서, 할당연산자(=)는 객체의 이름을 지정하는 두 개의 변수를 생성한다
- (==)연산자는 클래스타입 변수에서 다르게 동작한다. (주소끼리 비교하게 되는 개념인듯)

## The constant null
- 널은 특별한 상수로 아무 클래스 타입의 변수에 할당될 수 있다.
- 실제 값을 갖지 않음을 나타낸다
- 널은 오브젝트가 아니다, 차라리 placeholder에 가깝다.ㅁ(아무 메모리 공간도 지정하지 않는)

## Pitfall
- 널로 초기화된 객체는 메서드를 호출할 수 없다.
- 이러한 시도는 널포인터 예외를 발생시킨다.

## 익명 오브젝트
``` if (variable1.equals(new ToyClass("JOE", 42)))```
- 이렇게 해도 익명 객체 기능으로 인해 동작한대

## 레퍼런스의 잘못된 사용
- 프라이빗 인스턴스 변수는 프라이빗으로 남아야 한다
- 기본형 타입 인스턴스 변수에서, 프라이빗 접근지정자 선언은 반드시 정보 유출이 없음을 보장해야한다.
- 클래스 타입 인스턴스 변수에서는, 프라이빗 접근 지정자 하나만으로는 충분치 않다

## Designing A Person Class: Instance Variables
- Person 클래스의 인스턴스 변수가 클래스 타입일 때
- 주의점이 있나봐

## null 인자를 전할 때는 주의해야한다.

## 복사 생성자
- 복사 생성자는 단 하나의 인자로 같은 클래스 타입 변수를 받는다
- 복사 생성자는 오브젝트와 독립적인 객체를 생성해야 한다. 인스턴스 변수는 인자로 주어진 객체와 같아야 한다.
- Date 복사 생성자에서 primitive type private 인스턴스 변수는 단지 그냥 복사된다
- date1을 date2에 복사후 date2 수정해도 date1은 그대로이다.

## Pitfall: privacy leaks
- 클래스 복사생성자에서 클래스타입 private변수를 복사하지 않고 그냥 할당하면 생기는 문제점. 
- Person class 생성자 참고
- setBirthDate에서도 릭을 주의해야 한다

## Mutable and Immutable Classes
- getName 할 때 String class가 immutable이라 바로 return name 해도 됨
- 클래스가 객체내 값을 변경하려는 그 어떤 메서드도 없으면 immutable class이다.
- immutable 객체의 레퍼런스를 반환하는 것은 안전하다.
- String 클래스는 immutable class이다. 
- public mutator 메서드가 있거나, public 메서드가 오브젝트의 데이터를 바꿀 수 있으면 immutable이다.
- 메서드가 mutable object를 반환하게 하면 절대 안된다
- 대신에 복사 생성자를 이용해 반환하게 해야한다.
```
String greeting = "Hello"
String helloVariable = greeting;
greeting = greeting + "friend."
helloVariable는 변하지 않는다!
```

## 깊은 복사, 얕은 복사
- 깊은 복사는 단 한개의 예외를 제외하고는 어떤 레퍼런스도 원본과 공유하지 않는다
- 예외: 레퍼런스가 immutable object라면 공유하는게 가능하다
- 얕은 복사: privacy leaks를 발생시킬 수 있다. 