package 모의SW테스트;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	static int N, M;
	static int R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int ans;
	
	static int[][] tunnel = {
			{},
			{0, 1, 2, 3},
			{1, 3},
			{0, 2},
			{0, 3},
			{0, 1},
			{1, 2},
			{2, 3}
	};
	
	static class Person {
		int r, c, time;

		public Person(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 데이터 입력
			
			ans = 1;
			
			bfs();
			
			System.out.println("#" + tc + " " + ans);
			
		}
	} //main
	
	static void bfs() {
		Queue<Person> q = new LinkedList<>();
		
		q.offer(new Person(R, C, 1));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			Person p = q.poll();
			
			if(p.time == L) continue;
			
			int type = map[p.r][p.c];
			for(int dir : tunnel[type]) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				if(map[nr][nc] == 0) continue;
				
				int nextType = map[nr][nc];
				int dir2 = (dir + 2) % 4;
				
				if(!canMove(nextType, dir2)) continue;
				
				visited[nr][nc] = true;
				ans++;
				q.offer(new Person(nr, nc, p.time + 1));
			}
		}
	}
	
	
	static boolean canMove(int type, int dir) {
		for(int d : tunnel[type]) {
			if(d == dir) return true;
		}
		
		return false;
	}
}
