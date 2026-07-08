class Solution {
    public long solution(long n) {
        double sq = Math.sqrt(n);
        
        long x = (long) sq;
        
        if(x * x == n) {
            return (x + 1) * (x + 1); 
        }
        return -1;
    }
}