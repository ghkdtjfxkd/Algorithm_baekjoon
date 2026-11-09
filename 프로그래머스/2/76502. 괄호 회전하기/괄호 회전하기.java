import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() % 2 != 0) {
            return 0;
        }
        
        Map<Character, Character> cm = new HashMap<>();
        
        cm.put('(', ')');
        cm.put('[', ']');
        cm.put('{', '}');
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            String shifted = s.substring(i) + s.substring(0, i);
            Stack<Character> st = new Stack<>();
            
            for(int j = 0; j < shifted.length(); j++) {
                char cur = shifted.charAt(j);
                if(!st.empty() && cm.get(st.peek()) == cur) {
                    st.pop();
                    continue;
                } 
                
                if(cm.containsKey(cur)) st.push(cur);
            }
                   
            if(st.empty()) count++; 
        }
   
        
        return count;
    }
}