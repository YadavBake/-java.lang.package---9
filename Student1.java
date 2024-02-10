/*class Student1 								
{											
	 String name;							
	 int rollno;
											
	 Student1(String name,int rollno)          
	 {                                        
		 this.name=name;                      
		 this.rollno=rollno;                  
	 }
	 	  
	 
	 public static void main(String args[])	  
	 {                                        
		Student1 s1 = new Student1("Durga",101);
		Student1 s2 = new Student1("Ravi",102); 
		Student1 s3 = new Student1("Durga",101);
		Student1 s4 = s1;
		
		System.out.println(s1.equals(s2)); //false 
		System.out.println(s1.equals(s3)); //false
		System.out.println(s1.equals(s4)); //true 
		System.out.println(s1.equals("Durga"));//false
		System.out.println(s1.equals(null));//false 
	 }
} // In this example object class .equals method will call */


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
		 public boolean	equals(Object obj)
		 {
		 try
		 {
		 	String name1 = this.name;
		 	int rollno1 = this.rollno;
		 	Student1 s = (Student1)obj; //RE: CCE
		 	String name2 = s.name; //RE: NPE
		 	int rollno2 = s.rollno;//RE: NPE
    	 	if(name1.equals(name2) && rollno1 == rollno2)
    	 	{
    	 		return true;
    	 	}
    	 	else 
    	 	{
    	 		return false ;
    	 	}
		 }catch(ClassCastException e){
			 
			 return false;
			}
			catch(NullPointerException e)
			{
				return false;
			}
		}
		
		public boolean	equals(Object obj)
		{
			 try 
			 {
				 Student1 s = (Student1)obj;
				 if(name.equals(s.name) && rollno== s.rollno)
				 {
					 return true;
				 }
				 else 
				 {
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
		}*/
		
		public boolean	equals(Object obj)
		{
		   if(obj instanceof Student1)
			{
		  		 Student1 s = (Student1)obj;
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
		
						    	 
    	 public static void main(String args[])	  
    	 {                                        
    		Student1 s1 = new Student1("Durga",101);
    		Student1 s2 = new Student1("Ravi",102); 
    		Student1 s3 = new Student1("Durga",101);
    		Student1 s4 = s1;
    		
    		System.out.println(s1.equals(s2)); // false
    		System.out.println(s1.equals(s3)); // true
    		System.out.println(s1.equals(s4));//true
			//System.out.println(s1.equals("Durga")); //If we are not handle exception then we will RE: CCE
			System.out.println(s1.equals("Durga"));//false 
			//System.out.println(s1.equals(null));//If we are not handle exception then we will RE:NPE 
			System.out.println(s1.equals(null));//false 
			
    	 }
    } //Here our customized or overriden .equals() will call


