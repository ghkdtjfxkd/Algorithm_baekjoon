class Solution {
    public String solution(String s) {
        int sLen = s.length();
        if(sLen % 2 == 0) {
            return s.substring(sLen/2 -1, sLen/2 + 1);
        }
        
        return s.substring(sLen/2, sLen/2 + 1);
    }
}