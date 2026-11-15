import java.util.*;
class Solution {
    String[] alpha = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean found = false;
    public int solution(String word) {
        dfs("", word);
        return count;    
    }
    
    void dfs(String curWord, String target) {
        
        if (found) return;                     

        if (!curWord.isEmpty()) {              
            count++;                            
            if (curWord.equals(target)) {      
                found = true;
                return;
            }
        }

        if (curWord.length() == 5) return;  
        
        for (int i = 0; i < alpha.length; i++) {
            dfs(curWord + alpha[i], target);
        }
    }
}