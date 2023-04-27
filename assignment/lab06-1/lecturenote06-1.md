## import Statements

import java.util.Scanner (java.util packcage에서 스캐너 사용)  
import java.uitl.* (모든 클래스 사용)
- 2번째처럼 해도 importing the entire package에 대한 추가적인 오버헤드는 없다

- To make a package, group all the classes together into a single directory,
and add the following package statemnt to the begging of each class file:
package package_name;

## The package java.lang
- 자바 프로그래밍의 기초가 되는 클래스들을 포함한다
- 자동으로 import된다.
- math, string 래퍼 클래스 등을 포함한다.

## 패키지이름과 디렉토리
- 패키이 이름은 디렉토리 경로 이름이거나 패키지 클래스를 포함하는 서브디렉토리 경로 이름이다.
- 자바는 패키지를 위한 디렉토리를 찾기 위해 두가지가 필요하다. 패키이 이름과 패키지 경로 변수(CLASSPATH)이다.
- (ch 5-5 3분 참고)

## Piftall: 서브디렉토리는 자동으로 임포트 되지 않는다

## 디폴트 패키지
- 현재 디렉토리의 모든 클래스는 디폴트 패키지에 속한다.
- 현재 경로가 CLASSPATH 변수에 등록돼있으면, 디폴트 패키지에 있는 모든 클래스가 사용가능하다.
- 만약 CLASSPATH 변수가 설정돼 있으면, 현재 경로는 반드시 대안중 하나로 포함해야 한다.
  - 그렇지 않으면 .class 파일을 찾지 못한다.
- 만약 클래스경로 변수가 설정돼 있지 않으면 현재경로의 모든 클래스 파일을 현재 디렉토리에 넣어야 한다

## @Tags
- 태그는 다음과 같은 순서로 포함돼야 한다.
- 교과서 참고하래 자세한 내용은.

## javadoc
- 교과서나 웹에 더 자세한 정보 있대

---

## 배열
- double [] score = new double[5];
- 배열을 명시적을 초기화 하지 않으면 해당 타입에 맞는 디폴트 값으로 초기화 된다. (널 또는 0)

## Pitfall An Array of Characters Is Not a String
- char[a] = {'a', 'b', 'c'};
- String s = a; (서로 타입이 달라서 할당이 안된다)
- String s = new String(a); 이렇게는 가능하다.
- //h s2 = String(a, 0, 2) -> ab 문자 생성
- System.out.println(a); -> 출력 abc 나오긴 함.


## 배열과 레퍼런스
- 배열은 객체다.
- 배열 타입은 클래스 타입으로 간주된다.
- a = new double[10]; a변수에 배열 객체의 레퍼런스를 담는다 (메모리 주소의 레퍼런스)

## Pitfall: Arrays with a Class Base Type
- Date[] a = new Date[20];
- 위 코드 전부 널로 초기화됨. 객체 20개를 생성하지 않음.
```
Date[] a = new Date[20];
for i in range:
  a[i] = new Date();
```

holiday -> ㅁㅁㅁㅁㅁㅁㅁ Date[20] 가리킴
각 ㅁ를 각각 동적할당을 해야 ㅁ->date객체 가리킴

## 배열을 매개변수로
- BaseType[]만 넘겨주면 된다 (배열 크기는 전달할 필요 없음)

## 배열
- 할당연산자쓰면 두 변수가 하나의 같은 객체를 가리키게 됨.
- a변수의 메모리 주소랑 b변수의 메모리 주소가 같게 된다.

```
double[] a = new double[10];
double[] b = new double[10];
a-> ㅁㅁㅁㅁㅁ
b-> ooooooo
b = a하면 b->ㅁㅁㅁㅁㅁ 가 됨
```
- == 연산자도 두 변수가 같은 객체를 가리키는지만 검사한다
- 배열 모든 요소가 같은지 알고싶으면 equals 메서드를 사용하면 된다

## 메서드가 배열을 반환하는 경우
- 배열 매개변수와 같은 방식으로 동작한다.

## 부분적으로 채워진 배열
- 정확한 배열 사이즈를 항상 미리 알 수 있는 건 아니다.
- 배열 크기를 충분히 크게 하고 일부만 사용한다.

## accessor 메서드는 인스턴스 변수를 반환할 필요는 없다
- 인스턴스 변수가 배열을 가리키면, accessor가 전체 배열을 항상 반환할 필요는 없다.
- 대신 다른 accessor 메서드가 배열과 그 원소에 관한 충분한 정보를 제공해야 한다.  

## accessor 메서드는 단순히 객체 변수를 반환할 필요가 없다
- 요소 하나만 반환하는 함수는 존재함.
- 대신 다른 메서드가 배열과 그 원소에 관한 충분한 정보를 제공해야한다.