class Solution {
    public boolean solution(int x) {
        String numStr = String.valueOf(x);
        
        int digitSum = 0;
        
        for(char c: numStr.toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
     
        return x % digitSum == 0;
    }
}