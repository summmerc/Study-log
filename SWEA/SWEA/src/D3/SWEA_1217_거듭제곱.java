package D3;
import java.util.Scanner;

public class SWEA_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int answer = function(N, M);
			
		System.out.println("#" + tc + " " + answer);	
		}
	}
	
	public static int function(int N, int M) {
		if(M == 1) return N;
		return N * function(N, M - 1);
	}
}
