package D3;
import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int win;
	static int lose;
	static int[] kCard;
	static int[] iCard;
	static int[] pCard;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			kCard = new int[9];
			iCard = new int[9];
			pCard = new int[9];
			visited = new boolean[9];
			boolean[] iskCard = new boolean[19];
			
			for(int i = 0; i < 9; i++) {
				kCard[i] = sc.nextInt();
				iskCard[kCard[i]] = true;
			}
			
			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(!iskCard[i])
					iCard[idx++] = i;
			}
			
			win = 0;
			lose = 0;
			
			perm(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		} //tc
	} //main
	
	static void perm(int cnt) {
		if(cnt == 9) {
			calculate();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			pCard[cnt] = iCard[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}
	
	static void calculate() {
		int kScore = 0;
		int iScore = 0;
		
		for(int i = 0; i < 9; i++) {
			if(kCard[i] > pCard[i]) {
				kScore += kCard[i] + pCard[i];
			} else {
				iScore += kCard[i] + pCard[i];
			}
		}
		
		if(kScore > iScore) win++;
		else if(kScore < iScore) lose++;
	}
}
