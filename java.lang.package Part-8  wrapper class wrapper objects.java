	
									 java.lang.package Part-8 || wrapper class||wrapper objects
								==================================================================

---------------
 Wrapper Class 
---------------

 -> The main objective of wrapper classes are.

	1. To wrappe primitive into object form so that we can handle primitives also just like objects.
	
	2. To define several utility methods which are required for the primitives.
	
--------------
 Constructors 
--------------
 
 -> All most all wrapper classes containes two contructors one can take currusponding primitive as argument and the other 
	can take String as argument.

	Ex. 1 
								|----> int primitive
	1. Integer I = new Integer(10);
	
	2. Integer I = new Integer("10");
								 |-----> String 
    
	Ex 2 
	
	1. Double D  = new Double(10.5);
	
	2. Double D = new Double("10.5");

 -> If the String argument not reprasenting a number then we will get runtime exception saying NumberFormatException.

		Ex. 
		
			1. Integer I = new Integer("ten");//RE: NumberFormatException	
	
 -> Float class containes three constructor with float,double,and String arguments.	
			
			
		Float F = new Float(10.5f); //valid 	
		Float F = new Float("10.5f");// valid 	
		Float F = new Float(10.5);	//valid 
		Float F = new Float("10.5");//valid 		
			
 -> Charcter class containes only one constructor which can take char argument 

		Charcter ch = new Charcter ('a'); //valid 
		Charcter ch = new Charcter ("a"); //invalid 

 -> Boolean class containes two constructors one can take primitive as argument and the other can take String argument.
	If we pass boolean primitive as argument the only allowed values are true or false. Where case is importants and 
	content is also important.


		Boolean b = new Boolean(true);//valid
		Boolean b = new Boolean(false);//valid 
		Boolean b = new Boolean(True);//invalid CE: 
		Boolean b = new Boolean(durga);//invalid 
		

  Ex. 
	
	-> If we are passing string type as argument then case and content both are not important.
	
	-> If the content is case insensitive string "true" then it is treated as true otherwise it is treated as false.


			Boolean x = new Boolean("true"); ==> true 	
			Boolean x = new Boolean("True");===> true 	
			Boolean x = new Boolean("TRUE");===> true 	
			Boolean x = new Boolean("malaika");=>false	
			Boolean x = new Boolean("mallika");=>false 
			Boolean x = new Boolean("Jareena");=>false 
			
	
					Boolean x = new Boolean("Left");
					Boolean y = new Boolean("no");
					System.out.println(x);//false 
					System.out.println(x);//false 
					System.out.println(x.equals(y));//true
					
					
					
					1. Complie time error.
					2. Runtime Exception.
					3. true //valid 
					4. false

 Summart Table 
 
	-------------------------------------------------------		
	|   Wrapper class |	Corresponding constructor argument|
	-------------------------------------------------------
	|  1. Byte 		  |	 byte or String 				  |
	|                 |                                   |
	|  2. Short 	  |  short or String                  |
	|                 |                                   |
	|  3. Integer 	  |	 int or String                    |
	|                 |                                   |
	|  4. Long 		  |	 long or String                   |
	|				  |									  |
	|  5. Floa  	  |	 float ,double or String          |
	|	              |                                   |
	|  6. Double 	  |	 double or String 	              |
	|                 |                                   |
	|  7. Charcter 	  |	 char                             |
	| 				  |									  |
	|  8. Boolean 	  |  boolean or String 				  |
	-------------------------------------------------------
	  

 Note:

	- In all wrapper classes toString() method is overriden to return content directly 	  
    
    - In all wrapper classes .equals() method is overriden for content compairesion.
	
	
 =================  
  Utility Methods 
 =================

  1. valueOf()
 --------------

	-> We can use valueOf() methods to create wrapper object for the given primitive or String.
	
	-> Every wrapper class except charcter class containes a static valueOf() method to create object for the given 
	   String.
	   
			-----------------------------------------
			|public static wrapper valueOf(Strign s)|
			-----------------------------------------
		
	   
		FORM 1: 
															Integer I = new Integer(10);
			Integer I = Integer.valueOf("10");              			or 
			Double D = Double.valueOf("10.5");              Integer I = Integer.valueOf(10);
			Boolean B = Boolean.valueOf("durga");           			or 
	                                                        Integer I = Integer.valueOf("10");
		
		FORM 2:
		
			- Every integeral type wrapper class (Byte,Short,Integer,Long) containes the following valueOf() method to 
			  create wrapper object for the given specified radix String.	
	
						----------------------------------------------------
						|public static wrapper valueOf(Strign s, int radix)|
						----------------------------------------------------
						
						- The allowed range of radix is 2 to 36.
						
			eg:			
			
			class Test 
			{
				public static void main(String args[])
				{
			
					Integer I = Integer.valueOf("1111");
					System.out.println(I);//1111
					
					Integer I1 = Integer.valueOf("1111",2);
					System.out.println(I1);//15
				}
			}
		
		FORM 3:

			-> Every wrapper class including charcter class containes a static valueOf() method to create Wrapper object 
			   for the given primitive 
			   
				--------------------------------------------
		        |public static wrapper valueOf(Primitive p)|
			    --------------------------------------------
				

				class Test 
				{
					public static void main(String args[])
					{
						Integer I = Integer.valueOf(10);
						Charcter ch  = Charcter.valueOf('a');
						Boolean b = new Boolean.valueOf(true);
					}
				}
				
				
				
		-------------					  -------------	
		| Primitive |    valueOf()        |   Wrapper |
		| /String 	|-------------------> |   Object  |	
		|		    |                     |		      |
		|		    |                     |		      |
		-------------		              -------------
				
