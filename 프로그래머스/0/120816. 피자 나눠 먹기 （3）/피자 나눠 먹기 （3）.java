class Solution {
    public int solution(int slice, int n) {
        int piece = slice;
        int pizza = 1;
        
        while(piece < n) {
            pizza++;
            piece += slice;
        }
        
        return pizza;
    }
}