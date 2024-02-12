class TestSb {
	
	public static void main(String args[]){
		
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefghijklmnop");
		sb.append("q");
		sb.append("abcdefghijklmnop");
		sb.append("q");
		sb.append("r");
		System.out.println(sb.capacity());
	}
}	