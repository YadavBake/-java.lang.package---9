class TestWrapper {

	public static void main(String args[])
	{
		/*Boolean x = new Boolean("Left");
        Boolean y = new Boolean("no");
        System.out.println(x);
		System.out.println(y);
		System.out.println(x.equals(y));*/
		
		
		Integer I1 = Integer.valueOf("1111");
		System.out.println(I1);//1111
		
		Integer I = Integer.valueOf("1111",2);
		System.out.println(I);//15
		
		Integer I2 = Integer.valueOf("1111",8);
		System.out.println(I2);//15
		
		Integer I3 = Integer.valueOf("1111",16);
		System.out.println(I3);//15
		
		Integer I4 = Integer.valueOf("1111",17);
		System.out.println(I4);//15
		
		Integer I5 = Integer.valueOf("1111",20);
		System.out.println(I5);//15
		
		Integer I6 = Integer.valueOf("1111",26);
		System.out.println(I6);//15
		
		Integer I7 = Integer.valueOf("1111",32);
		System.out.println(I7);//15
		
		
		Integer I8 = Integer.valueOf("1111",36);
		System.out.println(I8);//15
		
		/*Integer I = Integer.valueOf("1111",37);
		System.out.println(I);//RE: NumberFormatException */
		
		
		
		}
}