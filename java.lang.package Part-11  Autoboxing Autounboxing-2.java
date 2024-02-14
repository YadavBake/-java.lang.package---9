
								      java.lang.package Part-11 || Autoboxing||Autounboxing-2
									 =========================================================

--------------------------------------------------------------------  
 Overloading with respect to Autobxing, widening And var-arg method 
--------------------------------------------------------------------

  Case 1: Autobxing Vs Widening 
  
	 
		
		class Test 
		{
			public static void m1(Integer I )<--------
			{										 |
                                                     |
				System.out.println("Autobxing");     |
			}										 |// This is overloaded methods	
			public static void m1(long l)			 |
			{                                        |
				System.out.println("Widening");      |
			}<----------------------------------------
			
			public static void main String args[])
			{
				int x = 10;
				m1(x);
			}
		} //Widening
								
		- Widening dominates Autobxing 
	
	
	
  Case 2: Widening Vs var-arg 	
  
  
		class Test 
        {
        	public static void m1(int... x )<--------
        	{										 |
                                                     |
        		System.out.println("var-arg method");|
        	}										 |// This is overloaded methods	
        	public static void m1(long l)			 |
        	{                                        |
        		System.out.println("Widening");      |
        	}<----------------------------------------
        	
        	public static void main String args[])
        	{
        		int x = 10;
        		m1(x);
        	}
        } //Widening
		
		
		- Widening dominates var-arg methods 
		
		
  Case 3: Autobxing vs var-arg method


		class Test 
		{
        	public static void m1(int... x )<--------
        	{										 |
                                                     |
        		System.out.println("var-arg method");|
        	}										 |// This is overloaded methods	
        	public static void m1(Integer I)		 |
        	{                                        |
        		System.out.println("Autobxing");     |
        	}<----------------------------------------
        	
        	public static void main String args[])
        	{
        		int x = 10;
        		m1(x);
        	}
        } //Autoboxing 
		
		
		- Autoboxing dominates var-arg methods.
		
		- In general var-arg method will get list priority that is if no other method matched then only var-arg method 
		  will get the chance. It is exactly same as default case in inside switch.
		  
		  
 Note: 
 
	- While resolving overloaded methods compiler will always gives the precidence in the following order.
	
	
		1. Widening.
		
		2. Autoboxing.
		
		3. var-arg methods.
		
		

	Ex.
	
		class Test
		{
			
			public static void m1(long l)
			{
				System.out.println("Widening");
			}
			public static void m1(Integer I)
			{
				System.out.println("Autoboxing");
			}
			public static void m1(int... i)
			{
				System.out.println("var-arg Method");
			}
			
				public static void main(String args[])
				{
					int x = 10;
					m1(x);
				}
				
		}
		
		
  Case 4: 
	
	
		class Test 															
		{                                                               		A.B 				invalid 
			public static void m1(Long l)                                |------------->Integer----->>----->> 
			{                                                            |									|
				System.out.prinln("Long");                               |									|
			}                                                            |									|
			public static void main(String args[])                      int 							  Long 	
			{                                                            |									^	
				int x = 10;                                              | 									|
				m1(x);                                                   |									|
			}                                                            |									|	
		} //CE: m1() (java.lang) in Test cannot be applied to to (int)   |------------>long-------->>-------- 
	                                                                        widening			A.B 
	                                                                    
		                                                                	Widening to Autoboxing // invalid 
		                                                                	
		                                                                	Autoboxing to widening //valid 
		
		
	- Widening followed by Autoboxing is not allowed in java where as Autoboxing followed by widening is allowed.

		Ex. 
		
			Long = 10;// invalid CE: imcompatible types found : int required : java.lang.Long 
			
			long l = 10; //valid widening
		
	

  Case 5: 

	
	class Test 									
	{                                           	
		public static void m1(Object o )           	
		{                                       					Autoboxing          Widening
			System.out.prinln("Object version ");          	    int------------>Integer------------>Object 
		}                                       	
		public static void main(String args[])      
		{                                       
			int x = 10;                         	
			m1(x);                              	
		}                                       	
	} //CE: m1() (java.lang) in Test cannot be a
	                                            
				
		Object o = 10; //valid 
		Number n = 10; //valid 
		
		
 Q. Which of the following Assignment are ligal ?

		int i = 10; //valid 
		Integer I =10; // valid Autoboxing
		int i = 10L;// invalid CE: Possible loss pricision found: Long required: int 
		Long l = 10L;// valid Autoboxing
		Long l = 10; // invalid  imcompatible types found: int required: Long 
		long i = 10;// valid widening
		Object o -10;// valid Autoboxing followed by widening
		double d = 10;// valid widening
		Double D = 10; // invalid imcompatible type found : int required : Double 
		Number n = 10; // valid Autoboxing followed widening.
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	