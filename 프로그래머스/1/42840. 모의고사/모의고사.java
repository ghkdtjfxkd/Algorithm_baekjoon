import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int second[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int third[] = {3, 3, 1, 1, 2,2, 4, 4, 5, 5}; 
        Map<Integer, Integer> scoreBoard = new HashMap<>();
        
        scoreBoard.put(1, 0);
        scoreBoard.put(2, 0);
        scoreBoard.put(3, 0);
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == i % 5 + 1) {
                scoreBoard.merge(1, 1, Integer::sum);
            }    
            
            if(answers[i] == second[i % second.length]) {
                scoreBoard.merge(2, 1, Integer::sum);
            }
            
            if(answers[i] == third[i % 10]) scoreBoard.merge(3, 1, Integer::sum);
        }
        
        int max = Integer.MIN_VALUE;
        for(int score : scoreBoard.values()) {
            max = Math.max(score , max);
        }
        
        final int max1 = max; 
        int winCount = (int) scoreBoard.values().stream()
            .filter(v -> v == max1)
            .mapToInt(Integer::intValue)
            .count();
        
        return scoreBoard.keySet().stream()
            .sorted((k1, k2) -> scoreBoard.get(k2) - scoreBoard.get(k1))
            .mapToInt(Integer::intValue)
            .limit(winCount)
            .toArray();
    }
}