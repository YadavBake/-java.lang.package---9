
									java.lang.package Part-7 || Strings||constructors of StringsBuffer
								=========================================================================
								
-----------------
  StringBuffer	
-----------------

 -> If the content is fixed and won't change frequently then it is recomanded to go for String.

 -> If the content is not fixed and keep on changing then it is a not recomanded to use String because for every change 
	a new object will be created which effects performance of the system.
	
 -> To handle these requirement we should go for StringBuffer the main advantage of StringBuffer over String is all 
	required changes will be performed in the exisiting object only.
	
----------------
  Constructors 
----------------

 1. StringBuffer sb = new StringBuffer();

	- Creates an empty StringBuffer object with default initial capacity 16. Once a StringBuffer reaches it's max
	  capacity a new StringBuffer object will be created with 
	  
		"Newcapacity = (currentCapacity + 1) * 2;"
		
		
		class TestSb {
			
			public static void main(String args[]){
				
				StringBuffer sb = new StringBuffer();
				System.out.printl(sb.capacity()); //16	
				sb.append("abcdefghijklmnop");
				System.out.printl(sb.capacity()); //16		
				sb.append("q");
				System.out.printl(sb.capacity()); //34
				sb.append("abcdefghijklmnop");
				sb.append("q");
				sb.append("r");
				System.out.println(sb.capacity()); //70
			}
		}
	
	
	
	2. StringBuffer sb = new StringBuffer(int initialcapacity);
	
		- Creates an empty StringBuffer object with specified initialcapacity.
		
	3. StringBuffer sb = new StringBuffer(String s);
	
		- Creates an equevalent StringBuffer for the given String with 
		
				capacity = s.length()+16;
	
		eg:
		
			StringBuffer s = new StringBuffer("durga");
			System.out.printl(sb.capacity());//21 // capacity = s.length()+16;
				
 ----------------------------------- 
  Important Method of StringBuffer	
 -----------------------------------

  1. public int length();
  2. public int capacity();
  3. public char charAt(int index);
  
	eg:
	
		StringBuffer sb = new StringBuffer("durga");
		System.out.printl(sb.charAt(3)); //g 
		System.out.printl(sb.charAt(30));//RE: 	StringIndexOutOfBoundsException
		
  4. public void setCharAt(int index, char ch);
  
	 - To replace the charcter located at specified index with 	provided charcter.
	 
		
  5. public StringBuffer append(String s) |			
	public StringBuffer append(int i )	  |			
	public StringBuffer append(long l)	  |==> All these method are overloaded method.			
	public StringBuffer append(char ch)	  |		
	public StringBuffer append(boolean b) |			
	;;;;	
	
	class Test {
		
		public static void main(String args[])
		{
			StringBuffer sb = new StringBuffer();
			sb.append("PI value is");
			sb.append(3.14);
			sb.append("It is exactly true:");
			sb.append(true );
			System.out.println(sb);
		}
	}
			

  6. public StringBuffer insert(int index, String s)|			
	 public StringBuffer insert(int index,int i )	|			 			 
     public StringBuffer insert(int index,long l)	|==> All these method are overloaded method 
     public StringBuffer insert(int index,char ch)	|		 
     public StringBuffer insert(int index,boolean b)|			


		class Test 
		{
			public static void main(String args[])
			{
				StringBuffer sb = new String("abcdefgh");
				sb.insert(2,"xyz");
				System.out.println(sb); // abxyzddefgh
			}
		}
	
  7. public StringBuffer delete(int begin,int end)
  
		- To delete charcters located from begin index to end-1 index
		
  8. public StringBuffer deleteCharAt(int index)
  
		- To delete the charcter located at specified index 	
	

  9. public StringBuffer reverse();


		class Test {
			
			public static void main(String args[])
			{
				StringBuffer sb = new StringBuffer("durga");
				System.out.println(sb.reverse(); //agrud
			}
		}

 10. public void setLength(int length);

		eg:
		
		StringBuffer sb = new StringBuffer("aiswaryaabhi");
		sb.setLength(8);
		System.out.println(sb);// aiswarya	
	
 11. public void ensureCapacity(int capacity);
  
		- To increase capacity on fly based on our requirement.
		
		class Test 
		{
			public static void main(String args[])
			{

				StringBuffer sb = new StringBuffer();
				System.out.println(sb.capacity());//16
				sb.ensureCapacity(1000);
				System.out.println(sb.capacity());//1000
			}
		}
  
 12. public void trimToSize();

		- To deallocate extra allocated 	free memory.

		class Test 
        {
        	public static void main(String args[])
        	{
        
        		StringBuffer sb = new StringBuffer(1000);
        		System.out.println(sb.capacity());//1000
        		sb.append("abc");
				sb.trimToSize();
        		System.out.println(sb.capacity());//3
        	}
        }

 ---------------
  StringBuilder
 ---------------

  -> Every method prasent in StringBuffer is synchronized and hence only one thread is allowed operate on StringBuffer
	 object at a time which may creates perormance problems. To handle these requirement sun pepole introduced 
	 StringBuilder concept in 1.5v version.
	 
  -> StringBuilder is exactly same as StringBuffer except the following differences.

		--------------------------------------------------------------------------------------------------	
		|			StringBuffer 									StringBuilder						 |
		--------------------------------------------------------------------------------------------------
		|1. Every Method prasent in StringBuffer is 	| 1. Every method prasent in StringBuilder is    |
		|   synchronized.								|	 non-synchronized.                           |
		|                                               |                                                |
		|2. At a time only thread is allowed to operate	| 2. At a time multiple thread are allowed to    |
		|   on StringBuffer object and hence a 			|	 operate on StringBuilder object and hence   |
		|   StringBuffer object is thread safe.			|	 a StringBuilder is not thread safe.         |
        |                                               |                                                |
		|3. Thread are required wait to operate on 		| 3. Thread are not required to wait to operate	 |
		|   StringBuffer object and hence relatively 	|	 on StringBuilder object and hence relatively|
		|   performance is low.							|	 performance is high.                        |
		|                                               |												 | 	
		|4. Introduced in 1.0v version.					| 4. Introduced in 1.5v version.   				 |
		--------------------------------------------------------------------------------------------------
  Note: 

	Except aboved differences every thing is same in StringBuffer and StringBuilder (including method and constructors).



 -> String vs StringBuffer vs StringBuilder.
 
	1. If the content is fixed and won't change frequently then we should go for String.

	2. If the content is not fixed and keep on changing but thread safety required then we should go for StringBuffer.
	
	3. If the content is not fixed and keep on changing but thread safety is no required the we should go for 
	   StringBuilder.
	   
 -----------------
  Method chaining 
 -----------------

	-> For most of the methods in String,StringBuffer and StringBuilder return type are same type hence a after applying 
	   a method on the result we can call another method which forms method chaining.
	   
			sb.m1().m2().m3().m4()......
			
		- In the method chaining method calls will be executed from left to right.	
	
	
	class Test 
	{
		public static void main(String args[])
		{
		
		StringBuffer sb = new StringBuffer();
		sb.append("durga").append("software").append("solution").insert(5,"Srikanth").delete(13,21).append("SR Nager")
		.reverse();
		System.out.println(sb);
		}
	}
	   
































 


 