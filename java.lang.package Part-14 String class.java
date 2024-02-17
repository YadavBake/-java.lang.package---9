
										java.lang.package Part-14 ||String class
									  ===========================================
 
 --------------
  String class 
 --------------

 ->																	
	class Test 
	{
		public static void main(String args[])				  ---------------------------------------------------------
		{                                                     | Head area 			|	String constant Pool(SCP area)|
															  | --------------------|---------------------------------|		
			String s1 = new String("You can not change me!"); |			-------		| 		 -------		          |
			String s2 = new String("You can not change me!"); |			|     |     |  s3--->|     |                  |
			System.out.println(s1==s2);//false                |	  s1--->|UCCM!|     |  s4--->|UCCM!|<---s9            |
			String s3 = "You can not change me !";            |			|	  |     |  s5--->|	   |                  |
			System.out.println(s1==s3); //false               |			-------	    | 		 -------                  |
			String s4 = "You can not change me !";            |			            |                                 |
			System.out.println(s3==s4);//true                 |			------- 	|	                              |
			String s5 ="You can not "+ "change me!"; //line- 1|			|     |     |  		-------				      | 
			System.out.println(s3==s5);//true                 |	  s2--->|UCCM!|     | s6--->|     |                   |
			String s6 = "You can not ";                       |			|	  |     | s8--->| UC  |                   |
			String s7 = s6+ "change me !"; // line - 2        |			-------     |  		|	  |                   |
			System.out.println(s3==s7);//false                |			            |  		-------                   |
			final String s8 = "You can not";                  |			-------		|		-------                   |
			String s9 = s8+"change me !";//line - 3           |			|     |     |		|     |                   |
			System.out.println(s3==s9);//true                 |	  s7--->|UCCM!|		|       | CM! |	                  |
			System.out.println(s6==s8);//true                 |			|	  |     |		|	  |                   |
		}                                                     |			-------     |		-------                   |
	}                                                         |                     |                                 |
	                                                          ---------------------------------------------------------
	  
	  	
 -> At line - 1  operation will be performed at compile time only because both argument are compile time constants.
	
 -> At line - 2 operation will be performed at Runtime only because at list one argument is normal variable.
 
 -> At line - 3 operation will be performed at Compile time only because both argument are compile time constants.
 
 
 -----------------------------
  Interning of String objects 
 -----------------------------

 -> We can use intern() method to get corrusponding SCP object reference by using heap object reference.
 
 -> By using heap object reference if we want to get corrusponding SCP object reference then ew should go for intern()
	method.
	
	Ex.
	
	
	class Test 
	{													-------------------------------------------------
		public static void main(String args[])			|		 Heap		|			SCP             |
		{                                               -------------------------------------------------
														|                   |                           |
			String s1 = new String("durga");			|		-------		|			-------         |
			String s2 = s1.intern();                    |		|     |     |    		|     |         |
			System.out.println(s1==s2); //false         | s1--->|durga|     |    |----->|durga|<---s3   |
			String s3 = "durga";                        |		|	  |     |    |		|	  |         |
			System.out.println(s2==s3); //true          |		-------     |    |		-------         |
			                                            |		            |    |		                |
		}												|		s2----------|----                       |
	}                                                   |                   |                           |
	                                                    |                   |                           |
	                                                    |                   |                           |
	                                                    |                   |                           |
														-------------------------------------------------
	
		
	  
	Ex.   
	  
	-> If the corrusponding SCP object is not available then intern() method itself will create the corrusponding SCP 
	   object.
	  
	class Test   
	{											  	-------------------------------------------------
		public static void main(String args[])	    |		 Heap		|			SCP             |
		{                                           -------------------------------------------------
												    |                   |                           |
			String s1 = new String("durga");	    |		-------		|			-------         |
			String s2 = s1.concat("software");      |		|     |     |    		|     |         |
			String s3 = s2.intern();	            | s1--->|durga|     |    		|durga|		    |
			System.out.println(s2==s3); //false     |		|	  |     |     		|	  |         |
			String s4 = "durgasoftware";            |		-------     |     		-------         |      
			System.out.println(s3==s4); //true      |	  --------------|     	 ---------          |
    		                                        |s2->|durgasoftware||	    |software|          |
    	}										    |    ---------------|       ----------          |
		                                            |                   |     --------------        |
		                                            |            s3--------->|durgasoftware|<-s4    |
		                                            |                   |    ---------------        |
                                                    -------------------------------------------------
        
 ------------------------------------------       
  Importance of String Constant Pool (SCP)
 ------------------------------------------

 ->  
        
            --------------------------------
			|  voting Registrasion form    |
			--------------------------------
			|Name : Baakelal yadav 		   |
			|Father Name: Komal yadav 	   |
			|DOB: 21/01/1992               |
			|age: 32                       |
			|Address:                      |
			|H.No. 03                      |
			|Street Shree Dhar Gym         |
			|village/city: Dahisar         |
			|mandal: Ganesh Mandal         |
			|State: maharastra             |
			|Pin: 400                      |
			|                              |
			|Identification number: 1212   |
			|Identification Member: fasda  |
			|                              |
			|		Submit                 |
            -------------------------------|
			
	- In our program if a String object is repetadaly required then it is not recomanded to create separate for every 
	  requirement because it create performence and memory problems.
	  
	- Initiated of creating a separate object for every requirement we have to create only one object and we can reuse 
	  the same object for every requirement. So that performence and memory utilization will be improve.
	  
	- This thing is possible because of sCP hence a the main advantages of SCP are memory utilization and performence will 
	  be improve.
	  
	- But the main problem with SCP is, as several references pointing to the same object, by using one reference if we 
	  are trying to change the content then remaining references will be effected.
	  
	- To overcome this problem Sun people implemented String object as immutable. That is once we creates a String object 
	  we can't perform any changes in the exisiting object.
	  
	- If we are trying to perform any changes with those changes a new object will be create. hence a SCP is the only 
	  reasion for immutablity of String object.
	  
 FASs

	1. What is the difference between String and StringBuffer ?
	2. Explain about Immutablity and mutability with an example.
	3. What is the difference between
			String s = new String("durga"); and 
			Strings = "durga";
	4. Other then immutablity and mutability is any other difference b/w String and StringBuffer ?
	
	5. What is SCP?
	
		- It is a specially design memory for String objects. 
		
	6. What is the advantage of SCP?
	7. what is the disadvantage of SCP?
	
	8. What SCP like concept is available only for String but not for StringBuffer ?
		
		String is the most commanly used object and hence a sun people provided special memory management for String 
		Object.
		
		But StringBuffer is not commanly used object and hence special memory management is not required for StringBuffer.
		
	
	9. Whay String objects are immutable where as StringBuffer objects are mutable ?
	
		-In the case of String because of SCP a single object can be referenced by mutiple references.

		- By using one reference if we are allow to change the content in the exisiting object then remaining references
		  will effected to overcome these problem sun people immplemented String object as immutable. According to this 
		  once we creates a String object we can't perform any changes in the exisiting object if we are trying perform
		  any changes with those changes a new object will be created.
		  
		  
					-------------										 	-------------	
		 |--------->| VijayVada |                                      v1-->| VijayVada |
		 |			-------------                                   	 	-------------
		 |                                                          	
		 |                                                          		------------- 
		 |	      ------------                                         v2--->| VijayVada|
		 |	v1--->|			 |                                      		-------------
		 |	v2--->|			 |                                      	
		 |	v3--->|HyDarabad |                                      		-------------
		 ---v4-X->|			 |                                         v3--->| HyDarabad|
				  ------------	                                    		-------------
		                                                            	
		                                                            		-------------
		                                                             vn--->| VijayVada  |
	                                                                		-------------
	
				String with SCP 											StringBuffer
				
				
		- But in StringBuffer there is no concept like SCP hence a for every requirement a separate object weill be 
		  created.
		  
		- By using one reference if we are tyring to change the content then there is no effecte on remaining
		  references.Hence a immutablity concept not required for the StringBuffer.
		  
		     
   10. In addition to String objects any other objects are immutable in java ? 

		In addition String objects All wrapper class object also immutable in java.
   
   11. Is it possible to create our own immutable class ?
   
		Yes! 
		
   12. How to create our own immutable class exaplane with an example ?
   	  
   13. Immutable means non-changable where as final means also non-changable. Then what is the difference b/w
	   final and immutable ? 
	
		
	
	
            
            
            
            
            
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		