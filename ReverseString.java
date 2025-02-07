// Susan Meinhardt
// Chpt2 PA
import java.util.Scanner;

public class ReverseString {

   public static String reverseString(String input) {
	   //Base case: if the string is empty or only has one character then it retuns the input
	   if (input == null || input.length() <= 1) {
		   return input;
	   }
	   
	   //Recursive: recerses the rest of the string
	   return reverseString(input.substring(1)) + input.charAt(0);
   }
   
   
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input, result;
		
		System.out.print("Enter the string to be reversed: ");
		input = scnr.nextLine();
		
		result = reverseString(input);
		
		System.out.printf("Reversed: %s\n", result);
	}
}