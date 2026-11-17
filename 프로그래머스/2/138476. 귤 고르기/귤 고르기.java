import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCount = new HashMap<>();
        
        for(int g : tangerine) {
            sizeCount.merge(g, 1, Integer::sum);
        }
            
        List<Integer> counts = sizeCount.values().stream().sorted(Comparator.reverseOrder()).toList();
        
        for(int i = 0; i < counts.size(); i++) {
            k -= counts.get(i);
            if(k <= 0) return i + 1;
        }
       
        return 1;
    }
}