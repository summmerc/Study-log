package Level12;
import java.util.Arrays;
import java.util.Scanner;

public class 점개수세기2 {
	static int N, Q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Q = sc.nextInt();
		
		int[] X = new int[N];
		int[] Y = new int[N];
		int[] sX = new int[N];
		int[] sY = new int[N];
		
		for(int i = 0; i < N; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
			sX[i] = X[i];
			sY[i] = Y[i];
		}
		
		Arrays.sort(sX);
		Arrays.sort(sY);
		
		int[] uX = new int[N];
		int[] uY = new int[N];
		int cntX = 0;
		int cntY = 0;
		
		for(int i = 0; i < N; i++) {
			if(i == 0 || sX[i] != sX[i - 1]) {
				uX[cntX++] = sX[i];
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(i == 0 || sY[i] != sY[i - 1]) {
				uY[cntY++] = sY[i];
			}
		}
		
		int[][] sum = new int[cntX + 1][cntY + 1];
		
		for(int i = 0; i < N; i++) {
			int cx = getIdx(uX, cntX, X[i]) + 1;
			int cy = getIdx(uY, cntY, Y[i]) + 1;
			sum[cx][cy]++;
		}
		
		for(int i = 1; i <= cntX; i++) {
			for(int j = 1; j <= cntY; j++) {
				sum[i][j] += sum[i - 1][j] + sum[i][j-1] - sum[i - 1][j - 1];
			}
		}
		
		for(int i = 0; i < Q; i++) {
			int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int cx1 = getIdx(uX, cntX, x1) + 1;
            int cy1 = getIdx(uY, cntY, y1) + 1;
            int cx2 = getIdx(uX, cntX, x2 + 1);
            int cy2 = getIdx(uY, cntY, y2 + 1);

            // 대망의 2차원 구간합 공식 한 줄로 즉시 점의 개수 도출!
            int ans = sum[cx2][cy2] - sum[cx1 - 1][cy2] - sum[cx2][cy1 - 1] + sum[cx1 - 1][cy1 - 1];
            System.out.println(ans);
		}
	}
	
	static int getIdx(int[] arr, int size, int target) {
		int start = 0;
		int end = size;
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
}
