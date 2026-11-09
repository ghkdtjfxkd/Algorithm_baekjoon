import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int cur =1;
        int idx =0;
        
        Stack<Integer> st = new Stack<>();
        
        while(idx < order.length) {
            if(cur == order[idx]) { 
                answer++; 
                cur++; 
                idx++;
                continue; 
            }
            
            if(!st.empty() && order[idx] == st.peek()) {
                st.pop(); 
                answer++; 
                idx++;
                continue;
            }
            
            if(cur > order.length) break; 
            
            st.push(cur++);
        }
        return answer;
    }
}