package 모의SW테스트;
import java.util.Scanner;

public class SWEA_2112_보호필름 {
	static int D, W, K;
	static int[][] film;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			film = new int[D][W];
			
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			
			ans = K;
			
			makeFilm(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void makeFilm(int idx, int cnt) {
		if(test()) {
			ans = Math.min(cnt, ans);
			return;
		}
		if(ans <= cnt) return;
		
		if(idx == D) {
			return;
		}
		
		makeFilm(idx + 1, cnt);
		
		int[] tmp = new int[W];
		for(int j = 0; j < W; j++) {
			tmp[j] = film[idx][j];
		}
		
		for(int j = 0; j < W; j++) {
			film[idx][j] = 0;
		}
		makeFilm(idx + 1, cnt + 1);
		
		for(int j = 0; j < W; j++) {
			film[idx][j] = 1;
		}
		makeFilm(idx + 1, cnt + 1);
		
		for(int j = 0; j < W; j++) {
			film[idx][j] = tmp[j];
		}
		
		
	}
	
	static boolean test() {
		for(int c = 0; c < W; c++) {
			int cnt = 1;
			boolean isOk = false;
			for(int r = 1; r < D; r++) {
				if(film[r][c] == film[r - 1][c]) cnt++;
				else cnt = 1;
				
				if(cnt >= K) {
					isOk = true;
					break;
				}
			}
			
			if(!isOk) return false;
		}
		return true;
	}
}
