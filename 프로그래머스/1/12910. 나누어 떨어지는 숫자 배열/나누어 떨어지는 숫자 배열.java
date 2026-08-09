import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        boolean[] div = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                div[i] = true;
                count++;
            }
        }
        
        if(count == 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[count];
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(div[i]) {
                answer[idx++] = arr[i];
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}