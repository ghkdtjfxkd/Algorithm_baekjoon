class Solution {
    public int solution(int n) {
        
        int[] sol = new int[n+1];

        sol[0] = 0;
        sol[1] = 1;
        sol[2] = 2;
        sol[3] = 3;
        
        for(int i = 3; i <= n; i++) {
            sol[i] = (sol[i - 1] + sol[i- 2]) % 1000000007;
        }
        
        return sol[n];
    }
}