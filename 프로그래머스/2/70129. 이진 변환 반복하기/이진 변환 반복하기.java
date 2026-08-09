class Solution {
    public int[] solution(String s) {
        int tried = 0;
        int removed = 0; 
        int[] answer = new int[2];
        
        String curS = s;
        while(!curS.equals("1")) {
            tried++;
    
            String rmZero = curS.replace("0", "");
            removed += curS.length() - rmZero.length();
            
            curS = Integer.toBinaryString(rmZero.length());
        }
        answer[0] = tried;
        answer[1] = removed;
        return answer;
    }
}