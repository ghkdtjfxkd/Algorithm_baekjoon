import java.util.*;
class Solution {
    public String solution(String s) {
        if(s.length() == 1) {
            return s.toUpperCase();
        }
        
        List<String> converted = new ArrayList<>();
        String[] tokens = s.split(" ", -1);

        for(int i = 0; i < tokens.length; i ++) {
            String cur = tokens[i];
            
            if(cur.length() == 1) {
                converted.add(cur.toUpperCase());
                continue;
            }
            
            String[] str = cur.split("");
            String changed = "";
            changed += str[0].toUpperCase();
            for(int k = 1; k < str.length; k ++) {
                if(k % 2 == 0) str[k] = str[k].toUpperCase();
                else str[k] = str[k].toLowerCase();
                changed += str[k];
            }
            converted.add(changed);
        }
         
        return String.join(" ", converted);
    }
}