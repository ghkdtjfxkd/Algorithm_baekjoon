import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        
        int[] ans = new int[num]; 
        
        if(num % 2 != 0) {
            int midValue = total / num;    
            int mIdx = num / 2;
            
            ans[mIdx] = midValue;
            for(int i = mIdx + 1; i < num; i++) {
                ans[i] = ans[i - 1] + 1; 
            }
            
            for(int i = mIdx -1; i >= 0; i--) {
                ans[i] = ans[i + 1] - 1; 
            }
        }
        
        if(num % 2 == 0) {
            int midValue = total / num;
            
            int mIdxL = num / 2 - 1;
            int mIdxR = mIdxL + 1;
        
            ans[mIdxL] = midValue;
            ans[mIdxR] = midValue + 1;
            
            for(int i = mIdxR + 1; i < num; i++) {
                ans[i] = ans[i - 1] + 1; 
            }
            
            for(int i = mIdxL; i >= 0; i--) {
                ans[i] = ans[i + 1] - 1; 
            }
        }
     
        return ans;
    }
}