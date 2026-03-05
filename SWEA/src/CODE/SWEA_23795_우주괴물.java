package CODE;

import java.util.Scanner;

public class SWEA_23795_우주괴물 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			int notT = 0;
			int mr = 0;
			int mc = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 0) notT++;
					if(map[i][j] == 2) {
						mr = i;
						mc = j;
					}
				}
			}
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			int minus = 0;
			
			for(int i = 0; i < 4; i++) {
				int nr = mr;
				int nc = mc;
				
				while(true) {
					nr += dr[i];
					nc += dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) {
						break;
					}
					
					if(map[nr][nc] == 0) {
						minus++;
						
						map[nr][nc] = -1;
					}
				}
			}
			
			System.out.println("#" + tc + " " + (notT - minus));
		}
	}
}
