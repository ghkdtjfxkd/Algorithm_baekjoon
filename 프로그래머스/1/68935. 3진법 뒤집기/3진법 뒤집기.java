class Solution {
    public int solution(int n) {        
        String triN = "";
        while(n > 0) {
            triN += String.valueOf(n % 3);
            n /= 3;
        }
        
        int sum = 0;
        int cur = 0;
        int exp = triN.length() - 1;
        while(cur < triN.length()) {
            sum += (triN.charAt(cur++) - '0') * (int) Math.pow(3, exp--);
        }
        
        return sum;
    }
}