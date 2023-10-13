package com.example.demo;

public class StringStudy {

	
	public static void main(String[] args) {
		
		String a1= "Apple";
		String a2= "Mango";
		String a3="Apple";
		
		System.out.println(a1==a2);
		
		//intern
		
		//A pool of strings, initially empty, is maintained privately by the class String. 
		//When the intern method is invoked, if the pool already contains a string equal to this 
		//String object as determined by the equals(Object) method, then the string from the pool isreturned. 
		//Otherwise, this String object is added to thepool and a reference to this String object is returned. 

		
		String str1 = new String("Scaler by InterviewBit").intern();  //Line1  
		String str2 = new String("Scaler by InterviewBit").intern(); //Line2  
		System.out.println(str1 == str2); //prints true  
		
		
		
		// string stringbuffer stringbuilder
		
	       StringBuilder stbu=new StringBuilder();
	       //Initial object size
	       System.out.println(stbu.capacity());
	       String str="Scaler";
	       System.out.println(str);
	       String str11 = new String("InterviewBit");
	       System.out.println(str11);
	       str11 += " Articles";         //string update
	       System.out.println(str11);
	}
}
