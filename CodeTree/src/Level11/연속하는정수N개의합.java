package Level11;
import java.util.Scanner;

public class 연속하는정수N개의합 {
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        int[] num = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
        }
        
        int cnt = 0;
        int sum = 0;
        int j = 0;
        
        for(int i = 1; i <= N; i++) {
            while(j + 1 <= N && sum + num[j + 1] <= M) {
                sum += num[j + 1];
                j++;
            }
            
            if(sum == M) {
                cnt++;
            }
            
            sum -= num[i];
        }
        
        System.out.println(cnt);
    }
}
