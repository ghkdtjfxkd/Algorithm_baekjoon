import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            st.add(ingredient[i]); 
            if(st.size() < 4) continue;
            
            if(st.peek() == 1 && 
               st.get(st.size() -2) == 3 && 
               st.get(st.size() -3) == 2 && 
               st.get(st.size() -4) == 1) {
                st.pop();
                st.pop();
                st.pop();
                st.pop();
                answer++;
            }
        }
        
        return answer;
    }
}