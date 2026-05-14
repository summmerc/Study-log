package Level10;
import java.util.Scanner;

public class 정수사각형최솟값의최대 {
	
	static int N;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int[][] grid;
	static int[][] find;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		grid = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		find = new int[N + 1][N + 1];
		if(N == 1) {
			System.out.println(grid[1][1]);
			return;
		}
		
		find[1][1] = grid[1][1];
		
		for(int i = 2; i <= N; i++) {
			find[i][1] = Math.min(find[i - 1][1], grid[i][1]);
		}
		
		for(int i = 2; i <= N; i++) {
			find[1][i] = Math.min(find[1][i - 1], grid[1][i]);
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= N; j++) {
				int max = Math.max(find[i - 1][j], find[i][j - 1]);
				find[i][j] = Math.min(max, grid[i][j]);
			}
		}
		
		System.out.println(find[N][N]);
	}
	
}
