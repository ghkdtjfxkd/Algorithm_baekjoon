import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int pick = nums.length / 2;
        
        Set<Integer> ps = new HashSet<>();
        
        Arrays.stream(nums).forEach(n -> ps.add(n));
        int uniqueType = ps.size();
        
        return pick < uniqueType ? pick : uniqueType;
    }
}