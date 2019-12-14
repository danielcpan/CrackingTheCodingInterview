public class CountPaths {
	public static int numberOfPaths(int row, int col) {
		//Recursive Solution
		// System.out.println("Row: " + row + " Col: " + col);
		// if (row == 1 || col == 1) {
		// 	System.out.println("Reached End");
		// 	return 1;
		// }
		// return numberOfPaths(row-1, col) + numberOfPaths(row, col-1);

		//Dynamic Programming Solution
		int count[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			count[i][0] = 1;
		}

		for (int j = 0; j < col; j++) {
			count[0][j] = 1;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		return count[row-1][col-1];
	}

    public static int krakenCount(int m, int n) {
        //m = rows
        //n = cols
        int[][] ways = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            ways[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // ways[i][j] = ways[i-1][j] + ways[i][j-1];
                //Diagonal
                ways[i][j] = ways[i-1][j] + ways[i][j-1] + ways[i-1][j-1];
            }
        }
        return ways[m-1][n-1];
    }

	public static void main(String[] args) {
		System.out.println(numberOfPaths(2,3));
		System.out.println(krakenCount(2,3));
	}
}