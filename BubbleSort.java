import java.util.Arrays;

public class BubbleSort {
	public static void main (String args[]) {
		int[] newArray = {4, 6, 2, 7, 1, 3};
		System.out.println(Arrays.toString(sort(newArray)));
	}

	public static int[] sort(int[] myArray) {
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray.length-1-i; j++) {
				System.out.print("(j): " + j + " (j+1): " + (j+1));
				System.out.println(Arrays.toString(myArray));
				if (myArray[j] > myArray[j+1]) {
					swap(myArray, j+1, j);
					System.out.println("Swapped!");
				}
			}
		}
		return myArray;
	}

	public static void swap(int[] myArray, int first, int second) {
		int temp = myArray[first];
		myArray[first] = myArray[second];
		myArray[second] = temp;
	}
}

// {4, 6, 2, 7, 1, 3}
// {4, 6, 2, 7, 1, 3}