----------------				
  2. XxxValue()
----------------

 -> We can use XxxValue() methods to get primitive for the given wrapper object 


	-------------				  -------------	
    |   Wrapper |  XxxValue()     | Primitive |
    |   Object  |---------------> | /String   |
    |		    |                 |		      |
    |		    |                 |		      |
    -------------                 -------------


 -> Every Number type wrapper class(Byte,Short,Integer,Long,Double,Float) containes the following six methods to get 
	primitive for the given wrapper object.
	
	
		public byte byteValue()
	    public short shortValue()
	    public int 	intValue()
	    public long longValue()
	    public float floatValue()
        public double doubleValue()
		
		
		
	class Test 
	{
		public static void main(String args[])						------------
		{                                                           | Integer  |.byteValue()
                                                                    | Byte     |.shortValue()
				Integer I = new Integer(130);                       | Short    |.intValue()
				System.out.println(I.byteValue());//-126            | Long	   |.longValue()
				System.out.println(I.shortValue());//130            | Float    |.floatValue()
				System.out.println(I.intValue());//130              | Double   |.doubleValue()
				System.out.println(I.longValue());//130             ------------
				System.out.println(I.floatValue());//130.0
				System.out.println(I.duobleValue());//130.0
		}
	}
	
--------------	
  charValue()
--------------

	-> Charcter class containes charValue() method to get char primitive for the given charcter object.
	
		-------------------------
		|public char charValue()|
		-------------------------
		
		eg:
		
		Charcter ch = new Charcter('a');
		char c = ch.charValue();
		System.out.println(c);// 'a'
    
 ----------------   
  booleanValue() 
 ----------------

  -> Boolean class containes booleanValue() method to get boolean primitive for the given boolean objet. 
    
	
			-------------------------------
            |public boolean booleanValue()|
            -------------------------------
			
			Boolean B = new Boolean('a');
			boolean b = b.booleanValue();
            System.out.println(b);// false
			
			
			
			-------------				  -------------	
			|   Wrapper |  XxxValue()     | Primitive |
			|   Object  |---------------> | /String   |
			|		    |                 |		      |
			|		    |                 |		      |
			-------------                 -------------
			


 Note: 
 
	- In total 38( = 6*6+1+1) XxxValue() methods are possible.
  
  3. parseXxx()
  
  4. toString()
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  