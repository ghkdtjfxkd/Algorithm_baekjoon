import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() -1);
        
        if(!s.contains(",")) {
            return new int[] {Integer.parseInt(s.substring(1, s.length() -1))};
        }
        
        Stack<Character> st = new Stack<>();
        List<String> ls = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '}') {
                st.add(s.charAt(i));
                continue; 
            }
            String cur = "";
            while(!st.empty() && s.charAt(i) == '}') {
                while(!st.empty() && st.peek() != '{') {
                    cur += st.pop();
                }
                st.pop();
                break;
            }
            
            StringBuilder sb = new StringBuilder(cur);
            ls.add(sb.reverse().toString());
        }
        
        ls.sort((s1, s2) -> s1.length() - s2.length());
        
        List<Integer> nums = new ArrayList<>();
        Set<String> used = new HashSet<>();
          
        for(int i = 0; i < ls.size(); i++) {
            String[] cur = ls.get(i).split(",");   
            for(int j = 0; j < cur.length; j++) {
                
                if(used.contains(cur[j])) continue;
                used.add(cur[j]);
                nums.add(Integer.parseInt(cur[j]));
                
            }
        }
        
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}