// Susan Meinhardt
// Chpt3 PA
import java.util.Random;

public class BubbleSort {
	
	public static void main(String[] args) {
		// Initialize the array with a length of 25
		int[] array = new int[25];
		boolean isSorted = false;
		
		// Generate 25 random integers with values between 1 and 1000
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(1000) + 1;
		}
		
		// Print the array before it is sorted
		printArray(array, isSorted);
		
		// Sort the array
		isSorted = bubbleSort(array);
		
		// Print the array after it is sorted
		printArray(array, isSorted);
	}
	
	public static boolean bubbleSort(int[] array) {
		int i = 0;
		int j = 0;
		int temp;
		int n = array.length;
		for (i = 0; i < n - 1; i++) { // Outer loop
			for (j = 0; j < n - 1 - i; j++) { // Inner loop
				// Swap numbers if they are not in order
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		// Set isSorted to true so printArray() knows if the array has been sorted or not
		return true;
	}
	
	public static void printArray(int[] array, boolean isSorted) {
		int i = 0;
		// Determines if the array has been sorted or not
		if (isSorted == false) {
			System.out.println("Unsorted Array:");
		} 
		else {
			System.out.println("Sorted Array:");
		}
		
		// Prints out the current array
		for (i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}
	
}