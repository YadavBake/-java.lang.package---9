class Test2 {                                   
	                                           
	public static void main(String args[])     
	{                                          
		                                       
                                               
		String s1 = new String("durga");       
		String s2 = s1.toUpperCase();          
		String s3 = s1.toLowerCase();          
		String s4 = s2.toLowerCase();
		String s5 = s2.toUpperCase();
		System.out.println(s1==s2); //false    
		System.out.println(s1==s3); //true 
		System.out.println(s1==s4); //false  
		System.out.println(s2==s5); //true 
			
	}                                          
}		