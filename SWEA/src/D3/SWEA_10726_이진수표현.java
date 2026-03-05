package D3;
import java.util.Scanner;

public class SWEA_10726_이진수표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.print("#" + tc + " ");
			if((M & (1 << N) - 1) == (1 << N) - 1)
				System.out.println("ON");
			else
				System.out.println("OFF");
		}
	}
}
