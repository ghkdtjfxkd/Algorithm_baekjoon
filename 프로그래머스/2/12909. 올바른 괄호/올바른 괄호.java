import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] parentheses = s.toCharArray();
        
        Stack<Character> st = new Stack<>();
        
        for(char c : parentheses) {
            
            if(st.isEmpty()) {
                
                if(c == ')') {
                    return false;
                }
                
                st.push(c);
                continue;
            }
            
            if(c == '(') {
                st.push(c);
            }
            
            if(st.peek() == '(') {
                if(c == ')') {
                    st.pop();
                }
            }
            
        }
        
        if(!st.isEmpty()) {
            return false;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}