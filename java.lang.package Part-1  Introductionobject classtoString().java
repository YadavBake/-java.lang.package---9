						
									java.lang.package Part-1  Introductionobject classtoString()
								  ================================================================

---------------------
  Java.lang.package	
---------------------

 1. Introduction.
 2. Object class.
 3. String class.
 4. StringBuffer class.
 5. StringBuilder class.
 6. wrapper class.
 7. Autoboxing and AutoUnboxnig. 
 
 
 ==================
  1. Introduction.
 ==================

 -> For writing any java program whether it is simple or complex the most commanly required classes and interfaces are 
	grouped into a separet package which is nothing but java.lang package.
	
 -> We are not required to import java.lang package explicitly because all classes and interfaces prasent in lang package
	by default available to every java program.	

 ============================
  2. java.lang.Object class.
 ============================
 
 -> The most commanly required methods for every java class (Whether it is pre-defined class or Customized class) are 
	define in a separet class which is nothing but Object class.
	
 -> Every class in java is the child class of object either directly or indirectly so that object class methods by default
    available to every java class.
	
 -> Hence  a object class is considard as Root of all java classes.
 
 Note:
	
	1. If our class doesn't extend any other class then only our class is the directly child class of Object 
 
				Ex.
					
                    					  --------	
                                          |Object|	
                    class A {	          --------  
                                          	   |  	
                    }               -------	   |  	
                                    |  A  |-----	
                        			-------			
                    				 valid 			
                    								
	2. If our class extends any other class then our class is indirect child of class Object.
 
	Ex.
	
						-------		  --------					Object 
						|  B  |	      |Object|          		   ^	
	class A extends B   -------       --------        			   |	
	{						|         	   |            		   |	
							|   -------	   |            		   B
	}						----|  A  |-----            		   ^ 
								-------                 		   |	
							 Multiple Inheritance 				   |	
								but it is invalid 				   A 
														Multi-Level Inheritance 		
	
  Conclusion 
	
	- Either directly or indirectly java won't provide support for Multiple Inheritance with respect to classes.
	
	
 -> Object class defines the following 11 methods.
 
 
	1. public String toString()
	2. public native int hashCode()
	3. public boolean equals(Object o)
	4. protected native Object clone() throws CloneNotSupportedException
	5. protected void finalize()throws Throwable
	6. public final class getClass()
	7. public final wait() throws InterruptedException
	8. public final native void wait(long ms) throws InterruptedException
	9. public final void wait(long ms int ms) throws InterruptedException
   10. public native final void notify()	
   11. public native final void notifyAll()


 Note: Stricaly speeking object class containes 12 method the extra method is:
 
 
		private static native void registerNatives();
		
		- This method internally required for object class and not available to the child classes hence we are not required
		  considard these method.
		  

	import java.lang.reflect.*;													output:
	class Test                                                                  
	{	                                                                        finalize
		public static void main(String args[]) throws Exception                 wait0
		{                                                                       equals
			int count = 0;	                                                    toString
			Class c = Class.forName("java.lang.Object");                        hashCode
			Method[] m = c.getDeclaredMethods();                                getClass
			for(Method m1:m)                                                    clone
			{                                                                   notify
				count++;                                                        notifyAll
				System.out.println(m1.getName());                               wait
			}                                                                   wait
			System.out.println("The number of methods : "+count);               wait
		}                                                                       The number of methods : 12
	}
	
 --------------	
  1. toString	
 --------------

 -> We can use toString() method to get String reprasentation of an object.
 
		String s = Obj.toString();
		
 -> Whenever we are trying to print object reference enternaly toString() method will be called.
 
		Eg.
		
			Student s  = new Student();
			System.out.println(s); ==> Enternal reprasentation is => System.out.println(s.toString());

 -> If our class doesn't containe toString() method then object class toString() method will be executed.  
 
	Ex.
 
 
		class Student 
		{
			String name;											  --------	 	   --------	
			int rollno;											s1--->|Durga |	 s2--> |Ravi  | 
			                                                          |101   |         |102   |
			Student(String name , int rollno)						  -------- 	 	   --------
			{                                                                   
				this.name=name;
				this.rollno=rollno;
			}
			public static void main(String args[])					
			{														
					Student s1 = new Student("Durga",101);			
					Student s2 = new Student("Ravi".102);           
					System.out.println(s1);                         
					System.out.println(s1.toString());              
					System.out.println(s2);
					System.out.println(s2.toString());
			}
		}
 
			/*output:	
	        			
            	Student@2f92e0f4
                Student@2f92e0f4
                Student@28a418fc
                Student@28a418fc*/	
	
 -> In the above example Object class toString() got executed which is implemented as follow :

	
	public String toString()
	{
		return getClass().getName()+"@"+Integer.toHexString(hashCode());
	}
	
	// className@hashCode_in_hexadecimalform
 
 -> Based on our requirement we can override toString() to provide our own String reprasentation for example whenever 
	we are trying to print student object reference to print his name and rollno we have to override toString() 
	method as follows below 
	
		public 	String toString()
	    {
	    	//return name+"...."+rollno;
	    	return "This is student with name "+name+ "	and Rollno" +rollno;
        }
		
		
	Ex.
 
	class Student 
	{
		String name;								
		int rollno;									
	                                              
		Student(String name , int rollno)			
		{                                             
			this.name=name;
			this.rollno=rollno;
		}
		public 	String toString()
		{
			//return name+"...."+rollno;
			return "This is student with name "+name+ "	and Rollno" +rollno;
		}
			public static void main(String args[])
			{
				Student s1 = new Student("Durga",101);
				Student s2 = new Student("Ravi",102);
				System.out.println(s1);
				System.out.println(s1.toString());
				System.out.println(s2);
				System.out.println(s2.toString());
			}
	}
	
 -> In all wrapper classes, In all Collection classes, String class, String Builder classes and String Buffer classes 	
    toString() method is overriden for meaning full String reprasentation hence a it is highly recomanded to override 
	toString() method in our class also.
	
	Ex.
	
	import java.util.*;
	class Test 
	{
		public String toString()
		{	
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
	

	