class Solution {
    public int solution(int n) {
        int piece = 6;
        int pizza = 1;        
        
        while(piece % n != 0) {
            piece += 6;
            pizza++;
        }
        return pizza;
    }
}
