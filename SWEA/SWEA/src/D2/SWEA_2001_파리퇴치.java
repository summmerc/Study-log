package D2;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			if(N < 5 || N > 15) return;
			
			int M = sc.nextInt();
			if(M < 2 || M > N) return;
			
			int[][] area = new int[N][N];
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					area[row][col] = sc.nextInt();
					if(area[row][col] > 30 && area[row][col] < 0) break;
				}
			}
			
			int sum = 0;
			int[][] fly = new int[M][M];
			for(int row = 0; row <= N - M; row++) {
				for(int col = 0; col <= N - M; col++) {
					int total = 0;
					for(int i = 0; i < M; i++) {
						for(int j = 0; j < M; j++) {
							total += area[row + i][col + j];
						}
					}
					if(total > sum) sum = total;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		
	}
}
