import java.util.*;

class Solution {
    
    Set<Integer> made = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        madeNumbers("", numbers, visited);
        
        int count = 0;
        for(int i : made) {
            boolean isP = true;
            
            if(i == 0 || i == 1){
                continue;
            }
            
            for(int j = 2; j < i; j++) {       
                if(i % j == 0) {
                    isP = false;
                    break;
                }
            }
            
            if(isP) {
                count++;
            }
        }
        return count;
    }
    
    void madeNumbers(String current, String numbers, boolean[] visited) {
        if(!current.equals("")) {
            made.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                madeNumbers(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
}