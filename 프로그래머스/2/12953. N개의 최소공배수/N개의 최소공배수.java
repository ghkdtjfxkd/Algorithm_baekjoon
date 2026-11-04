class Solution {
    public int solution(int[] arr) {
        int n = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            n = lcm(arr[i], n);
        }
        
        return n;
    }
    int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}