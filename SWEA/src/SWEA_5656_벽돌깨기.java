import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	static int min;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			game(0, map);
			
		}
	}
	
	static void game(int count, int[][] map) {
		if(count == N) {
			int left = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] != 0) left++;
				}
			}
			
			min = Math.min(min, left);
			return;
		}
		
		for(int c = 0; c < W; c++) {
			int[][] nMap = map;
			
			int r = 0;
			while(r < H && map[c][r] == 0) r++;
			
			if(r < H) {
				
			}
		}
	}
}
