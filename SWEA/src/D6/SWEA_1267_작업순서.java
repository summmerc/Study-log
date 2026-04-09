package D6;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_작업순서 {
	static int V;
	static int E;
	static int[][] adjArr;
	static int[] inDegree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			adjArr = new int[V + 1][V + 1];
			inDegree = new int[V + 1];
			
			for(int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adjArr[from][to] = 1;
				inDegree[to]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i <= V; i++) {
				if(inDegree[i]== 0)
					q.add(i);
			}
			
			System.out.print("#" + tc + " ");
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				System.out.print(curr + " ");
				for(int to = 1; to <= V; to++) {
					if(adjArr[curr][to] == 1) {
						inDegree[to]--;
						
						if(inDegree[to] == 0)
							q.add(to);
					}
				}
			}
			
			System.out.println();
		}
	}
}
