class Test4 
	  {
		  public static void main(String args[])
		  {

			String s1 = new String("Durga");
			String s2 = new String("Durga");
			System.out.println(s1.equals(s2)); //true
			System.out.println(s1.hashCode()); // 66397819
			System.out.println(s2.hashCode()); // 66397819
			
			StringBuffer sb1 = new StringBuffer("Durga");
			StringBuffer sb2 = new StringBuffer("Durga");
			System.out.println(sb1.equals(sb2));//false 
			System.out.println(sb1.hashCode()); //798154996
			System.out.println(sb2.hashCode()); //681842940
			
			
		  }
	  }
