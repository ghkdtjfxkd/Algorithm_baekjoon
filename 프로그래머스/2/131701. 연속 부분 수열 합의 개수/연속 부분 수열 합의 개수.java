import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++) {
            int idx = i;  
            int sum = 0;
    
            for(int j = 0; j < elements.length; j++) {
                sum += elements[idx];
                sums.add(sum);
        
                idx++;               
                if(idx == elements.length) idx = 0;
            }
        }
        return sums.size();
    }
}