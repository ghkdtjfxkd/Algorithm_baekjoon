import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] s = new String[numbers.length];
        boolean onlyZero = true;
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0) {
                onlyZero = false;
            }
            s[i] = String.valueOf(numbers[i]);
        }
        
        if(onlyZero) {
            return "0";
        }
        
        Arrays.sort(s, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2); 
        });
        
        String answer = "";
        for(String c : s) {
            answer = answer.concat(String.valueOf(c));
        }
        
        return answer;
    }
}