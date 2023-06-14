public class YourCloneableClass2 implements Cloneable
{
	// somedate는 반드시 카피로 해야함
	private Date somedate;
	private int a;
	private String b;

	public Object cloen()
	{
		try
		{
			YourCloneableClass2 copy = (YourCloneableClass2)super.clone();
			// 메서드 clone을 somedate 클래스가 갖고 있어야 가능 
			copy.somedate = (Date)somedate.clone();
			return (copy);
		}
		catch (CloneNotSupportedException e)
		{
			return (null);
		}
	}
	
}
