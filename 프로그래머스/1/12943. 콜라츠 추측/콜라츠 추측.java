class Solution {
    public int solution(int num) {
        if(num == 1) {
            return 0;
        }
        
        long cur = num;
        int count = 0;
        
        while(cur != 1) {
            if(count >= 500) {
                return -1;
            }

            if(cur % 2 == 0) {
                cur /= 2;
            } else {
                cur = cur * 3 + 1;
            }
            count++;
        }
        
        return count;
    }
}