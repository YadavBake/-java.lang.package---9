
									    	java.lang.package Part-13 || object class || clone()
										==========================================================
										
---------  
 clone() 
---------

 -> The process of creating exactly duplicate object is called cloning.

 -> The main purpose of cloning is to maintain backup copy and to preserve state of an object. 
     
 -> We can perform cloning by using clone() method of object class.

	
	 -------------------------------------------------------------------
	 |protected native Object clone() throws CloneNotSupportedException|
	 -------------------------------------------------------------------
	 
		
	Ex.

		class Test implements Cloneable
		{
			int i = 10;
			int j = 20;
			
			public static void main(String args[])throws CloneNotSupportedException
			{														 ---------	
				Test t1 = new Test;								t1-->| i = 10|
				Test t2 = (Test)t1.clone();							 | j = 20|			
				t2.i = 888;											 ---------	
				t2.j = 999;
				System.out.println(t1.i+"...."+t1.j);				 -------------
			}                                                   t2-->| i = 10,888|
			                                                    	 | j = 20,999|
		}                                                       	 -------------
		
	- We can perform cloning only for cloneable object.

	- An object is said to be cloneable if and only if the currusponding class implements cloneable interface.
	
	- cloneable interface prasent in java.lang package and it doesn't containe any methods it is marker interface.
	
	- If we are trying to perform cloning for non-cloneable objects then we will get Runtime Exception saying 
	  CloneNotSupportedException.
	  
---------------------------------
 Shallow cloning vs Deep Cloning 
---------------------------------

				  Shallow Cloning												Deep  Cloning
		
					---------												---------	---------			
			  |---->|  j =20|<--------------                		  |---->|  j =20|   |  j =20|<--
			  |		---------			   |	            		  |		---------	---------  |	
			  |							   |                		  |							   |
			  |							   |	            		  |							   |	
		  ----|-----  				  -----|----            	  ----|-----  				  -----|----
		  |	  |	   |            	  |	   |   |            	  |	  |	   |            	  |	   |   |
		  |   c	   |            	  |    c   |            	  |   c	   |            	  |    c   |
	d1--->|        |            d12-->|        |            d1--->|        |            d12-->|        |
		  | i = 10 |            	  | i = 10 |            	  | i = 10 |            	  | i = 10 |
		  |	       |            	  |	       |            	  |	       |            	  |	       |
		  ----------	        	  ----------            	  ----------	        	  ----------

			Dog d2  = (Dog)d1.clone();									Dog d2  = (Dog)d1.clone();

-------------------
  Shallow Cloning 
-------------------

 -> The process of creating bitwise copy of an object is called Shallow cloning.
 
 -> If the main object containe primitive variables then exactly duplicate copy will be created in the cloned object.
 
 -> If the main Object containe any reference variable then currusponding object won't be created just a duplicate 
	reference variable will be created pointing to old contained object.
	
 -> Object class clone() method ment for shallow cloning.


	class Cat {
		
		int j;
		Cat(int j)
		{
			this.j=j;
		}
	}
	class Dog implements Cloneable
	{
		
		Cat c;
		int i;
		
		Dog(Cat c int i)
		{
			this.c=c;
			this.i=i;
		}
		public Object clone() throws CloneNotSupportedException
		{
			return super.clone(); // here we call object class clone() method only 
		}
	}
	
	
	class ShallowCloningDemo
	{
		public static void main(String args[]) throws CloneNotSupportedException
		{
			Cat c = new Cat(20);				
			Dog d1 = new Dog(c,10);													-------------					
			                                                        		  |---->|  j =20,999|<----------    
			Dog d2 = (Dog)d1.clone();//This is a clone() method     		  |		-------------		   |	
			                                                        		  |							   |    
			d2.i = 888;                                             		  |							   |	
			d2.c.j = 999;                                           	  ----|-----  				  -----|----
			System.out.println(d1.i+"..."+d1.c.j);                  	  |	  |	   |            	  |	   |   |
								10			999                     	  |   c	   |            	  |    c   |
		}                                                           d1--->|        |            d12-->|     888|
	}                                                               	  | i = 10 |            	  | i = 10 |
			                                                        	  |	       |            	  |	       |
	                                                                	  ----------	        	  ----------
	
	- In shallow cloning by using cloned object reference if we perform any change to the contained object then those 
	  changes will be reflected to the main object.
	
	- To overcome this problem we should go for deep cloning.


-------------	
 Deep Cloning 
--------------- 

  - The process of creating exactly duplicate indipendant copy including contained object is called Deep Cloning.
  
  - In deep cloning if the main object containe any primitive variables then in the cloned object duplicate copys 
	will be created.

  - If the main object containe any reference variable then the currusponding contained object also will be created 
	in the cloned copy.
	
  - By default object class clone method ment for shallow cloning but we can implement deep explicitly by overriding 
	clone method in our class.
	
	
	Ex. 
	
	
		class Cat {
	
			int j;
			Cat(int j)
			{
				this.j=j;
			}
		}
		class Dog implements Cloneable
		{
			
			Cat c;
			int i;
			
			Dog(Cat c,int i)
			{
				this.c=c;
				this.i=i;
			}
			public Object clone() throws CloneNotSupportedException
			{
					Cat c1 = new Cat(c.j);
					Dog d = new Dog(c1,i);
					return d;
			}
		}
		
		
		class DeepCloningDemo
		{
			public static void main(String args[]) throws CloneNotSupportedException
			{																						---------
				Cat c = new Cat(20);				                   		  	        ---------	|	 999|			
				Dog d1 = new Dog(c,10);									    	  |---->|  j =20|   |  j =20|<--				
				System.out.println(d1.i+"..."+d1.c.j);// 10,20             		  |		---------	---------  |	                                              
				                                                           		  |							   |
				Dog d2 = (Dog)d1.clone();//This is a clone() method        		  |							   |	
																	       	  ----|-----  				  -----|----
				d2.i = 888;                                                	  |	  |	   |            	  |	   |   |
				d2.c.j = 999;                                              	  |   c	   |            	  |    c   |
				System.out.println(d1.i+"..."+d1.c.j);                  d1--->|        |            d12-->|     888|
									//10		20	                       	  | i = 10 |            	  | i = 10 | 
			}                                                              	  |	       |            	  |	       |
		}                                                                  	  ----------	        	  ----------

   - By using cloned object reference if perform any change to the contained object then those changes won't be reflected
     to the main object.
	  
 Q.) Which is best ?

	  - If object containes only primitive variables then shallow cloning is the best choice.
	  
	  - If object containes reference variables then deep cloning is the best choince.
	  
	  








































































 
	  