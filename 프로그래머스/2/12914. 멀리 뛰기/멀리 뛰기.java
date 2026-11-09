class Solution {
    public long solution(int n) {        
        if(n == 1 || n == 2) {
            return n;
        }
        
        long[] sums = new long[n + 1];
        
        sums[0] = 1l;
        sums[1] = 1l;
        sums[2] = 2l;
        
        for(int i = 3; i <= n; i++) {
            sums[i] = (sums[i - 2] + sums[i - 1]) % 1234567l;
        }
        
        return sums[n];
    }
}