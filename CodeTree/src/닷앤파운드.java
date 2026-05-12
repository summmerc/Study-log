import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 닷앤파운드 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int ResultCircum;
	static int ResultCnt;
	static double minDiv;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//둘레 나누기 개수가 가장 작은 값의 개수랑 둘레 프린트
		N = sc.nextInt();
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		ResultCircum = 0;
		ResultCnt = 0;
		minDiv = Double.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ResultCnt + " " + ResultCircum);
	}
	
	static void bfs(int sR, int sC) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sR, sC}); //시작 r, 시작 c, 개수, 둘레
		
		int circum = 0;
		int cnt = 0;
		
		visited[sR][sC] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			cnt++;
			
			int r = curr[0];
			int c = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					circum++;
					continue;
				}
				if(map[nr][nc] == '.') {
					circum++;
					continue;
				}
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
			
		}
		
		double cDiv = (double)circum / cnt;
		
		if(cDiv < minDiv) {
			ResultCircum = circum;
			ResultCnt = cnt;
			minDiv = cDiv;
		} 
		else if(circum * ResultCnt == ResultCircum * cnt) {
			if(circum < ResultCircum) {
				ResultCircum = circum;
				ResultCnt = cnt;
			}
		}
		
		System.out.println("circum: " + circum);
		System.out.println("cDiv : " + cDiv);
		System.out.println("cnt : " + cnt);
		System.out.println("ResultCnt :" + ResultCnt);
		System.out.println("ResultCircum : " + ResultCircum);
		System.out.println();
	
		
	}
}
