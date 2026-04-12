package D4;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_미로1 {
	static int N = 16;
	static int[][] map;
	static int startR, startC;
	static int targetR, targetC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();

			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						startR = i;
						startC = j;
					}

					if (map[i][j] == 3) {
						targetR = i;
						targetC = j;
					}
				}
			} // map입력

			visited = new boolean[N][N];

			int result = find(startR, startC);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int find(int sR, int sC) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(sR, sC));
		
		visited[sR][sC] = true;
		
		int find = 0;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(!visited[nr][nc] && map[nr][nc] == 0) {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
				
				if(map[nr][nc] == 3) return 1;
			}
		}
		
		return 0;
	}
}
