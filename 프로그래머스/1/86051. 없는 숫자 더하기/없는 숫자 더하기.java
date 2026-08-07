class Solution {
    public int solution(int[] numbers) {
        boolean[] exists = new boolean[10];
        
        for(int num : numbers) {
            if(!exists[num]) exists[num] = true;
        }
        
        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if(!exists[i]) answer += i; 
        }
        return answer;
    }
}