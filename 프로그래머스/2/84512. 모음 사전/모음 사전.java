import java.util.*;
class Solution {
    public int solution(String word) {
        String[] alpha = {"x","A", "E", "I", "O", "U", "X"};
        
        Set<String> words = new HashSet<>();
        
        for(int i = 0; i < 7; i++) {
            String cur = alpha[i];
            for(int j = 0; j < 7 ; j++) {
                
                for(int k = 0; k < 7; k++) {
                    
                    for(int l = 0; l < 7; l++) {
                        
                        for(int p = 0; p < 7; p++) {
                            
                            cur = alpha[i] + alpha[j] + alpha[k] + alpha[l] + alpha[p];
                            cur = cur.replaceAll("X", "x");
                            cur = cur.replaceAll("x", "");
                            if(cur.length() == 0) {
                                continue;
                            }
                            words.add(cur);
                        }  
                    }  
                }  
            }  
        }
        
        return words.stream().sorted().toList().indexOf(word) + 1;
    }

}