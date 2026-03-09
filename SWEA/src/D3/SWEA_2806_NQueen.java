package D3;
import java.util.Scanner;

public class SWEA_2806_NQueen {
	static int N;
	static int[] col;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			col = new int[N];
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
		
		for(int c = 0; c < N; c++) {
			col[row] = c;
			
			if(isPossible(row)) {
				make(row + 1);
			}
		}
	}
	
	static boolean isPossible(int row) {
		for(int i = 0; i < row; i++) {
			if(col[row] == col[i])
				return false;
			if(Math.abs(row - i) == Math.abs(col[row] - col[i])) 
				return false;
		}
		return true;
	}
}
