package Level10;
import java.util.Scanner;

public class 부분수열의합_dp {
	static int N;
	static int M;
	static int[] A;
	static boolean found;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		boolean dp[] = new boolean[M + 1];
		
		dp[0] = true;
		for(int i = 0; i < N; i++) {
			int num = A[i];
			
			for(int j = M; j >= num; j--) {
				if(dp[j - num]) {
					dp[j] = true;
				}
			}
		}
		
		if(dp[M]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
