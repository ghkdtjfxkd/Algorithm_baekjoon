class Solution {
    public long solution(int price, int money, int count) {
        long pay = 0;
        
        for(int i = 1; i <= count; i++) {
            pay += price * i;
        }
        
        long diff = money - pay; 
        
        if(diff > 0) {
            return 0;
        }

        return Math.abs(diff);
    }
}