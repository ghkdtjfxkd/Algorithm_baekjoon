import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] numCount = new int[1001];
        
        for(int i = 0; i < array.length; i++) {
            numCount[array[i]] += 1;
        }
        
        int feq = 0;
        int feqIdx = 0;
        boolean isDup = false;
        
        for(int i = 0; i < numCount.length; i++) {
            if(feq == numCount[i]) {
                isDup = true;
                continue;
            }
            
            if(feq < numCount[i]) {
                isDup = false;
                feq = numCount[i];
                feqIdx = i;
            }
            
        }
        
        if(isDup) {
            return -1;
        }
        
        return feqIdx;
    }
}