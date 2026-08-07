class Solution {
    public int solution(int n) {
        int answer = 0;
        int cur = 1;
        
        while (cur < n) {
            if(n % cur == 1) {
                return cur;
            }
            cur++;
        }
        return answer;
    }
}