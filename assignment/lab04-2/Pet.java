import java.rmi.server.ServerNotActiveException;

public class Pet {
	private String	name;
	private int		age;
	private double	weight;

	public String toString()
	{
		return ("Name: " + name + "\nAge: " + age + " years" 
		+ "\nWeight: " + weight + " pounds");
	}

	public Pet() //h 생성자 앞 퍼블릭 키워드
	{
		name = "No name yet.";
		age = 0;
		weight = 0;
	}

	// init은 Pet생성자와 유사. 단 이건 일반 함수 pet은 생성자
	public void init()
	{
		name = "No name yet.";
		age = 0;
		weight = 0;
	}

	public Pet(String name)
	{
		init();
		setName(name);
		this.name = name;
		age = 0;
		weight = 0;
	}

	// double과 int차이 덕분에 오버로딩 된대
	public Pet(int age)
	{
		init();
		setAge(age);
	}

	public Pet(double weight)
	{
		init();
		setWeight(weight);
	}

	public Pet(String name, int age, double weight)
	{
		setName(name);
		setAge(age);
		setWeight(weight);
	}

	public void	setName(String newName)
	{
		name = newName;
	}

	public void setAge(int newAge)
	{
		if (newAge < 0)
		{
			System.out.println("Error: Negative age.");
			System.exit(0);
		}
		else
			age = newAge;
	}

	public void setWeight(double newWeight)
	{
		if (newWeight < 0)
		{
			System.out.println("Error: Negative weight.");
			System.exit(0);
		}
		else
			weight = newWeight;
	}

	public void	set(String name, int age, double weight)
	{
		setName(name);
		setAge(age);
		setWeight(weight);
	}

	public String getName()
	{
		return (name); //이렇게 해도 되나 this없이?
	}

	public int getAge()
	{
		return (age);
	}

	public double getWeight()
	{
		return (weight);
	}
}
