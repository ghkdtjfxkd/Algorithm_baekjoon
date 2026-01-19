import java.util.*;

class Solution {
    
    Set<int[]> yc = new HashSet<>();
    
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i == 0) {
                yc.add(new int[]{i , yellow / i});
            }
        }
        
        for(int[] c : yc) {
            if(brown == 2 * ((c[0] + 2) + c[1])) {
                return new int[] {Math.max(c[0], c[1]) + 2 , Math.min(c[0], c[1]) + 2};
            }
        }
        
        int[] answer = {};
        return answer;
    }
    
}