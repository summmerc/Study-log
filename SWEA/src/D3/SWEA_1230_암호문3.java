package D3;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230_암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
		LinkedList<Integer> list = new LinkedList<>();
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			String s = sc.next();
			if(s.equals("I")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for(int j = 0; j < y; j++) {
					list.add(x + j, sc.nextInt());
				}
			}
			
			if(s.equals("D")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for(int j = 0; j < y; j++) {
					list.remove(x);
				}
			}
			
			if(s.equals("A")) {
				int y = sc.nextInt();
				
				for(int j = 0; j < y; j++) {
					list.add(sc.nextInt());
				}
			}
		}
		
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.poll() + " ");
			}
			
			System.out.println();
		}
	
	}
}
