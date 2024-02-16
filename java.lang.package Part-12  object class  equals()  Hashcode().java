
								java.lang.package Part-12 || object class || equals() || Hashcode()
							  ======================================================================


 ------------------------------------------------------
   Reation between '==' operator and .equals() method 							  

 ------------------------------------------------------

 
 -> If two object are equals by '==' operator then these object are always by .equals() method.

   
		1. If r1 == r2  is true then r1.equals(r2) is always true.
		
				  --------	
			r1--->|		 |
				  |		 |		
			r2--->|		 |
				  --------

 -> If two object are not equals by '==' operator then we can't conclude any thing about .equals() method it may returns 
	true or false 
	
	2. That is if r1==r2 is false then r1.equals(r2) may return true or false and we can't except exactly.
				  --------	
			r1--->|      |
				  --------	
				  
				  --------	  
            r2--->|      |
            	  --------
				  

 -> If two object are equals by .equals() method then we can't conclude any thing about '==' operator it may returns 
	true of false.
				  
    3. 	That is If r1.equals(r2) is true then we can't conclude anything about r1==r2  it may returns true or false.
	
	
 -> If two object are not equal by .equal() method then this object are always not equal by '=' operator.
 
	
	4.	That is If r1.equals(r2)is false then r1==r2 is always false.
	
 -------------------------------------------------------	
  Differences between '==' operator and .equal() method 
 -------------------------------------------------------

 -> To use '==' operator  compulsory there should be some relation between argument types(Either child to parent or 
	parent to child or same type) otherwise we will compile time error saying incomparable types.
	
 -> If there is no relation between argument types then .equal() method won't rise any compile time or runtime errors
	simply it returns false.
	
	
	   class Test 
	   {
		   public static void main(String args[])
		   {

				String s1 = new String("Durga");
				String s2 = new String("Durga");
				StringBuffer sb1 = new StringBuffer("Durga");
				StringBuffer sb2 = new StringBuffer("Durga");
				System.out.println(s1==s2); //false
				System.out.println(s1.equals(s2));//true
				System.out.println(sb1==sb2);//false 
				System.out.println(sb1.equals(sb2));//false 
				System.out.println(s1==sb1);//CE: incomparable types: java.lang.String and Java.lang.StringBuffer
				System.out.println(s1.equals(sb1));// false 	
		   }
	   }
		
	
			-------------------------------------------------------------------------------------
			|	'==' Operator 				         | 					.equals() method 		 |
			--------------------------------------------------------------------------------------
			|								  		 |                                           |
			|1. It is an operator in java applicable |1. It is method applicable only for        |
			|	for both primitives and object types |   object types but not for primitives.    |
			|										 | 	                                         |
			|2. In the case of object references '=='|2. By default .equals() method prasent     |
			|   operator ment for reference 		 |	 in object class also ment for reference |
			|	compairision (address compairision)	 | 	 compairision.                           |
			| 										 |	                                         |
			|3. We can't override '==' operator for  |3. We can override .equals() method for    |
			|	content compairision.				 |	 content compairision.                   |
			|                                        |                                           |
			|4. To use '==' operator compulsory there|4. IF there is no relation between argument|  
			|	should be some relation between      |	 types then .equals() method won't rise  |
			|	argument types (Either child to      |	 any compile time or Runtime errors and  |
			|	parent or parent to child or same    |	 simply returns false.                   |
			|	type) otherwise compile time error   |                                           |
			|	saying incomparable types            |											 | 
			--------------------------------------------------------------------------------------
																									
			
  - Answer in one line ?

	- In general we can use '==' operator for reference compairision and .equals() method for content compairision.
	
	

 Note :

	- For any object reference r.
	
		r == null     |false 
		r.equals(null)|false 
	
	- Always returns false 
	
		EX. 
		
			Thread t = new Thread();
			System.out.println(t==null);//false 
			System.out.println(t.equals(null));//false 
			
	
	
Note: 

	- Hashing related Data Structures follows the following fundamental rule.
	
		- Two equevalent object should be placed in same bucket but all object prasent in the same bucket need not 
		  be equal.
		  
-----------------------------------------------------		  
 Contract between .equals() method hashCode() method 
-----------------------------------------------------

 1. If two object are equal by .equals() method then there hashCode must be equal that is two equevalent objects should 
	have same hashCode.
	
	- That is If r1==r2 is true then r1.hashCode() == r2.hashCode() is always true.
	
 2. Object class .equals() and hashCode() code method follows above contract hence a whenever we are overriding .equals()
    method compulsory we should override hashCode() method to saticefied above contract(Tha is two equevalent object 
	should have same hashCode).
	
 3. If two object are not equal by .equals() method then there is restriction on hashCode may be equal or may not be 
	equal 
	  
 4. If hashCode of two objects are equal then we can't conclude any thing about .equals() method it may returns true or 
	false.
	  
 5. If hashCode of two object are not equal then this object are always not equal by .equals() method
	

 Note**

	- To saticefied contract between equals() and hashCode() methods whenever we are overriding .equals() method
	  compulsory we have to override hashCode() method otherwise we won't get any compile time or Runtime errors but 
	  it's not a good programming practice.
	  
 -> In String class .equals() method is overriden for content compairision and hence a hashCode() method is also overriden
	to generate hashCode based on content.
	
	Ex. 
	  
	  class Test 
	  {
		  public static void main(String args[])
		  {

			String s1 = new String("Durga");
			String s2 = new String("Durga");
			System.out.println(s1.equals(s2)); //true
			System.out.println(s1.hashCode()); // 95950491
			System.out.Println(s2.hashCode()); // 95950491
			
		  }
	  }
 
 -> StringBuffer .equals() method is not overriden for content compairision and hence hashCode() method is also not 
	overriden.
	
	Ex.
	
	class Test4 
	  {
		  public static void main(String args[])
		  {

			
			StringBuffer sb1 = new StringBuffer("Durga");
			StringBuffer sb2 = new StringBuffer("Durga");
			System.out.println(sb1.equals(sb2));//false 
			System.out.println(sb1.hashCode()); //798154996
			System.out.println(sb2.hashCode()); //681842940
			
						
		  }
	  }
 
  Q). Considard the following persion class ?
  
  
	Ex.
	
	
	 class Persion 
	 {
		 public boolean equals(Object obj)
		 {
			 
			if(obj instanceOf Persion)
			{
				Persion p = (Persion)obj;
				
				if(name.equals(p.name) && age == p.age)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			return false;
		 }
	 }
	
    - Which of the following hashCode() method are appropriate for persion class ? 

		
	 
	 1. public int hashCode(){  2. public int hashCode(){	3. public int hashCode				4. No Restriction.
		                                                    	 
		 return 100;            	  return age+ssno;      	 return name.hashCode()+age;
		}                       	                        	}
	                            	}
	   // invalid 						 invalid					valid 							invalid 

	
 Note: 

	- Based on which parameters we override .equals() method, it is highly recomanded to use same parameters while 
	  overriding hashCode() method also.
	  
	  
	- In all collection classes, In all wrapper classes and in String class .equals() method is overriden for content
	  compairision hence a it is highly recomanded to override equals() method in our class also for content compairision.
	  
	  
	
		
	 
	
	
	
	 
	 
	 
	 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	