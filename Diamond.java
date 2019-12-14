public class Diamond {
	public static void main(String args[]) {
		int height = 5;
		printDiamond(height);
	}
	public static void printDiamond ( int height ) {
		
		int width = height * 2 - 1;
		
		for (int i = height; i >= 0; i-- ) {
			
			for (int j = 0; j <= width + 1; j++ ) {
				
				if ( j >= height - i && j <= height + i ) {
					
					System.out.print( "*" );
				}
				else {
					
					System.out.print( " " );
				}
			} // end inner for loop
			
			System.out.println();
		} // end outer for loop
	}
}