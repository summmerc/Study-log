package 모의SW테스트;
import java.util.Scanner;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] map;
	static int MAX;
	static int[] dr = {-1, 1, 1, -1};
	static int[] dc = {1, 1, -1, -1};
	
	static class Cafe {
		int r, c;
		int dir;
		
		public Cafe(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			map = new int[N + 2][N + 2];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			MAX = 0;
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					boolean[] eat = new boolean[101];
					Cafe start = new Cafe(i, j);
					move(start, start, eat, 0);
				}
			}
			
			System.out.println("#" + tc + " " + (MAX == 0 ? -1 : MAX));
		}
	}
	
	static void move(Cafe st, Cafe curr, boolean[] eat, int dir) {
		int cnt = 0;
		if(st.r == curr.r && st.c == curr.c && dir == 3) {
			for(int i = 1; i < 101; i++) {
				if(eat[i]) cnt++;
			}
			
			MAX = Math.max(MAX, cnt);
			return;
		}
		
		for(int i = dir; i < dir + 2 && i < 4; i++) {
			int nr = curr.r + dr[i];
			int nc = curr.c + dc[i];
			
			if(!eat[map[nr][nc]] && map[nr][nc] != 0) {
				eat[map[nr][nc]] = true;
				move(st, new Cafe(nr, nc), eat, i);
				eat[map[nr][nc]] = false;
			}
		}
		
	}
}
