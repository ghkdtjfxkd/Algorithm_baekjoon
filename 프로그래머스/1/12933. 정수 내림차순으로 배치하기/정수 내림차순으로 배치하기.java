import java.util.*;

class Solution {
    public long solution(long n) {
        String numStr = String.valueOf(n);
        
        Integer[] numbers = new Integer[numStr.length()];
        
        for(int i = 0; i < numbers.length; i ++) {
            numbers[i] = Character.getNumericValue(numStr.charAt(i));
        }
        
        Arrays.sort(numbers, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int num : numbers) {
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }
}