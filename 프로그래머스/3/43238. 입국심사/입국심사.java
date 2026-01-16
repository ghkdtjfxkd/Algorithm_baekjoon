import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
    
        Arrays.sort(times);
        
        long left = times[0];
        long right = (long) times[times.length -1] * n;
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long processing = 0;
            
            for(int t : times) {
                processing += mid / t;
            }
            
            if(processing >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}