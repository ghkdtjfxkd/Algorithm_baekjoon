import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numStr = String.valueOf(n);
        
        for(int i = 0; i < numStr.length(); i++) {
            answer += Character.getNumericValue(numStr.charAt(i));
        }

        return answer;
    }
}