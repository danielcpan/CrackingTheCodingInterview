import java.util.Arrays;

public class OddNumbers {
        static int[] oddNumbers(int l, int r) {
        // int[] myArray = new int[(r/l)+1];
        int[] myArray = new int[(int)Math.ceil((r-l)/2.0)+1];
        System.out.println(Math.ceil((r-l)/2)+1);
        int index = 0;
        if (l % 2 == 0) {
            for (int i = l+1; i <= r; i+=2) {
                myArray[index] = i;
                index++;
            }            
        }
        else {
            for (int j = l; j <= r; j+=2) {
                myArray[index] = j;
                index++;    
            }            
        }
        System.out.println(Arrays.toString(myArray));
        return myArray;
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{1,2,3,4,5};
        System.out.println(oddNumbers(3, 9));
    }   
}