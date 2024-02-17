class 	Test5 implements Cloneable
		{
			int i = 10;
			int j = 20;
			
			public static void main(String args[])throws CloneNotSupportedException
			{
				Test5 t1 = new Test5();
				Test5 t2 = (Test5)t1.clone();
				t2.i = 888;
				t2.j = 999;
				System.out.println(t1.i+"...."+t1.j);
			}
			
		}