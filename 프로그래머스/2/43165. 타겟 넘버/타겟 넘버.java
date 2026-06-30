class Solution {
    public int solution(int[] numbers, int target) {
        return bfs(numbers, 0, target, 0);
    }
    
    public static int bfs(int[] numbers, int idx, int target, int sum) {
        
        if(idx == numbers.length) {
            return 0;
        }
        
        if(idx == numbers.length - 1) {
            
            if(sum + numbers[idx] == target) {
                return 1;
            }
            
            if(sum - numbers[idx] == target) {
                return 1;
            }
            
            return 0;
        }
        
        return bfs(numbers, idx + 1, target, sum - numbers[idx]) + 
            bfs(numbers, idx + 1, target, sum + numbers[idx]);
    }
}