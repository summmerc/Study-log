package D4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			Stack<Character> stack = new Stack<>();
			String line = sc.next();
			
			int pices = 0;
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(') {
					stack.push(c);
				} else {
					stack.pop();
					if(line.charAt(i - 1) == '(') {
						pices += stack.size();
					}
					else pices += 1;
				}
			}
			
			System.out.println("#" + tc + " " + pices);
		}
	}
}
