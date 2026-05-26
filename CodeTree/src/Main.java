import java.util.Scanner;

public class Main {
	static int N;
	static int[][] grid;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		grid = new int[N][N];
		
		int[][] sum = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
				
				if(i == 0) {
					sum[i][j] = grid[i][j];
				} else {
					sum[i][j] = sum[i - 1][j] + grid[i][j];
				}
			}
		}
		
		int max = grid[0][0];
		
		for(int r1 = 0; r1 < N; r1++) {
			for(int r2 = r1; r2 < N; r2++) {
				int currSum = 0;
				
				for(int c = 0; c < N; c++) {
					int cSum = sum[r2][c];
					if(r1 > 0) {
						cSum -= sum[r1 - 1][c];
					}
					
					currSum += cSum;
					
					if(currSum > max) {
						max = currSum;
					}
					
					if(currSum < 0) {
						currSum = 0;
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
