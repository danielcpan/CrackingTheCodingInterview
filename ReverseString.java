public class ReverseString {
	public static void main(String args[]) {
		System.out.println(reverseStringIterative("Hellos"));
		System.out.println(reverseStringRecursive("Hellos Friends"));
		//olleh
	}

	public static String reverseStringIterative(String myStr) {
		char[] strArray = myStr.toCharArray();
		for (int i = 0; i < strArray.length/2; i++) {
			swap(strArray, i, strArray.length - 1 - i);
		}
		return new String(strArray);
	}

	public static String reverseStringRecursive(String myStr) {
		if (myStr.length() == 1 || myStr == null) {
			return myStr;
		}
		return reverseStringRecursive(myStr.substring(1)) + myStr.charAt(0);
	}

	public static void swap(char[] array, int first, int second) {
		char temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}