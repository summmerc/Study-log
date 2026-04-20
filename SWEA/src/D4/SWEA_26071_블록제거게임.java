package D4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_26071_블록제거게임 {
	static int N;
	static int max;
	static List<Integer> block;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			max = 0;
			block = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				block.add(sc.nextInt());
			}
			
			game(0);
			
			System.out.println("#" + tc + " " + max);
		}				
	}
	
	static void game(int total) {
		if(block.isEmpty()) {
			max = Math.max(total, max);
			return;
		}
		
		for(int i = 0; i < block.size(); i++) {
			int s = score(i);
			int value = block.remove(i);
			game(total + s);
			block.add(i, value);
		}
		
		
	}
	
	static int score(int i) {
		int size = block.size();
		if(i > 0 && i < size - 1) {
			return block.get(i - 1) * block.get(i + 1);
		}
		else if(i == 0 && size > 1) {
			return block.get(i + 1);
		}
		else if(i == size - 1 && size > 1) {
			return block.get(i - 1);
		}
		else {
			return block.get(i);			
		}
	}
}
