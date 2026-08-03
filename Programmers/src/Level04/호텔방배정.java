package Level04;

import java.util.*;

class Solution {
    static Map<Long, Long> map = new HashMap<>();
    static long[] answer;
    public long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++) {
                answer[i] = findRoom(room_number[i]);
            }
        return answer;
        }
        
    static long findRoom(long roomNum) {
        if(!map.containsKey(roomNum)) {
            map.put(roomNum, roomNum + 1);
            return roomNum;
        }
        
        long next = findRoom(map.get(roomNum));
        
        map.put(roomNum, next + 1);
        
        return next;
    }
}