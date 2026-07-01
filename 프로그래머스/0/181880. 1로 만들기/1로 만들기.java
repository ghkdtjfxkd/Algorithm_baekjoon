class Solution {
    public int solution(int[] num_list) {
        int count = 0;
        
        for(int i =0; i < num_list.length; i++) {
            int num = num_list[i];
            while(num > 1) {
                if(num % 2 == 0) {
                    num /= 2;
                    count++;
                } else {
                    num -= 1;
                    num /=2;
                    count++;
                }
            }
        }
        int answer = count;
        return answer;
    }
}