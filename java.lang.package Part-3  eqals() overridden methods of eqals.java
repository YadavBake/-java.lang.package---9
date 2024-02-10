
									java.lang.package Part-3 || equals()||overridden methods of equals
								  ====================================================================

----------------
 Equals Method  
----------------
 
 -> We can use equals() methods to check equality of two objects.
 
	Eg.
		obj1.equals(Obj2)
		
 -> If our class doesn't containe equals() method then object class equals() method will be executed.

	Ex.																  --------
																	  |Durga |
	 class Student 												s1--->|	     |<----s4	
	 {																  | 101  | 			
		 String name;												  --------			
		 int rollno;			
																	  --------	  	
		 Student(String name,int rollno)            				  |Raavi |
		 {                                          			s2--->|	     |
			 this.name=name;                        				  | 102  |
			 this.rollno=rollno;                    				  --------
		 }			
		 public static void main(String args[])	    				  --------
		 {                                          				  |Durga |
			Student s1 = new Student("Durga",101);  			s3--->|	     |
			Student s2 = new Student("Ravi",102);   				  | 101  |
			Student s3 = new Student("Durga",101);  				  --------
			Student s4 = s1;			
			
			System.out.println(s1.equals(s2));//false 
			System.out.println(s1.equals(s3));//false
			System.out.println(s1.equals(s4));//true
		 }
	 }
			
  - In the above object class equals() method got executed which is ment for reference compairision(Address compairision)
    that is if two reference pointing to the same object then only .equals() method returns true.

  - Based on our requirement we can override equals() method for content compairision.

  - While overriding equals() method for content compairision we have to take care about the following :

	1. What is the meaning of equality (That is whether we haev to check only names or only rollno or both ).
	
	2. If we are passing differnt type of object our equals() method should not rise ClassCastException that is we have 
	   to handle ClassCastException to return false.
	   
	3. If we are passing null argument then our equals() method should not rise NullPointerException that is we have to 
	   handle NullPointerException to return false.
		
  - The following is the proper way of overriding equals() method student class content compairision.

	class Student1 										
	{													
		 String name;							
		 int rollno;
												
		 Student1(String name,int rollno)          
		 {                                        
			 this.name=name;                      
			 this.rollno=rollno;                  
		 }
		 /*
			 |------------>this	
			s1.equals(s2)
					  |-------------
								   | */
		 public boolean	equals(Object obj)
		 {
		    try 
			{
			String name1 = this.name;  
			int rollno1= this.rollno;
			Student s = (Student)obj;//RE:CEE
			String name2 = s.name; //RE: NPE
			int rollno2 = s.rollno;//RE: NPE
			if(nam1.equals(name2) && rollno1 == rollno2)
			{
				return true;
			}else {
				return false;
			}
		  }
			catch(ClassCastException e)
			{
				return false;
			}
			catch(NullPointerException e)
			{
				return false;
			}
		}
    	 
    	 public static void main(String args[])	  
    	 {                                        
    		Student1 s1 = new Student1("Durga",101);
    		Student1 s2 = new Student1("Ravi",102); 
    		Student1 s3 = new Student1("Durga",101);
    		Student1 s4 = s1;
    		
    		System.out.println(s1.equals(s2));//false 
    		System.out.println(s1.equals(s3));//true
    		System.out.println(s1.equals(s4));//true  
			System.out.println(s1.equals("Durga"));//If we are not handle exception then we will RE: CCE
			System.out.println(s1.equals("Durga")); //false
			System.out.println(s1.equals(null));// false 	
			
			
    	 }
    }
	
	
																Simplified version of equals() method 
																	
	 /*                                                          /*
		 |------------>this	                                    	 |------------>this	
		s1.equals(s2)                                           	s1.equals(s2)
    			  |-------------                                			  |-------------
    						   | */                             						   | */
     public boolean	equals(Object obj)                           public boolean	equals(Object obj)
     {                                                           {
        try                                                     	 try 
    	{                                                       	 {
    	String name1 = this.name;                               		 Student s = (Student)obj;
    	int rollno1= this.rollno;                               		 if(name.equals(s.name) && rollno= s.rollno)
    	Student s = (Student)obj;//RE:CEE                       		 {
    	String name2 = s.name; //RE: NPE                        			 return true;
    	int rollno2 = s.rollno;//RE: NPE                        		 }
    	if(nam1.equals(name2) && rollno1 == rollno2)            		 else 
    	{                                                       		 {
    		return true;                                        			 return false;
    	}else {                                                 		 }
    		return false;                                       	 }
    	}                                                       	 catch(ClassCastException e)
      }                                                         	 {
    	catch(ClassCastException e)                             		 return false;
    	{                                                       	 }
    		return false;                                       	 catch(NullPointerException e)
    	}                                                       	 {
    	catch(NullPointerException e)                           		 return false;
    	{                                                       	 }
    		return false;                                        }
    	}
    }



	
  Ex. Simplified version of equals() method.	
	
  Student1 s1 = new Student1("Durga",101);					
  Student1 s2 = new Student1("Ravi",102); 	                	
  Student1 s3 = new Student1("Durga",101);	                 /*
  Student1 s4 = s1;	                                        	 |------------>this	
  	                                                        	s1.equals(s2)
  System.out.println(s1.equals(s2));//false 	            			  |-------------
  System.out.println(s1.equals(s3));//true	                						   | */
  System.out.println(s1.equals(s4));//true  	             public boolean	equals(Object obj)
  System.out.println(s1.equals("Durga"));//false	         {
  System.out.println(s1.equals(null));// false 		        	 try 
	                                                        	 {
	                                                        		 Student s = (Student)obj;
	                                                        		 if(name.equals(s.name) && rollno= s.rollno)
		  --------                                          		 {
		  |Durga |                                          			 return true;
	s1--->|	     |<----s4                                   		 }
		  | 101  | 		                                    		 else 
		  --------		                                    		 {
	                                                        			 return false;
		  --------	  	                                    		 }
		  |Raavi |                                          	 }
	s2--->|	     |                                          	 catch(ClassCastException e)
		  | 102  |                                          	 {
		  --------                                          		 return false;
	                                                        	 }
		  --------                                          	 catch(NullPointerException e)
		  |Durga |                                          	 {
	s3--->|	     |                                          		 return false;
		  | 101  |                                          	 }
		  --------                                           }
	
	
	
 Ex. More Simplified version of equals() method.		
 		
 Student1 s1 = new Student1("Durga",101);					Simplified version of equals() method 
 Student1 s2 = new Student1("Ravi",102); 	       	        
 Student1 s3 = new Student1("Durga",101);	       	         /*
 Student1 s4 = s1;	                               	        	 |------------>this	
 	                                               	        	s1.equals(s2)
 System.out.println(s1.equals(s2));//false 	   	            			  |-------------
 System.out.println(s1.equals(s3));//true	       	        						   | */
 System.out.println(s1.equals(s4)); //true  	   	             public boolean	equals(Object obj)
 System.out.println(s1.equals("Durga"));//  false		         {
 System.out.println(s1.equals(null));// false 			    	 if(obj instanceof Student)
 	                                               	        	 {
 	                                               	        		 Student s = (Student)obj;
 	                                               	        		 if(name.equals(s.name)&&rollno == s.rollno)
 		  --------                                 	        		 {
 		  |Durga |                                 	        			 return false ;
 	s1--->|	     |<----s4                          	        		 }
 		  | 101  | 		                           	        		 else 
 		  --------		                           	        		 {
 	                                               	        			 return false ;
 		  --------	  	                           	        		 }
 		  |Raavi |                                 	        	 }
 	s2--->|	     |                                 	        	 return false;
 		  | 102  |                                 	         }
 		  --------                                 	        	 
 	                                               	
 		  --------                                 	
 		  |Durga |                                 	
 	s3--->|	     |                                 	
 		  | 101  |                                 	
 		  --------                                 	
	
	
	
 -> To make above equals() methods more efficient we have to write the following code at the beginning inside equals()
    method 

			if(obj == this 
			{
				return true;
			}
			
	- According to these If both references pointing to the same object then without performing any compairision
      .equals() method returns true directly.	
	
	
		public boolean	equals(Object obj)
        {
			if(obj == this)
			{
				return true;
			}
        if(obj instanceof Student)
        {
        	 Student s = (Student)obj;
        	 if(name.equals(s.name)&&rollno == s.rollno)
	    	 {
	    		 return false ;
	    	 }
	    	 else 
	    	 {
	    		 return false ;
	    	 }
	    }
	    return false;
	}
	

 Ex.

 -> In String .equals() method is overriden for content compairision. Hence a, even though objects are differnt is content 
	is same then .equals() method returns true.
	

 
				String s1 = new String("Durga");				
				String s2 = new String("Durga");                
				System.out.println(s1==s2); //false             
				System.out.println(s1.equals(s2)); //true       
			
 	
	
	
	
	
	
 -> In StringBuffer .equals() method is not overriden for content compairision hence a if object are differnt .equals()
	method returns false even though content is same.
	
				
				StringBuffer sb1 = new StringBuffer("Durga");	
				StringBuffer sb2 = new StringBuffer("Durga");
				System.out.println(sb1==sb2);//false 
				System.out.println(sb1.equals(sb2));false 
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	