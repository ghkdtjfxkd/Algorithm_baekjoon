import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command: commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            int[] arr = new int[end - start + 1];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = array[i+start-1];
            }
            
            Arrays.sort(arr);
            answer[idx++] = arr[target-1];
        }
        

        return answer;
    }
}