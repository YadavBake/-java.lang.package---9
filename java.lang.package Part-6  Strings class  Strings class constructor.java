
							java.lang.package Part-6 || Strings class || Strings class constructor
						=============================================================================

 -----------------------------
  Constructor of String class 
 -----------------------------

  1. String s = new String();

		- Creates an empty String object.

  2. String s = new String(String literal);

		- Creates a String object on the Heap for the given String literal.
	
  3. String s = new String(StringBuffer sb);
	
	   - Creates a String an equivalent String object for the given StringBuffer.
	   
  4. String s = new String(char [] ch);

	  - Creates an equivalent String object for the given char[] array.
	  
		eg.
			char[] ch = {'a', 'b', 'c', 'd'};
			Stirng s = new String(ch);
			System.out.println(s);// abcd
			
  5. String s = new String(byte[] b);

		- Creates an equivalent String object for the given byte[] array.
		
		eg. 
		
			byte [] b = {100,101,102,103};
			String s = new String(b);
			System.out.println(s);//defg 
			
 ----------------------------------- 
  Importance method of String class 
 ----------------------------------

   -> public char charAt(int index):- returns the charcator locating at specified indenx.
		
		eg. 
				
			String s = "Durga");
			System.out.println(s.charAt(3)); //g
			System.out.println(s.charAt(30)); //RE: StringIndexOutOfBoundsException
			
			
   -> public String concat(String s):- The Overloaded '+' and '+=' operators also meant for concatenation purpose only.
   
		String s = "durga";
		s =  s.concat("software");
		s = s+"software";
		s +="Software";
		System.out.println(s); // durgaSoftware
   
		
   -> public boolean equals(Object o):- To perform content comparison where case is important. This is overriding version 
	  of Object class equals()method.	
	
   -> public boolean equalsIgnoreCase(String s):- To perform content comparison where case is not important.

	
		String s = "JAVA";
		System.out.println(s.equals("java"));// false 
		System.out.println(s.equalsIgnoreCase("jav"));//true 
  
 Note: 

	-  In general we can use equalsIgnoreCase() method to validate userName where case is not important. where as we 
	   can use equals() to validate password where case is important.
	  



   -> public String 	substring(int begin):- returns substring from begin index to end of the String.
   
   -> public String substring(int begin, int end):- returns substring from begin indenx to end-1 index.

	Ex. 

		String s = "abcdefg";
		System.out.println(s.substring(3)); // defg 
		System.out.println(s.substring(2,6)); // cdef 
		
	
  
  
  -> 
  
	String s = "Durga";
	System.out.println(s.length);//CE cannot final symbol symbol: variable length location :java.lang.String.
	System.out.println(s.length()):// 5 
	
  Note: 

	- length variable applicable for array's but not for String Object. Where as length() method applicable for String 
	  object but not for arrays.
	  
	  
   -> public String replace(char oldCh, char newCh)

	
		eg:
		String "ababa";
		System.out.println(s.replace('a','b');// bbbbb
		
		
   -> public String toLowerCase();  
   -> public String toUpperCase();  
  
  
   -> public String trim(); :- To remove blank spaces prasent at begining and end of the String but not middle blank 
	  spaces.
	  
   -> public int indenxOf(char ch); :- returns index of first occurence of specified character.
   
   -> public int lastIndexOf(char ch); 
   
   
		String s = "ababa";
		System.out.println(s.indenxOf('a'));//0
		System.out.println(s.indenxOf('a'));//4
		
 **Note: 

	- Because of runtime operation if there is change in the content then with those changes  a new object will be 
	  created on the heap.
	  
	- If there is no change in the content then exisiting object will be reused and new object won't be created.
	
	- Whether the object prasent in heap or SCP the rule is same.

		
																----------------------------------
		class Test {                                            |	  Heap 		  |		SCP 	 |
			                                                    ----------------------------------
			public static void main(String args[])              |	  ---------   |				 |
			{                                                   |s1-->|       |	  |	  ---------	 |
				                                                |	  | durga |	  |	  | durga |	 |
	                                                            |s3-->|       |	  |	  ---------	 |
				String s1 = new String("Durga");                |	  ---------	  |              |
				String s2 = s1.toUpperCase();                   |                 |              |
				String s3 = s1.toLowerCase();                   |	  ---------   |			     |
				System.out.println(s1==s2); //false             |s2-->| DURGA |   |	             |
				System.out.println(s1==s3); //true              |	  ---------   |              |
			}                                                   ----------------------------------
		}		
	
		
		
			
		class Test {										----------------------------------
				                                            |	  Heap 		  |		SCP 	 |
				public static void main(String args[])      ----------------------------------
				{                                           |	  ---------   |				 |
		                                                    |s1-->|       |	  |	  ---------	 |
		                                                    |	  | durga |	  |	  | durga |	 |
		                                                    |s3-->|       |	  |	  ---------	 |
					String s1 = new String("Durga");        |	  ---------	  |              |
					String s2 = s1.toUpperCase();           |                 |              |
					String s3 = s1.toLowerCase();           |	  ---------   |			     |
					String s4 = s2.toLowerCase();           |s2-->| DURGA |   |	             |
					String s5 = s4.toLowerCase();           |	  ---------   |              |
					System.out.println(s1==s2); //false     |      ---------  |				 |
		            System.out.println(s1==s3); //true      |s4-->| durga |   |              |
		            System.out.println(s1==s4); //false     |	  ---------	  |              |                              
                    System.out.println(s2==s5); //true      |      ---------  |	             |
				}                                           |s5-->| DURGA |   |              |
		}				                                    | 	  ---------   |				 |
                                                            ----------------------------------
        
  
  
	Ex.
														----------------------------------
		String s1 = "durga";                            |	  Heap 		  |		SCP 	 |
		String s2 = s1.toString();                      ----------------------------------
		System.out.println(s1==s2);                     |	  ---------   |				 |
		String s3 = s1.toLowerCase();                   |s4-->|       |	  |	  ---------	 |
		System.out.println(s1==s3);                     |	  | DURGA |	  |s1-| durga |	 |
		String s4 = s1.toUpperCase();                   |	  |       |	  |s2-|		  |	 |
		String s5 = s4.toLowerCase();                   |	  ---------	  |s3-|		  |  |
		                                                |                 |   ---------  |
                                                        |	  ---------   |			     |
                                                        |s5-->| durga |   |	             |
                                                        |	  ---------   |              |
                                                        ----------------------------------
        
        
  -> How to create our own immutable class ?

	- Once a we creates an object we can't perform any changes in that object if we are trying to perform any change and 
	  if there change in the content then we those changes a new object will be created.
	  
	- If there is no change in the content then exisiting object will be reused these behaviour is nothing but immutablity.
	
	
	
			String s1 = new String("durga");				----------------------------------
			String s2 = s1.toUpperCase();                   |	  Heap 		  |		SCP 	 |
			String s3 = s1.toLowerCase();                   ----------------------------------
				                                            |	  ---------   |				 |
			                                                |s1-->|       |	  |	  			 |
                                                            |	  | durga |	  |	  			 |
                                                            |s3-->|       |	  |	  			 |
        	                                                |	  ---------	  |              |
		                                                    |                 |              |
		                                                    |	  ---------   |			     |
		                                                    |s2-->| DURGA |   |	             |
                                                            |	  ---------   |              |
                                                            ----------------------------------
 -> We can create our own immutable class 


	final public class Test 
	{	
			private int i ;									 --------- 		Test t1 = new Test(10);
			Test(int i)                                 t1-->|       |	    Test t2 = t1.modify(100);
			{                                           	 | i= 10 |	    Test t3 = t.modify(10);
				this.i=i;                               t3-->|       |	    Syste.out.println(t1==t2);//false
			}                                           	 ---------	    Syste.out.println(t1==t3);//true
		public Test modify(int i)                                      
		{                                               	  --------- 
			if(this.i==i)                               t2-->| i=100  | 
			{                                           	  --------- 
				return this;
			}
			else 
			{
				return (new Test(i));
			}
		}
	}
			
	- Once we creates a Test objec we can't performe any change in the exisiting object if we are trying to perform
	  any change and if there is a change in the content then with those changes a new object will be created.
	  
	- And if there is no change in the content then exisiting object we will reused.
	
	
----------------------			
 final vs Immutablity 			
----------------------

 -> final applicable for variables but not for objects where as immutablity applicable for objects but not for 
	variables.
	
 -> By declaring a reference variable as final we won't get any immutablity nature even though reference variable is the 
	final we can perform any type of change currusponding object but we can't perform re-assignment for that variable.

 -> final and immutable both are differnt concepts.
 
	Ex 	

	class Test 
	{
		public static void main(String args[])
		{
			final StringBuffer sb = new StringBuffer("durga");
			sb.append("software");
			System.out.println(sb);
			
			//Sb= new StringBuffer("solution"); // cannot assign a value to final variable sb. 
		}
	}
			
            
    - Which of the following are  meaningfull ?
	
	
		final variable //valid 
		
		immutable variable // invalid 
		
		final object // invalid 
		
		immutable object // valid 
            
            
            
            