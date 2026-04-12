package D3;
import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {

	static char[][] map;
	static int H;
	static int W;
	static int startr, startc;
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[] direction = { '^', 'v', '<', '>' };
	static int d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
						startr = i;
						startc = j;
					}
				}
			}

			N = sc.nextInt();

			String line = sc.next();

			int r = startr;
			int c = startc;
			
			switch(map[startr][startc]) {
			case '^' :
				d = 0;
				break;
			case 'v':
				d = 1;
				break;
			case '<':
				d = 2;
				break;
			case '>':
				d = 3;
				break;
			}

			for (int i = 0; i < N; i++) {
				char ch = line.charAt(i);

				if (ch == 'S') {
					int curR = r;
					int curC = c;
					while(true) {
						int nr = curR + dr[d];
						int nc = curC + dc[d];
						
						if(nr < 0 || nr >= H || nc < 0 || nc >= W) break;
						
						if(map[nr][nc] == '.' || map[nr][nc] == '-') {
							curR = nr;
							curC = nc;
						}
						else if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
						else if(map[nr][nc] == '#') break;
					}
				}

				else {
					switch (ch) {
					case 'U':
						d = 0;
						break;
					case 'D':
						d = 1;
						break;
					case 'L':
						d = 2;
						break;
					case 'R':
						d = 3;
						break;
					}

					map[r][c] = direction[d];
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = direction[d];
						r = nr;
						c = nc;

					}
				}

			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} // tc
	}
}
