import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> countMap = new HashMap<>();
        
        for(String n : participant) {
            countMap.merge(n, 1, Integer::sum);
        }
        
        for(String n : completion) {
            countMap.merge(n, -1, Integer::sum);
        }
        
        return countMap.keySet().stream().filter(k -> countMap.get(k) != 0).findFirst().get();
    }
}