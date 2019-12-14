import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class RomanNumeralConverter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();

		Map<String, Integer> romanNumeralMap = new HashMap<String, Integer>();
		romanNumeralMap.put("M", 	1000);	
		romanNumeralMap.put("CM", 	900);			
		romanNumeralMap.put("D", 	500);
		romanNumeralMap.put("CD", 	400);		
		romanNumeralMap.put("C", 	100);	
		romanNumeralMap.put("XC", 	90);			
		romanNumeralMap.put("L", 	50);
		romanNumeralMap.put("XL", 	40);		
		romanNumeralMap.put("X", 	10);
		romanNumeralMap.put("IX", 	9);		
		romanNumeralMap.put("V", 	5);
		romanNumeralMap.put("IV", 	4);		
		romanNumeralMap.put("I", 	1);

		try {	// If Integer
			System.out.println(convertToRoman(romanNumeralMap, Integer.parseInt(input)));
		} catch(NumberFormatException e) {	// If Roman Numeral
			System.out.println(convertToDecimal(romanNumeralMap, input));
		}
	}

	public static int convertToDecimal(Map<String, Integer> romanNumeralMap, String romanNumeral) {
		int currentDecimal = 0;
		int previousValue = 0;
		for (int i = 0; i < romanNumeral.length(); i++) {
			if (romanNumeralMap.containsKey(Character.toString(romanNumeral.charAt(i)))) {
				if (romanNumeralMap.get(Character.toString(romanNumeral.charAt(i))) > previousValue) {
					currentDecimal = currentDecimal - (2*previousValue);
				}
				previousValue = romanNumeralMap.get(Character.toString(romanNumeral.charAt(i)));
				currentDecimal += romanNumeralMap.get(Character.toString(romanNumeral.charAt(i)));
			}
		}
		return currentDecimal;
	}


	public static String appendRomanNum(String currentRomanNum, Map<String, Integer> romanNumeralMap, int decimal, String romanNum) {
		int divisions = decimal / romanNumeralMap.get(romanNum);
		for (int i = 0; i < divisions; i++) {
			currentRomanNum += romanNum;
		}
		return currentRomanNum;
	}
	
	public static String convertToRoman(Map<String, Integer> romanNumeralMap, int decimal) {
		String currentRomanNum = "";

		if (decimal >= romanNumeralMap.get("M")) {	// 1000
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "M");
			decimal = decimal % romanNumeralMap.get("M");
		}
		if (decimal >= romanNumeralMap.get("CM")) {	// 900
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "CM");
			decimal = decimal % romanNumeralMap.get("CM");
		}		
		if (decimal >= romanNumeralMap.get("D")) {	// 500
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "D");
			decimal = decimal % romanNumeralMap.get("D");
		}
		if (decimal >= romanNumeralMap.get("CD")) {	// 400
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "CD");
			decimal = decimal % romanNumeralMap.get("CD");
		}		
		if (decimal >= romanNumeralMap.get("C")) {	// 100
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "C");
			decimal = decimal % romanNumeralMap.get("C");
		}
		if (decimal >= romanNumeralMap.get("XC")) {	// 90
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "XC");
			decimal = decimal % romanNumeralMap.get("XC");
		}		
		if (decimal >= romanNumeralMap.get("L")) {	// 50
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "L");
			decimal = decimal % romanNumeralMap.get("L");
		}
		if (decimal >= romanNumeralMap.get("XL")) {	// 40
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "XL");
			decimal = decimal % romanNumeralMap.get("XL");
		}		
		if (decimal >= romanNumeralMap.get("X")) {	// 10
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "X");
			decimal = decimal % romanNumeralMap.get("X");
		}
		if (decimal >= romanNumeralMap.get("IX")) {	// 9
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "IX");
			decimal = decimal % romanNumeralMap.get("IX");
		}		
		if (decimal >= romanNumeralMap.get("V")) {	// 5
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "V");
			decimal = decimal % romanNumeralMap.get("V");
		}
		if (decimal >= romanNumeralMap.get("IV")) {	// 4
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "IV");
			decimal = decimal % romanNumeralMap.get("IV");
		}		
		if (decimal >= romanNumeralMap.get("I")) {	// 1
			currentRomanNum = appendRomanNum(currentRomanNum, romanNumeralMap, decimal, "I");
			decimal = decimal % romanNumeralMap.get("I");
		}
		return currentRomanNum;
	}
}