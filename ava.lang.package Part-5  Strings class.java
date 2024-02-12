
											java.lang.package Part-5 || Strings class
										  ============================================

=============================
  3. java.lang.String class.
=============================

 Case 1: 
										
	String s = new String("Durga");							
	s.concate("Software");                              
	System.out.println(s); Durga                        
												
	
	- Once we create String object we can't perform ant changes in the exisiting object.If we are trying to perform any 
	  change with those changes a new object will be created this is non-changeble behaviour is nothing but immutability
	  Of string 	

					
	                	   ----------  ----------------
	                s----->| Durga	|  | DurgaSoftware|
	                       ----------  ----------------
	
 
 
	StringBuffer sb = new StringBuffer("Durga");											
	sb.concate("Software");                     											  
	System.out.println(sb); //DurgaSoftware											
    
	
	- Once we create StringBuffer object we can perform any change in the exisiting object these changeble behaviour
	  is nothing but mutebility of StringBuffer Object 
	  
	  
								----------------
                          sb--->| DurgaSoftware|
                                ----------------
								
 Case 2: 


	- In String class .equals() method is overriden for content compairision hence a even though object are diffirent if 
	  content is same .equals() method returns true.

			String s1 = new String ("Durga");
			String s2 = new String ("Durga");
			System.out.println(s1==s2); //false 
			System.out.println(s1.equals(s2));//true 
			
			
				---------
		  s1--->| Durga	|
				---------
			
			
				---------
		 s2--->| Durga	|
				---------
				
	- In StringBuffer class .equals() method is not overriden for content compairision hence a if object class .equals()
      method got executed which is ment for reference compairision (adress compairision).Due to these if objects are 
      diffirent .equals() method returns false even though content is same.	  
	
						
						StringBuffer sb1 = new StringBuffer ("Durga");
						StringBuffer sb2 = new StringBuffer ("Durga");
						System.out.println(sb1==sb2); //false
						System.out.println(sb1.equals(sb2));//false
	
		
		 
									---------
							  sb1-->| Durga	|
									---------
								
								
									---------
							  sb2-->| Durga	|
									---------
									
 Case 3: 
 
		
	-> String s  = new String("Durga");         
	
		- In this case two object will be created one in the heap area and other is in SCP(String constant pool) and 's' 
		  is always pointing to heap object 
		  
		--------------------------------------
		|	heap			|		SCP      |
		--------------------------------------
		|	                |                |
		|		---------	|    ---------	 |	
		| s1--->| Durga	|   |    | Durga |   |
	    |		---------   |    ---------   |
	    --------------------------------------
		
		
	-> String s = "Durga";
        
	   - In this case only one object will be created in SCP and 's' is always pointing to that object.
		
				-------------------------------
				|	heap	|		SCP 	  |
				-------------------------------
				|			| 		--------- |
                |           |  s1-->| Durga|  |
                |           | 		--------- |
				-------------------------------

 Note 1 :

	- Object creation in SCP is optional first it will check is there any object already prasent in SCP with required 
	  content if object already prasent then exisiting object will be reused.
	   
	- If object not already avilable then only a new object will be created.But these rule is applicable only for SCP 
	  but not for the Heap.
	   
	
 Note 2 : 

	- GarbageCollector is not allowed access SCP area hence a even though object doesn't content reference variable it 
	  is not aligible for GC if it is prasent in SCP area.
	  
	- All SCP object will be distroyed automatically at the time of JVM shutdown.

	- Heap area, Method Area ,Stack Area, PC Register, Native method Stack.

  Ex 2. 
  
	String s1 = new String("Durga");
	String s2 = new String("Durga");
	String s3 = "Durga";
	String s4 = "Durga";
	
	
	---------------------------------------
	|	   Heap 	  |			  SCP     |
	---------------------------------------
	| 		-------	  |		   --------   |
    | s1-->| Durga|   |  s3--->| Durga|   |
    | 		-------	  |	 s4--> --------	  |
	|  		-------	  |	                  |
    |  s2-->| Durga|  |			          |
    |  		-------   |                   |
    |                 |                   |
	---------------------------------------
	
  Note: 
	
	- Whenever we are using new operator compulsory a new object will be created in the heap area hence a there may be 
	  a  chance exisiting two objects with content in the heap area but not in SCP that is duplicate object are possible 
	  in the heap area but in SCP .
	  
 Ex 3.

	String s1 = new String("Durga");
	s1.concate("software");
	String s2 =s1.concate("solution");
	s1=s2.concate("soft");
	System.out.println(s1); //DurgaSoft 
	System.out.println(s2); // DurgaSolution 
		
		
		---------------------------------------------
		|		Heap			|		SCP         |
		---------------------------------------------
		|		--------		|		--------    |
		|  s1-->| Durga|        |      	| Durga|    |
        |		--------        |    	--------    |
		|	---------------     |	   	----------  |
		|	|DurgaSoftware|		|	   	|SOftware|  | 
		|	---------------     |      	----------  |
		|     ---------------   |       ----------  |
		|s2-->|DurgaSolution|	|		|Solution| 	|
		|     --------------- 	|		----------  |
		|	 -----------	 	|		------      |
		|s1-->|DurgaSoft|		|		|Soft|      |
		|	 -----------		|		------	    |
        ---------------------------------------------
		
 Note:

	- For every String constant one will be placed in SCP area.
	
	- Because of some runtime operation if an object is required to create that object will be placed only in the heap 
	  area but not in SCP area.


 Ex 4. 

	String s1 = new String("Spring");
	s1.concate("Summer");
	String s2 = s1.concate("winter");
	s1= s2.concate("fall");
	System.out.println(s1);//SpringFall
	System.out.println(s2);//SpringWinter
	
	  
		---------------------------------------------
        |		Heap			|		SCP         |
        ---------------------------------------------
        |		--------		|		--------    |
        |  s1-->|Spring|        |      	|Spring|    |
        |		--------        |    	--------    |
        |	---------------     |	   	----------  |
        |	|SpringSummer |		|	   	|Summber |  | 
        |	---------------     |      	----------  |
        |     ---------------   |       ----------  |
        |s2-->|Springwinter |	|		| Winter | 	|
        |     --------------- 	|		----------  |
        |	  ------------	 	|		------      |
        |s1-->|SpringFall|		|		|Fall|      |
        |	  ------------		|		------	    |
        ---------------------------------------------