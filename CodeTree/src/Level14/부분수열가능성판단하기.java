package Level14;
import java.util.Scanner;

public class 부분수열가능성판단하기 {
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N + 1];
		B = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 1; i <= M; i++) {
			B[i] = sc.nextInt();
		}

		int[] L = new int[M + 2];
		int[] R = new int[M + 2];

		int i = 1;

		for (int j = 1; j <= M; j++) {
			while(i <= N && A[i] != B[j]) {
				i++;
			}

			if (i == N + 1) {
				L[j] = N + 1;
			} else {
				L[j] = i;
				i++;
			}
		}

		i = N;
		for(int j = M; j >= 1; j--) {
			while(i >= 1 && A[i] != B[j]) {
				i--;
			}
			
			if(i == 0) {
				R[j] = 0;
			}
			else {
				R[j] = i;
				i--;
			}
		}
		
		int cnt = 0;
		for(int k = 1; k <= M; k++) {
			int leftEnd = (k == 1) ? 0 : L[k - 1];
			int rightStart = (k == M) ? N + 1 : R[k + 1];
			
			if(leftEnd < rightStart)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
