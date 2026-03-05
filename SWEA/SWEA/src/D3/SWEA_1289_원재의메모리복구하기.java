package D3;
import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String o = sc.next();
			char reset = '0';
			int cnt = 0;
			
			for(int i = 0; i < o.length(); i++) {
				if(o.charAt(i) != reset) {
					cnt++;
					reset = o.charAt(i);
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
