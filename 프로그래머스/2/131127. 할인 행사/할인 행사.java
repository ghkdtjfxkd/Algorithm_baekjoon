import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> sales = new HashMap<>();

        for(int i = 0; i <= discount.length - 10; i++) {
            sales = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
                sales.merge(discount[j], 1, Integer::sum);
            }
            
            boolean exist = false;
            
            for(String s : want) {
                if(sales.containsKey(s)) {
                    exist = true;
                } else {
                    exist = false;
                    break;
                }
            }
            if(!exist) continue;
            
            boolean possible = false;
            for(int j = 0; j < want.length; j++) {
                if(sales.get(want[j]) != number[j]) {
                    possible = false;
                    break;
                } else {
                    possible = true;
                }
            }
            if(possible) answer++;
        }
        
        
        return answer;
    }
}