package D4;
import java.util.Scanner;

public class SWEA_5643_키순서 {
	static int N;
	static int M;
	static int[][] height;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			height = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j)
						height[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int t = sc.nextInt();

				height[s][t] = 1;
			}

			for (int x = 1; x <= N; x++) {
				for (int st = 1; st <= N; st++) {
					if(height[st][x] == Integer.MAX_VALUE) continue;
					for (int ed = 1; ed <= N; ed++) {
						if(height[x][ed] == Integer.MAX_VALUE) continue;
						
						height[st][ed] = Math.min(height[st][ed], height[st][x] + height[x][ed]);
					}
				}
			}
			
			int count = 0;
			
			for(int i = 1; i <= N; i++) {
				boolean find = true;
				for(int j = 1; j <= N; j++) {
					if(i != j) {
						if(height[i][j] == Integer.MAX_VALUE && height[j][i] == Integer.MAX_VALUE) {
							find = false;
							break;
						}						
					}
				}
				
				if(find) count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}
