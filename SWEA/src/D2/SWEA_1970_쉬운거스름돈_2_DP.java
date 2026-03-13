package D2;
import java.util.Scanner;

public class SWEA_1970_쉬운거스름돈_2_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] change = {5000, 1000, 500, 100, 50, 10, 5, 1};;
			int[] money = new int[(N / 10) + 1];
			int[] last = new int[(N / 10) + 1];
			
			for(int i = 1; i <= N / 10; i++) {
				int minCount = Integer.MAX_VALUE;
				for(int j = 0; j < change.length; j++) {
					if(i < change[j]) continue;
					if(money[i - change[j]] + 1 < minCount) {
						minCount = money[i - change[j]] + 1;
						money[i] = minCount;
						
						last[i] = j;
					}
				}
			}
			
			int[] result = new int[change.length];
			int tmp = N / 10;
			while(tmp > 0) {
				int lc = last[tmp];
				result[lc]++;
				tmp -= change[lc];
			}
			
			System.out.println("#" + tc);
			for(int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			
		}
	}
}
