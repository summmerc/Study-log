package D3;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			Queue<Integer> password = new ArrayDeque<>();
			
			for(int i = 0; i < 8; i++) {
				password.add(sc.nextInt());
			}
			
			int minus = 1;
			while(true) {
				int tmp = password.poll();
				tmp -= minus;
				minus++;
				if(minus == 6)
					minus = 1;
				if(tmp <= 0) {
					password.add(0);
					break;
				}
				password.add(tmp);
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(password.poll() + " ");
			}
			System.out.println();
		}
	}
}
