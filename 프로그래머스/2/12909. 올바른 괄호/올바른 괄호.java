import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        if(s.startsWith(")") || s.endsWith("(")) {
            return false;
        }
            
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}