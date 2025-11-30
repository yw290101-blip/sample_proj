package sample.proj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test(enabled = false)
    public void shouldAnswerWithTrue() {
       
		Integer num = null ; // Change this number to test
          Scanner in = new Scanner(System.in);
          num = in.nextInt();
          if (num % 2 == 0) {
              System.out.println(num + " is an even number.");
          } else {
              System.out.println(num + " is an odd number.");
          }
      }
	
	@Test(enabled = false)
	public void FindingArrayValues() {
		int lar[] = {1,3,5,10};
		int max = lar[0];
		int min = lar[0];
		for (int i = 1; i<lar.length;i++) {
			if (lar[i]>max) {
				max=lar[i];
			}
			if (lar[i]<min) {
				min = lar[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
		//-----------------------------
		int ty[]= {20,40,50,100};
		int larger = ty[0];
		int smaller = ty[0];
		for(int i =1; i<ty.length;i++) {
			//Finding largest number in array
			if (ty[i]>larger) {
				larger=ty[i];
			}
			//Finding smallest number in array
			if (ty[i]<smaller) {
				smaller = ty[i];
			}
		}
		System.out.println(larger);
		System.out.println(smaller);
	}
    
	@Test
	public void countingWordsfromSen() {
		String str = "I am yogeshwaran and my city is coimbatores";
		String[] word =str.split("\s");
		//System.out.println(word.length()); //output is 8
		String largestWord ="";
		
		for(String words : word) {
			if (words.length()>largestWord.length()) {
				largestWord = words ;
			}
		}
		System.out.println("Largest word in sentence : "+largestWord);

	        // Split the string into words
	        String[] words = str.split(" ");

	        ArrayList<String> largestWords = new ArrayList<>();
	        int maxLength = 0;

	        for (String sinword : words) {
	            if (sinword.length() > maxLength) {
	                // Found a new longest word
	                maxLength = sinword.length();
	                largestWords.clear();
	                largestWords.add(sinword);
	            } else if (sinword.length() == maxLength) {
	                // Found another word with the same max length
	                largestWords.add(sinword);
	            }
	        }

	        System.out.println("The largest word(s): " + largestWords);

	}
	
}
