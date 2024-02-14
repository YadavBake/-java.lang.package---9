class TestAuto1 
			{
				public static void main(String args[])
				{
					Integer x = new Integer(10);
					Integer y = new Integer(10);
					System.out.println( x == y);

					Integer x1 = new Integer(10);
					Integer y1 = 10;
					System.out.println(x1 == y1);
					
					Integer x2 = 10;
					Integer y2 = 10;
					System.out.println(x2 == y2);


					Integer x3 = 100;
					Integer y3 = 100;
					System.out.println(x3 == y3);
		
					Integer x4 = 1000;
					Integer y4 = 1000;
					System.out.println(x4 == y4);
				}
			}