import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> memScore = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            memScore.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int k =0; k < photo[i].length; k++) {
                sum += memScore.getOrDefault(photo[i][k], 0);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}