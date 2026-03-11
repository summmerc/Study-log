package 모의SW테스트;
import java.util.Scanner;

public class SWEA_1952_수영장 {
	static int d, m1, m3, y;
	static int[] month;
	static int Min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			d = sc.nextInt();
			m1 = sc.nextInt();
			m3 = sc.nextInt();
			y = sc.nextInt();

			month = new int[13];
			for (int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
			}

			Min = y;
			check(0, 0);
			
			System.out.println("#" + tc + " " + Min);

		} //tc
	}

	static void check(int m, int sum) {
		if(sum > Min) return; 
		if(m >= 13) {
			Min = Math.min(Min, sum);
			return;
		}
		
		check(m + 1, sum + d * month[m]);
		check(m + 1, sum + m1);
		check(m + 3, sum + m3);
		
	}
}
