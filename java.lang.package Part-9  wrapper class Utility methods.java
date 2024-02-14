
									java.lang.package Part-9 || wrapper class||Utility methods
								=================================================================
			

 ---------------
  3. parseXxx()
 ---------------

 -> We can use parseXxx() methods to convert String to primitive.


		

	FORM 1:
	
		- Every wrapper class except charcter class containes the following parseXxx() method to find primitive for the 
		  given String object.

				--------------------------------------------
				|public static primitive parseXxx(String s)|
				--------------------------------------------
		
				int i = Integer.parseInt("10");
				boolean b = Boolean.parseBoolean("true");
				double d = Double.parseDouble("10.5");
		
				
	FORM 2: 

		- Every Integeral type wrapper class (Byte,Short,Integer,Long) containes the following parseXxx() method to covert 
		  specified radix string to primitive.
		  
			
			------------------------------------------------------
			|public static primitive parseXxx(String s,int radix)|
			------------------------------------------------------
				The allowed range of radix is : 2 to 36
			
			
				eg: 
			
				int i = Integer.parseInt("1111",2);
				System.out.println(i); //15
 
 
  Note: 
  
	
	
	-------------				  -------------	
    |   	    |  parseXxx()     | Primitive |
    |   String  |---------------> |           |
    |		    |                 |		      |
    |		    |                 |		      |
    -------------                 -------------
 
 ---------------
  4. toString()
 ---------------

 -> We can use toString() method to convert wrapper object or primitive to String.


	FORM 1:
	
		- Every wrapper class containes to following toString() method to covert wrapper object to string type.

			
				--------------------------
				|public String toString()|
				--------------------------
				
		- It is the overriding version of Object class toString() method.
		
		- Whenever we are trying to print wrapper object reference internally these toString() method will be call.
		
				Integer I = new Integer(10);
				String s = I.toString();
				System.out.println(s); // 10
				System.out.printl(I); ==>System.out.printl(I.toString(10));

			
	FORM 2: 
	
		- Every wrapper class including charcter class containes the following static toString() method to convert 
		  primitive to string.
		  
		  
				--------------------------------------------
				|public static String toString(primitive p)|
		        --------------------------------------------
		
										 |-----> It is primitive value 
			String s = Integer.toString(10);
			String s = Boolean.toString(true);
			String s = Charcter.toString('a');
										
	FORM 3: 

		- Integer and Long classes containes the following toString() method to convert primitive to specified radix 
		  String.
			
			---------------------------------------------------
			|public static String toString(primitive p, radix)|
			---------------------------------------------------
				The allowed range of radix 2 to 36
			
			eg: 
			
			String s = Integer.toString(15,2);
			System.out.println(s); //1111

	
	FORM 4: toXxxString() Method 
	
		- Integer and Long classes containes the following toXxxString() methods 
		
			---------------------------------------------------
            |public static String toBinaryString(primitive p,)|
		    ---------------------------------------------------
			--------------------------------------------------
			|public static String toOctalString(primitive p,)|
			--------------------------------------------------
			------------------------------------------------
			|public static String toHexString(primitive p,)|		
			------------------------------------------------		
			

					
					
					String s = Integer.toBinaryString(10);
					System.out.println(s);//1010
					
					String s = Integer.toOctalString(10);
					System.out.println(s);//12
					
					String s = Integer.toHexString(10);
					System.out.println(s);//a
					
					
					
		-------------				  -------------				
        | Wrapper  	|  toString()     | 		  |
        | Object/   |---------------> |           |
        | primitive |                 |	  String  |
        |		    |                 |		      |
        -------------                 -------------
		
		
							----------------------------------------------------	
							Dancing between String wrapper object and primitive.
							----------------------------------------------------

				--------------------------------------------------------------------------------		
		        |																			   |
				|						      -------------							           |
                |                             | 	      |                                    |
                |           ----------------->| String    |--->>----->>---------->>            |
                |           |                 |		      |          	   		  |            |
                |           |   |<<--<<--<--- |		      |<<---<<----<< |  	  |            |
                |           |   | valueOf()   -------------  toString()  |  	  |            |
                |		    |	|						                 |  	  |            |
                |		    |	|						                 |  	  |parseXxx()  |
                |toString()	|	|						                 |  	  |            |
                |		    |	|						                 |  	  |            |
                |		    |	|						                 |  	  |            |
                |			|	|						                 |  	  |			   |
                |			|	|						                 |  	  |            |
                |			|	|						                 |  	  |            |
				|		   	|	|						                 |  	  |			   |
                |		-------------									-------------		   |
                |		|   	    |			XxxValue()			    |   	    |          |
                |		| Wrapper   |---------------------------------->| Primitive |          |
                |		|  Object   |								    |	value   |          |
                |		|		    |<----------------------------------|		    |          |
                |		-------------		  valueOf()				    -------------          |
                |			                                                                   |
                |                                                                              |
				-------------------------------------------------------------------------------- 
				
				
								-----------------------------------------				
								Parcial Hierarchy of Java.lang. package 
								-----------------------------------------


											Object 
											  |
											  |
		----------------------------------------------------------------------------------
		|			 |				|			 |			|			|				|
		|			 |				| 			 |			|			|				|.......
	  String 	StringBuffer   StringBuilder	 |	     Boolean	 charcter		  Void 
												 |
												 |
								------------------------------------------			 
								|	   |	   |	     |	     |     	 |
								|	   |	   |		 | 	     |		 |
							   Byte   Short  Integer    Long   Float  Double 	 
							   
							    
 Conclusions 

	- The wrapper classes which are not child class of number are Boolean and Charcter.
	
	- The wrapper classes which are not direct child class of object are Byte,Short,Integer,Long,Float,Double.
	
	- String,StringBuffer, StringBuilder and all wrapper classes are final classes.
	
	- In addition to String objects all wrapper class objects also immutable.
	
	- Some times Void class is also considard as Wrapper class.
	
	
--------------	
  Void class 
--------------

  - It is final class and it is the direct child class of object.
  
  - It doesn't containe any methods and it containes only variable "Void.TYPE".

  - In general we can use Void class in reflecation to check whether the method return is void or not.
  
  
		if(getMethod(m1).getReturnType()== Void TYPE)
        {
        	
		}
		
		Void is class reprasentation of void keyword in java.
			
  - Prototype of Void class:-
  
		public final class java.lang.Void {
			
			public static final java.lang.Class<java.lang.Void> TYPE;
			static {};
			
			}
  
  
  
			
			
			
		
				
  
  
		
  
  