
										java.lang.package Part-10 || Autoboxing||Autounboxing-1
									 ============================================================

 -------------
  Autoboxing 									 
 -------------

 -> Automatic conversion of primitive to wrapper object by compiler is called Aotuboxing.
 
		Eg:	

		Integer I = 10; [Compiler converts int to Integer Automatically by Aotuboxing ]
		
							|
							|
				After compilation this line become 
		
	- After compilation the above line will become :	
	
		Integer I = Integer.valueOf(10); // Compiler is responsible to place this line 
	
	- That is Enternally Autoboxing concept is implemented by using valueOf() method.
	
 --------------	
  AutoUnboxing
 --------------
 
	-> Automatic conversion of wrapper object to primitive by compiler is called AutoUnboxing.
	
	
	
		Eg:

		Interger I = new Integer(10);
		 int i = I; [ Compiler converts Integer to int aotumatically by AutoUnboxing ]
			
			|
			|
		After compilation this line become 		
	
	- After compilation the above line will become :
	
		int  i = I.intValue();
		
	- That is Enternally autounboxing concept is implemented by using XxxValue() methods.


		
		----------------		AutoBoxing[valueOf()]	----------------
		|			   |------------------------------>	|			   |
		|primtive value|                                |Wrapper Object|
		|			   |<------------------------------	|			   |
		----------------	AutoUnboxing[XxxValue()]    ----------------
		
		
  Ex. 1


		class Test 
		{
			static Integer I = 10;// Primitive to Wrapper Object AutoBoxing
			
			public static void main(String args[])
			{
				int i = I; // Wrapper object to Primitive AutoUnboxing
				m1(i);
			}
									|----------// Primitive to Wrapper Object AutoBoxing
			public static void m1(Integer k)
			{
				int m = k; // Wrapper object to Primitive AutoUnboxing
				
				System.out.println(m);
			}
		} // 10
		
		
	 - The above code is valid in 1.5 and above version but  invalid in 1.4v or lower version.
	 
	 
 Note: 

	- Just because of AutoBoxing and AutoUnboxing we can use primitive and wrapper object interchangeably from 1.5v verison
	  onwords.
		
		
  Ex. 2

		class Test
		{
			static Integer I = 0;
			
			public static void main(String args[])
			{
				int m = I;
				System.out.println(m);
			}
		}
		
		
		class Test 
		{
			static Integer I;
			
			public static void main(String args[])
			{															//|---> Here JVM will provide default null for I 		
				int m = I; // after compilation this line become  int m = I.intValue()
																		  |
				System.out.println(m);									 null 
			}
		} // RE; NullPointerException 
		
		
	Note:

		- On null reference if we are trying to perform AutoUnboxing then we will get runtime exception saying 
		  NullPointerException.
		  
	
	
	Ex. 3
	
		class Test 
		{
			public static void main(String args[])			|-----------------------
			{												|					   |
															| 	 -------- 		--------
				Integer X = 10;								x-X->|		|       |		|
				Integer Y = X;									 |  10  |	    |  11   |
				X++;										y--->|	    |       |	    |
				System.out.println(X); // 11					 --------	    --------
				System.out.println(Y); // 10
				System.out.println(X==Y); //false 
			}
		}
			
		
	- All wrapper class objects are immutable that is once we creates wrapper class object we can't perform any changes 
	  in that object.
	  
	- If we are trying to perform any changes with thoughs changes a object will be created.
		
		
		
		
	Ex. 4 


			class Test 
			{
				public static void main(String args[])				------
				{												x-->| 10 | 
					Integer x = new Integer(10);					------	
					Integer y = new Integer(10);					------
					System.out.println( x == y); //false 	    y-->| 10 |
																	------
					
																	------
					Integer x = new Integer(10);				x-->| 10 |
					Integer y = 10;                             	------
					System.out.println(x == y);//false          	------
					                                            y-->| 10 |
					                                            	------
																	 ------
					Integer x = 10;								x--->|    |
					Integer y = 10;								y--->| 10 |		
					System.out.println(x == y);//true				 ------	




					Integer x = 100;								 ------
					Integer y = 100;                            x--->|    |
					System.out.println(x == y);//true           y--->| 100|
		                                                        	 ------
																	 
																	--------				
					Integer x = 1000;					        x-->| 1000 |
					Integer y = 1000;                           	--------
					System.out.println(x == y);//false          	--------
				}                                               y-->| 1000 |
			}                                                   	--------
		
		
  Conclusion 

		- Internally to provide support for AutoBoxing a buffer of wrapper object will be created at the time wrapper
		  class loading
		  
		- By AutoBoxing if an object is required to create first JVM will check whether this object already prasent in
		  the buffer or not if it already prasent in the buffer then exisiting buffer object will be used.
		  
		- If it is not already available in the buffer then JVM will create a new object.
		
			Ex. 
		
				class Integer {
					
					static 
					{
					
				----------------------------------
		        |-125 | -126 | 	10  |  100 | 127 |  
				----------------------------------
								^ ^   ^ ^ 
								| |	  | | 
								x y   x y
								
					}
				}
				
		
		- But buffer concept is available only in the following ranges.

			Byte ----> always 
			Short ---> -128 to 127
			Integer--> -128 to 127
			Long ----> -128 to 127
			Charcter->    0 to 127
			Boolean -> always
			
			
		- Except this range in all remaining cases a new object will be created.




			Integer x = 127;					Integer x = 128;					Boolean x = false;
			Integer y = 127;                    Integer y = 128;                    Boolean x = false;
			System.out.println(x==y); //true    System.out.println(x==y);//false    System.out.println(x==y);// true 
			
				
			Double x = 10.0;
			Double y = 10.0;
			System.out.println(x==y);//false 	
			
		
		- Internally AutoBoxing concept is implemented by using valueOf() methods hence a buffering concept is 
		  applicable for valueOf() method also.
		  
		  
		  
		  Integer x  = new Integer(10);				Integer x  = new Integer(10);
		  Integer y  = new Integer(10);             Integer y  = 10;
		  System.out.println(x==y); //false         System.out.println(x==y);//true 
		  
		  Integer x  = Integer.valueOf(10);			Integer x  = 10;
		  Integer y  = Integer.valueOf(10);         Integer y  = Integer.valueOf(10);
		  System.out.println(x==y);// true          System.out.println(x==y);//true
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  