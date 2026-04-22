package 모의SW테스트;

import java.util.Scanner;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] map;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	static int max;
	static class Cafe {
		int r, c;
		
		public Cafe(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			max = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					boolean[] eat = new boolean[101];
					Cafe start = new Cafe(i, j);
					move(start, start, eat, 0);
				}
			}
			
			System.out.println("#" + tc + " " + (max == 0 ? -1 : max));
		}
	}
	
	static void move(Cafe st, Cafe cur, boolean[] eat, int dir) {
		int cnt = 0;
		
		if(st.r == cur.r && st.c == cur.c && dir == 3) {
			for(int i = 1; i < 101; i++) {
				if(eat[i]) cnt++;
			}
			if(max < cnt) {
				max = cnt;
			}
			return;
		}
		
		for(int i = dir; i < dir + 2 && i < 4; i++) {
			int nr = cur.r + dr[i];
			int nc = cur.c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(!eat[map[nr][nc]]) {
				eat[map[nr][nc]] = true;
				move(st, new Cafe(nr, nc), eat, i);
				eat[map[nr][nc]] = false;
			}
		}
	}
}
