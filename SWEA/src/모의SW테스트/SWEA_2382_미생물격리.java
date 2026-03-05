package 모의SW테스트;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2382_미생물격리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[][] mi = new int[K][4];

			for (int i = 0; i < K; i++) {
				mi[i][0] = sc.nextInt();
				mi[i][1] = sc.nextInt();
				mi[i][2] = sc.nextInt();
				mi[i][3] = sc.nextInt();
			}

			int[] dr = { 0, -1, 1, 0, 0 };
			int[] dc = { 0, 0, 0, -1, 1 };

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < K; j++) {
					if (mi[j][2] == 0)
						continue;

					mi[j][0] += dr[mi[j][3]];
					mi[j][1] += dc[mi[j][3]];

					int nr = mi[j][0];
					int nc = mi[j][1];

					if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
						mi[j][2] /= 2;
						if (mi[j][3] % 2 == 0)
							mi[j][3]--;
						else {
							mi[j][3]++;
						}
					}
				}


				Arrays.sort(mi, (a, b) -> {
					if (a[0] != b[0])
						return a[0] - b[0];
					if (a[1] != b[1])
						return a[1] - b[1];
					return b[2] - a[2];
				});

				for (int k = 0; k < K - 1; k++) {
					if(mi[k][2] == 0) continue;
					
					int next = k + 1;
					while (next < K && mi[k][0] == mi[next][0] && mi[k][1] == mi[next][1]) {
						mi[k][2] += mi[next][2];
						mi[next][2] = 0;
						mi[next][0] = -1;
						next++;
					}
					k = next - 1;
				}

			}

			int total = 0;
			for (int i = 0; i < K; i++) {
				total += mi[i][2];
			}

			System.out.println("#" + tc + " " + total);
		}
	}
}
