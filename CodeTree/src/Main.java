import java.util.Scanner;

public class Main {
	static int N;
	static int[][] grid;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
