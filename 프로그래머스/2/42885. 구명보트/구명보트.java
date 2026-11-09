import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int heavyIdx = people.length - 1;
        int lightIdx = 0;
        
        while(lightIdx <= heavyIdx) {
            answer++;
            int remaining = limit;
            int seat = 2;
            
            while(remaining >= people[heavyIdx] && lightIdx < heavyIdx && seat > 0) {
                remaining -= people[heavyIdx--];
                seat--;
            }
            
            
            while(remaining >= people[lightIdx] && lightIdx <= heavyIdx && seat > 0) {
                remaining -= people[lightIdx++];
                seat--;
            }
        }
                
        return answer;
    }
}