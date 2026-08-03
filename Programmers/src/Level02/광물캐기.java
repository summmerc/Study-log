package Level02;

import java.util.*;

public class 광물캐기 {
	static int[] group;
    static int result;
    public int solution(int[] picks, String[] minerals) {
        int totalT = picks[0] + picks[1] + picks[2];
        int max = Math.min(minerals.length, totalT * 5);
        
        int Msize = (max + 4) / 5;
        
        int[] group = new int[Msize];
        
        for(int i = 0; i < max; i++) {
            int idx = i / 5;
            
            if(minerals[i].equals("diamond")) {
                group[idx] += 100;
            }
            else if(minerals[i].equals("iron")) {
                group[idx] += 10;
            }
            else {
                group[idx] += 1;
            }
        }
        
        Arrays.sort(group);
         
        result = 0;
        
        for(int i = Msize - 1; i >= 0; i--) {
            int score = group[i];
            
            int dia = score / 100;
            int iron = (score % 100) / 10;
            int stone = score % 10;
            
            if(picks[0] > 0) {
                result += dia + iron + stone;
                picks[0]--;
            }
            else if(picks[1] > 0) {
                result += (dia * 5) + iron + stone;
                picks[1]--;
            }
            else if(picks[2] > 0) {
                result += (dia * 25) + (iron * 5) + stone;
                picks[2]--;
            } else {
                break;
            }
        }
        return result;
    }
}
