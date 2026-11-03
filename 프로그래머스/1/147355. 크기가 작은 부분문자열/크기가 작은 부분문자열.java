import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        long pVal = Long.parseLong(p);
        
        List<Long> numbers = new ArrayList<>(); 
        for(int i = 0; i <= t.length() - len; i++) {
            numbers.add(Long.parseLong(t.substring(i, i+len)));
        }
        
        return (int) numbers.stream().filter(n -> n <= pVal).mapToLong(Long::longValue).count();
    }
}