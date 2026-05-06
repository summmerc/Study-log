import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 벽짚고미로탈출하기 {
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dc = { 1, 0, -1, 0 };
	static int dir;

	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		char[][] maze = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				maze[i][j] = line.charAt(j);
			}
		}

		dir = 0;
		count = 0;
		boolean[][][] visited = new boolean[n][n][4];
		find(x, y, maze, visited, n);
	}

	static void find(int startR, int startC, char[][] maze, boolean[][][] visited, int size) {

		int r = startR;
		int c = startC;
		int time = 0;

		while (true) {
			if (visited[r][c][dir] == true) {
				System.out.println(-1);
				return;
			}
			visited[r][c][dir] = true;

			int cDir = (dir + 1) % 4;
			int cr = r + dr[cDir];
			int cc = c + dc[cDir];

			if (cr >= 0 && cr < size && cc >= 0 && cc < size && maze[cr][cc] == '#') {
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
					System.out.println(time + 1);
					return;
				}

				if (maze[nr][nc] == '#') {
					dir = (dir + 3) % 4;
				} else {
					r = nr;
					c = nc;
					time++;
				}
			} else {
				dir = cDir;
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
					System.out.println(time + 1);
					return;
				}
				if (maze[nr][nc] != '#') {
					r = nr;
					c = nc;
					time++;
				}
			}
		}

	}
}
