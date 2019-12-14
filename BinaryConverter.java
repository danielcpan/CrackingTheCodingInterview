public class BinaryConverter {
	public static void main(String args[]) {
		System.out.println(decToBin(9));
		System.out.println(binToDec(1111));
	}	

	public static String decToBin(int myDecimal) {
		String result = "";
		if (myDecimal == 0) {
			return Integer.toString(myDecimal);
		}
		while (myDecimal >= 1) {
			result += myDecimal % 2;
			myDecimal = myDecimal / 2;
		}
		StringBuilder sb = new StringBuilder(result);
		return sb.reverse().toString();
	}

	public static int binToDec(int myBinary) {
		int result = 0;
		int index = 0;
		while (myBinary >= 1) {
			if (myBinary % 10 == 1) {
				result += Math.pow(2, index);	
			}
			myBinary /= 10;
			index++;
		}
		return result;		
	}
}
