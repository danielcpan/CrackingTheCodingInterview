public class FindNumber {
    static String findNumber(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return "Yes";
            }
        }
        return "No";

    }
    public static void main(String[] args) {
    	int[] myArray = new int[]{1,2,3,4,5};
    	System.out.println(findNumber(myArray, 1));
    }	
}