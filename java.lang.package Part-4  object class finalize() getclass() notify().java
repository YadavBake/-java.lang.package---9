
							java.lang.package Part-4 || object class||finalize()||getclass()||notify()
						  =============================================================================

--------------------
 getclass() Method 
--------------------

 -> We can use getclass() method to get runtime class defination of an object.
 
	  ---------------------------------
	  |	public final Class getClass() |
      ---------------------------------
	- By using this Class class object we can access class level properties like Fully Qualified name of the class,
	  Method information, constructor information etc.
			
			import java.lang.reflect.*;
			class Test 
			{
				public static void main(String args[])
				{
				  int count =0;		
				  Object o = new String("Durga");
				  Class c = o.getClass();
				  System.out.println("Fully Qualified name of class : "+c.getName());
				  Method[] m = c.getDeclaredMethod();
				  System.out.println("Method information : ");
				  for(Method m1 : m)
				  {
					  count++;
					  System.out.println(m1.getName());
				  }
				  System.out.println("The number of method : " +count);
				}
			}
	 
 ully Qualified name of class : java.lang.String
Method information :
value				valueOf					safeTrim			codePointBefore			 lastIndexOf
equals              valueOf                 encode              codePointCount           substring
length              valueOf                 getBytesNoRepl1     offsetByCodePoints       substring
toString            valueOf                 isASCII             checkBoundsBeginEnd      isEmpty
checkIndex          coder                   throwUnmappable     getBytes                 replace
hashCode            rangeCheck              throwUnmappable     getBytes                 replace
getChars            checkBoundsOffCount     replaceNegatives    getBytes                 matches
compareTo           lookupCharset           isNotContinuation   getBytes                 replaceFirst
compareTo           decode2                 isMalformed3        getBytes                 replaceAll
indexOf             decodeUTF8_UTF16        malformed3          getBytes                 split
indexOf             scale                   decode3             contentEquals            split
indexOf             decodeWithDecoder       isMalformed3_2      contentEquals            split
indexOf             newStringNoRepl1        decode4             nonSyncContentEquals     split
indexOf             newStringUTF8NoRepl     isMalformed4        regionMatches            splitWithDelimiters
indexOf             throwMalformed          malformed4          regionMatches            join
indexOf             throwMalformed          isMalformed4_2      startsWith               join
valueOf             encodeUTF8              isMalformed4_3      startsWith               join
valueOf             encode8859_1            encodeUTF8_UTF16    lastIndexOf              toLowerCase
valueOf             encode8859_1            isLatin1            lastIndexOf              toLowerCase
valueOf             encodeASCII             charAt              lastIndexOf              toUpperCase
valueOf             encodeWithEncoder       codePointAt         lastIndexOf              toUpperCase


trim          						decodeASCII     			lambda$indent$2                                                                                                    
strip                               equalsIgnoreCase            lambda$indent$1                                                                   
stripLeading                        compareToIgnoreCase         lambda$indent$0                                                                          
stripTrailing                       endsWith                    The number of method : 148                                                                
indexOfNonWhitespace                subSequence                                                                                        
lines                               concat                                                                              
repeat                              contains                                                                             
lastIndexOfNonWhitespace            indent                                                                                                 
outdent                             stripIndent                                                                           
isBlank                             translateEscapes                                                                      
toCharArray                         chars                                                                                     
format                              transform                                                                            
format                              formatted                                                                            
repeatCopyRest                      copyValueOf                                                                                  
resolveConstantDesc                 copyValueOf                                                                                       
resolveConstantDesc                 intern                                                                                            
codePoints                          checkOffset                                                                              
newStringNoRepl                     valueOfCodePoint                                                                              
getBytesUTF8NoRepl                  describeConstable                                                                                
getBytesNoRepl                      lambda$stripIndent$3                                                                         
                                                                          
                                                                               

  Ex. To display database vendor specific connection interface implemented class name.


	
		Connection con = DriverManager.getConnection("...");
		System.out.println(con.getClass().getName());
		

 Note 1 : 
 
	1. After loading every .class file JVM will create an object of the type "java.lang.Class" in heap area.
	
	2. Programmer can use this class object to get class level information.
	
	3. We can use getClass() method very frequently in reflection API.


----------------------
  finalize() Method 	
----------------------

 -> Just before distroying an object garbage collector call finalize() method to perform clean-up activities.

 -> Once finalize() method complites automatically garbage collector distroyes that object. 


-------------------------------
 wait(),notify(), notifyAll() 
-------------------------------

 -> We can use these methods for Inter Thread communication.

 -> The thread which is excepting updation, it is responsible to call wait() method. then immediatly the thread will 
	entered into waiting state.
	
 -> The thread responsible to perform updation, after performing updation the thread can call notify() method.
 
 -> The waiting thread will get that notification and continue its execution with those updates.
                                 






 
