class TestAw 
		{
			public static void m1(Integer I )
			{

				System.out.println("Autobxing");
			}
			public static void m1(long l)
			{
				System.out.println("Widening");
			}
			
			public static void main (String args[])
			{
				int x = 10;
				m1(x);
			}
		}
					