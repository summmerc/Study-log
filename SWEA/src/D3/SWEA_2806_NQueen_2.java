package D3;
import java.util.Scanner;

public class SWEA_2806_NQueen_2 {
	static int N;
	static int ans;
	static boolean[] usedCol;
	static boolean[] usedDiag1;
	static boolean[] usedDiag2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			usedCol = new boolean[N];
			usedDiag1 = new boolean[2 * N - 1];
			usedDiag2 = new boolean[2 * N - 1];
			
			ans = 0;
			
			make(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void make(int row) {
		if(row == N) {
			ans++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			int d1 = row + col;
			int d2 = row - col + N - 1;
			
			if(usedCol[col] || usedDiag1[d1] || usedDiag2[d2]) {
				continue;
			}
			
			usedCol[col] = true;
			usedDiag1[d1] = true;
			usedDiag2[d2] = true;
			
			make(row + 1);
			
			usedCol[col] = false;
			usedDiag1[d1] = false;
			usedDiag2[d2] = false;
		}
		
	}
}
