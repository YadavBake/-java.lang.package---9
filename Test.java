/*import java.lang.reflect.*;
class Test {
		
		public static void main(String args[]) throws Exception
		{
			int count = 0;	
			Class c = Class.forName("java.lang.Object");
			Method[] m = c.getDeclaredMethods();
			for(Method m1:m)
			{
				count++;
				System.out.println(m1.getName());
			}
			System.out.println("The number of methods : "+count);
		}
	}*/
	import java.util.*;
	class Test 
    {
		
    	public String toString(){
			
			return "Test";
		}
    	
    	
    	public static void main(String args[])
    	{
    		String s = new String("Durga");
    		System.out.println(s);//Durga
    		
    		Integer i = new Integer(10);
    		System.out.println(i);// 10 
    		
    		ArrayList l = new ArrayList();
    		l.add("A");
    		l.add("B");
    		System.out.println(l); //[A,B]
    		
    		Test t = new Test();
    		System.out.println(t);
    	}
    }