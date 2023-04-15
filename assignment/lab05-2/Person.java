import javax.lang.model.util.ElementScanner14;

public class Person {
	private String name;
	private Date born;
	private Date died;

	public Person(String name, Date birth, Date death)
	{
		if (consistent(birth, death))
		{
			this.name = name;
			born = new Date(birth); // 이게 중요하대 (새 오브젝트를 생성)
			if (death == null)
				died = null;
			else
				died = new Date(death);
		}
		else{
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	public Person(Person original) // 복사생성자
	{
		if (original == null)
		{
			System.out.println("Fatal error.");
			System.exit(0);
		}
		name = original.name;
		// born = original.born; -> 이렇게 쓰지 말래 절대 안된대!
		// 복사 객체가 원본을 바꿔버릴 수도 있음
		born = new Date(original.born); // born 과 died 새로 복사 반드시!
		if (original.died == null)
			died = null;
		else
			died = new Date(original.died);
	}

	public String toString()
	{
		String diedString;
		if (died == null)
			diedString = ""; // 빈 문자열
		else
			diedString = died.toString();
		return (name + ", " + born + "-" + diedString);
	}

	public boolean equals(Person otherPerson)
	{
		if (otherPerson == null)
			return false;
		else
			return (name.equals(otherPerson.name)
					&& born.equals(otherPerson.born)
					&& datesMatch(died, otherPerson.died));
	}

	private static boolean datesMatch(Date date1, Date date2)
	{
		if (date1 == null)
			return (date2 == null); // 둘 다 널이면 트루 리턴
		else if (date2 == null)
			return (false);
		else
			return (date1.equals(date2));
	}

	public void setBirthDate(Date newDate)
	{
		if (consistent(newDate, died))
			born = new Date(newDate);
		else
		{
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	public void setDeathDate(Date newDate)
	{
		if (!consistent(newDate, died)) //맞나?
		{
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
		if (newDate == null)
			died = null;
		else
			died = new Date(newDate);
	}

	public void setName(String newName)
	{
		name = newName; // 레퍼런스를 그대로 복사, immutable 타입이래
	}

	public void setBirthYear(int newYear) // mutator
	{
		if (born == null) // 더블체크가 안전하대
		{
			System.out.println("Fatal Error. Aborting");
			System.exit(0);
		}
		born.setYear(newYear); // Date 클래스에 있는 함수
		if (!consistent(born, died))
		{
			System.out.println("Inconsistent dates. Aborting");
			System.exit(0);
		}
	}

	public void setDeathYear(int newYear) // mutator
	{
		if (died == null) // 더블체크가 안전하대
		{
			System.out.println("Fatal Error. Aborting");
			System.exit(0);
		}
		died.setYear(newYear); // Date 클래스에 있는 함수
		if (!consistent(born, died))
		{
			System.out.println("Inconsistent dates. Aborting");
			System.exit(0);
		}
	}

	public String getName()
	{
		return (name);
	}

	public Date getBirthDate() //h
	{
		return new Date(born);
		/h return (born); <- 이렇게 하지 말래. 유저가 born에 접근가능해지니까 privacy leak
	}

	public Date getDeathDate()
	{
		if (died == null)
			return (null);
		else
			return (new Date(died));
	}

	private static boolean consistent(Date birthDate, Date deathDate)
	{
		if (birthDate == null)
			return (false);
		else if (deathDate == null)
			return (true);
		return (birthDate.precedes(deathDate)
				|| birthDate.equals(deathDate));
	}
}
