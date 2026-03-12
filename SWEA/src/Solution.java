import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	//LinkedList
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			int M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				String st = sc.next();
				
				if(st.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for(int a = x; a < y; a++) {
						
					}
					
					
				}
			}
		}
	}
}
