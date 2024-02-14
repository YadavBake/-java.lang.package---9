
class TestAuto 
{
	static Integer I = 10;// Primitive to Wrapper Object AutoBoxing
	
	public static void main(String args[])
	{
		int i = I; // Wrapper object to Primitive AutoUnboxing
		m1(i);
	}
							//|----------// Primitive to Wrapper Object AutoBoxing
	public static void m1(Integer k)
	{
		int m = k; // Wrapper object to Primitive AutoUnboxing
		
		System.out.println(m);
	}
} // 10