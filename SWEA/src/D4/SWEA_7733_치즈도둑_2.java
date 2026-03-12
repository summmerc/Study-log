package D4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑_2 {
	static int N, ans;
	static int[][] cheese;
	static boolean[][] eat;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cheese = new int[N][N];
			eat = new boolean[N][N];
			ans = 1;
			
			int max = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if(max < cheese[i][j])
						max = cheese[i][j];
				}
			}//치즈 입력
			
			for(int day = 1; day < max; day++) {
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(cheese[r][c] > day)
							eat[r][c] = false;
						else
							eat[r][c] = true;
					}
				}
				
				int cnt = 0;
				Queue<Pos> q = new LinkedList<>();
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(eat[i][j]) continue;
						q.add(new Pos(i, j));
						eat[i][j] = true;
						cnt++;
						
						while(!q.isEmpty()) {
							Pos p = q.poll();
							for(int d = 0; d < 4; d++) {
								int nr = p.r + dr[d];
								int nc = p.c + dc[d];
								
								if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
								if(eat[nr][nc]) continue;
								
								eat[nr][nc] = true;
								q.add(new Pos(nr, nc));
							} //4방향
						}
					}
				}
				ans = Math.max(cnt, ans);
			}
			System.out.println("#" + tc + " " + ans);
			
		} //tc
	} //main
}
