import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> uq = new HashSet<>();
        
        int half = nums.length/2;
        
        for (int n : nums) {
            uq.add(n);
        }
            
        return Math.min(uq.size(), half);
    }
}