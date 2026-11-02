class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {gdc(n, m), n * m / gdc(n, m)};
        return answer;
    }
    
    int gdc(int a, int b) {
        while(b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}