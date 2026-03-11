import java.util.Scanner;

public class SWEA_1226_미로1 {
	static int N = 16;
	static int[][] map;
	static int sr, sc;
	static int er, ec;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						sr = i;					}
					
				}
			} //map입력
			
			
		}
	}
}
