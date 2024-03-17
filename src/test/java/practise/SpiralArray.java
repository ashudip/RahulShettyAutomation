package practise;

public class SpiralArray {

	public static void main(String[] args) {

		int[][] spiralarray = { { 1, 2, 3,4 }, { 5, 6, 7,8 }, { 9, 10, 11,12} };
		int minrow = 0;
		int mincol = 0;
		int maxrow = spiralarray.length-1;
		int maxcol = spiralarray[0].length-1;
		int maxcount = maxcol * maxrow;
		System.out.println(maxcount);
		int count = 0;
		while (count < maxcount) {
			// left wall
			for (int i = minrow, j = mincol; j <= maxcol ; j++) {
				System.out.println(spiralarray[i][j]);
				count++;
			}
			minrow++;
			//right wall
			for (int i = minrow, j = maxcol; i <= maxrow; i++) {
				System.out.println(spiralarray[i][j]);
				count++;
			}
			maxcol--;
			//bottomwall
			for (int i = maxrow, j = maxcol; j >= mincol; j--) {
				System.out.println(spiralarray[i][j]);
				count++;
			}
			maxrow--;
			for (int i = maxrow, j = mincol; i >= minrow ; i--) {
				System.out.println(spiralarray[i][j]);
				count++;
			}
			
		}

	}
}
