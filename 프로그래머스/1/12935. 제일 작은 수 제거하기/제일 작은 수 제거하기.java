import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[] {-1};
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }
        
        List<Integer> deleted = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            deleted.add(arr[i]);   
        }
        
        if(deleted.size() == 0) return new int[] {-1};
        
        return deleted.stream().mapToInt(Integer::intValue).toArray();
    }
}
