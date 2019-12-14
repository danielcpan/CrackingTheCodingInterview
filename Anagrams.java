import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagrams {

    public static int numberNeeded(String first, String second) {
        int[] lettercounts = new int[26];
        System.out.println(Arrays.toString(lettercounts));
        for(char c : first.toCharArray()){
            lettercounts[c-'a']++;
            // System.out.println(c-'a');
        }
        for(char c : second.toCharArray()){
            lettercounts[c-'a']--;
        }
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        System.out.println(Arrays.toString(lettercounts));
        return result;
    }

    public static int numberNeeded1(String first, String second) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Map<Character, Integer> secondMap = new HashMap<Character, Integer>();

        for (int i = 0; i < first.length(); i++) {
            if (!charMap.containsKey(first.charAt(i))) {
                charMap.put(first.charAt(i), 1);
            }
            else if (charMap.containsKey(first.charAt(i))){
                int valCount = charMap.get(first.charAt(i));
                charMap.put(first.charAt(i), valCount + 1);
            }
            // else if (charMap.containsKey(first.charAt(i)) && second == true){
            //     int valCount = charMap.get(first.charAt(i));
            //     charMap.put(first.charAt(i), valCount - 1);
            // }
        }

        for (int i = 0; i < second.length(); i++) {
            if (!charMap.containsKey(second.charAt(i))) {
                charMap.put(second.charAt(i), -1);
            }
            else if (charMap.containsKey(second.charAt(i))){
                int valCount = charMap.get(second.charAt(i));
                charMap.put(second.charAt(i), valCount - 1);
            }
            // else if (charMap.containsKey(first.charAt(i)) && second == true){
            //     int valCount = charMap.get(first.charAt(i));
            //     charMap.put(first.charAt(i), valCount - 1);
            // }
        }        



        // populateMap(charMap, first, false);
        // populateMap(charMap, second, true);
        // populateMap(secondMap, second, false);
        System.out.println("Before:");
        printMap(charMap);
        // printMap(secondMap);

        System.out.println("After:");
        printMap(charMap);
        // printMap(secondMap);
        return getSumMap(charMap);
    }

    public static int getSumMap(Map<Character, Integer> charMap) {
        int sum = 0;
        for (int vals : charMap.values()) {
            sum += Math.abs(vals);
        }
        return sum;
    }

    public static void populateMap(Map<Character, Integer> charMap, String myString, boolean second) {
        for (int i = 0; i < myString.length(); i++) {
            if (!charMap.containsKey(myString.charAt(i))) {
                charMap.put(myString.charAt(i), 1);
            }
            else if (charMap.containsKey(myString.charAt(i)) && second != true){
                int valCount = charMap.get(myString.charAt(i));
                charMap.put(myString.charAt(i), valCount + 1);
            }
            else if (charMap.containsKey(myString.charAt(i)) && second == true){
                int valCount = charMap.get(myString.charAt(i));
                charMap.put(myString.charAt(i), valCount - 1);
            }
        }    
    }

    public static void printMap(Map<Character, Integer> charMap) {
              // Get a set of the entries
      Set charSet = charMap.entrySet();
      
      // Get an iterator
      Iterator iterator = charSet.iterator();
      
      // Display elements
      while(iterator.hasNext()) {
         Map.Entry me = (Map.Entry)iterator.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
    }
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input First String: ");
        String a = scan.next();
        System.out.println("Input Second String: ");
        String b = scan.next();
        System.out.println(numberNeeded1(a, b));
    }
}
