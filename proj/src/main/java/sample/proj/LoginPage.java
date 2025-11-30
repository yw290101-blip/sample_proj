package sample.proj;

import java.util.Iterator;

public class LoginPage {
	
	
    public void reverseString() {
        System.out.println("Hello World!");
        
      //using stringbuilder
        StringBuilder str = new StringBuilder("Yogesh");
        StringBuilder reversed = str.reverse();
        System.out.println(reversed);
        //using for loop
        String Str1 = "Yogeshwaran";
        String rev = "";
        for(int i=Str1.length()-1; i>=0; i--){
            rev += Str1.charAt(i);
        }
        System.out.println(rev);  
    }
    
    public void OddOrEven() {
    	 int a = 11;
         if(a%2==0){
             System.out.println("Given number is even");
         } else{
             System.out.println("Given number is odd");
         }
     }
    
    //Print all odd number
    public void PrintOdd() {
    	int count = 0;
    	for (int i = 1 ; i >= 20 ; i++) {
			if(i%2==1) {
				count = count+1;
			}
		}
    	System.out.print("count");
    }
  }

