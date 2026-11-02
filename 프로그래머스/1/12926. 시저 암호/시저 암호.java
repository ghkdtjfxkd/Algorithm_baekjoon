import java.util.*;
class Solution {
    public String solution(String s, int n) {
        char[] carr = s.toCharArray();
        
        String answer = "";
        
        for(char c: carr) {
            int left = n;
                        
            while(left > 0) {
                if(c == ' ') break;
                left--;
                if(c == 'z'){
                    c = 'a';
                    continue;
                }
                
                if(c == 'Z'){
                    c = 'A';
                    continue;
                }
                c += 1;
            }
            
            answer += c;
        }
        return answer;
    }
}