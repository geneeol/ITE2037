## for each loop
- 스탠다드 자바 라이브러리는 많은 acollection classes를 포함한다.
- 원래의 for loop는 collection object의 원소를 순회하지 못한다.
- for-each loop를 통해 순회 가능하다!

**배열에서의 사용 예시**
```
for (Array_Base_Type Variable : Array_Name)
	statement
```

위 방법을 선호한다.
```
for (double elem : a)
	sum += elemnt;

for (int i = 0; i < a.length; i++)
	sum += a[i];
```

for loop를 그대로 써야하는 경우
```
for (int i = 0; i < a.length; i++)
	a[i] = 2 * i;
```

## Privacy Leaks with Array Instance Variables
- 만약 accessor 메서드가 배열의 컨텐츠를 리턴한다면, 특별히 유의해야 한다.
  - accessor가 프라이빗 오브젝트의 레퍼런스를 리턴하는 경우

```
public double[] getArray()
{
	return anArray; // BAD!
}
```

- 대신에 accessor method는 deep copy한 오브젝트의 레퍼런스를 반환해야한다.
```
public double[] getArray()
{
	double[] tmp = new double[count];
	for ()
		tmp[i] = a[i];
	return tmp
}
```

## Sorting an Array
- 배열 매개변수를 받은 후, a를 오름차순으로 정렬
```public static void sort(double[] a, int numberUsed)```

## Enumerated Types Example
- Given the following definition of an enumerated type:
  ```enum WorkDay {MONDAY, ... , FRIDAY}```
- 변수는 다음과 같이 선언 가능
```WorkDay meetingDay, avaliableDay;```
- 변수는 다음과 같이 초기화 가능
```
meetingDay = WorkDay.THURSDAY;
avaliableDay = null;
```
- 선언과 동시에 초기화도 가능하다.
- println(meetingDay) 결과값: THUSRDAY
- Note: 타입이름인 WorkDay는 output이 아니다.

## Enumerated Type Usage
- 두 변수는 equals 혹은 '=='로 비교가능하다.
- 그러나 == 연산자가 더 나은 문법이다.
```
if (meetingDay == avaliableDay)
	statement;
```

- enum 함수들: equals, toString, ordinal(calling value의 포지션 리턴, 첫 포지션은 0)  
compareTo(enum 리스트에서 앞에 calling object가 앞에 있으면 음수 리턴, 같으면 0, 뒤에있으면 양수)

## Programming Tip: enum types in switch Statements
- enum을 switch문에 사용.

## Ragged Arrays
```double[][] a = new double[3][5]```
- This is equivalent to the following:
```
dobule[][] a;
a = new double[3][];
a[0] = new double[5]; // <- 이 괄호안 숫자가 각각 달라도 됨.
a[1] = new double[5];
a[2] = new double[5];
```
```
for (row < a.length)
	for (column < a[row].length)
```
