import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while(st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        
       return min + " " + max;
    }
}