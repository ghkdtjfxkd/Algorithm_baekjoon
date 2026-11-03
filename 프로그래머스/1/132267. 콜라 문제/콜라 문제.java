class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        int cur = n;
        
        while(cur >= a) {
            int changeCount = (cur / a);
            int changedCoke = changeCount * b;
            
            answer += changedCoke;
            cur = changedCoke + cur % a;
        }
        
        return answer;
    }
}