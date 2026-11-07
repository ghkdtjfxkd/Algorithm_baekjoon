import java.util.*;
class Solution {
    public int solution(int n) {
        int count = 0;
        int[] sums = new int[n+1];
        
        for(int i = 1; i < n + 1; i++) {
            sums[i] = sums[i-1] + i;
        }
        
        int startIdx = 0;
        int endIdx = 1; 
        
        while (endIdx <= n) {
            int cur = sums[endIdx] - sums[startIdx]; 
            
            if(cur == n) {
                count++;
                startIdx++;
            } else if(cur < n) {
                endIdx++;
            } else {
                startIdx++;
            }
        }

        return count;
    }
}