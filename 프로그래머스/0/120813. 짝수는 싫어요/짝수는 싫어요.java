class Solution {
    public int[] solution(int n) {
        int arrLen = n / 2;
        if(n % 2 != 0)  arrLen++;    
         
        int[] answer = new int[arrLen];
        
        for(int i = 0; i < arrLen; i++) {
            answer[i] = i * 2 + 1;
        }
        
        return answer;
    }
}