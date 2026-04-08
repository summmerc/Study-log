package D6;
import java.util.Scanner;

public class SWEA_1263_사람네트워크2 {
	static int N;
	static int[][] map;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N + 1][N + 1];
			dist = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j) {
						map[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int con = sc.nextInt();
					if (con == 1)
						map[i][j] = con;
				}
			}

			for (int x = 1; x <= N; x++) {
				for (int st = 1; st <= N; st++) {
					if (map[st][x] == Integer.MAX_VALUE)
						continue;
					for (int ed = 1; ed <= N; ed++) {
						if (map[x][ed] == Integer.MAX_VALUE)
							continue;
						map[st][ed] = Math.min(map[st][ed], map[st][x] + map[x][ed]);
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i] += map[i][j];
				}
				if (dist[i] < min) {
					min = dist[i];
				}
			}

			System.out.println("#" + tc + " " + min);

		}
	}
}
