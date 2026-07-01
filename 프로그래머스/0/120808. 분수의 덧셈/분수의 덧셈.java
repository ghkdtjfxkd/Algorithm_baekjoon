class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
       
        int finalNumer = (numer1 * denom2) + (numer2 * denom1);
        int finalDenom = denom1 * denom2;
        
        int currentGcd = gcd(finalNumer, finalDenom);
        
        int[] answer = new int[2];
        answer[0] = finalNumer / currentGcd;
        answer[1] = finalDenom / currentGcd;
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}