import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        int[] stat = new int[n + 1];
        String prev = words[0].substring(0,1);
            
        for(int i = 0; i < words.length; i++) {
            int ord = i % n + 1;
            stat[ord]++;
            
            String cur = words[i];
            int len = cur.length();

            if(used.contains(cur) || !cur.substring(0, 1).equals(prev)) {
               return new int[] {ord, stat[ord]}; 
            }
            used.add(cur);
            prev = cur.substring(len - 1, len);
        }
        
        return new int[] {0, 0};
    }
}