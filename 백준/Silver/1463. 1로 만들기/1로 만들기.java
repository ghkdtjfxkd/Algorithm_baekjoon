import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] memo;
    public static void main(String[] args) throws IOException {
        int tmp = Integer.parseInt(br.readLine());

        memo = new Integer[tmp + 1];
        memo[0] = memo[1] = 0;

        System.out.println(recursion(tmp));
    }

    static int recursion(int n) {

        // memo 되지 않았다면?
        if(memo[n] == null){
            // 각 방법들의 마지막에 + 1 을 해줌으로서 n 이라는 숫자에 도달했을 때, 그 숫자까지 걸린 횟수를 표기 할 수 있다.
            
            // 6으로 나누어 떨어진다면? 가능한 방법은 1 빼기 그리고 (3 또는 2로 나누기)
            // 방법을 다 시도해보고 제일 작은 수로 갱신한다.
            if(n % 6 == 0){
                memo[n] = Math.min(recursion(n-1), Math.min(recursion(n /3), recursion(n /2 ))) + 1;
            }
            // 3으로만 나누어 떨어지는 경우
            else if(n % 3 == 0){
                memo[n] = Math.min(recursion(n/3), recursion(n - 1)) + 1;
            }
            // 2로만 나누어 떨어지는 경우
            else if(n % 2 == 0){
                memo[n] = Math.min(recursion(n/2), recursion(n - 1)) +1;
            }
            // 2 혹은 3으로 나누어 떨어지지 않는 경우
            else {

                memo[n] = recursion(n -1) + 1;
            }
        }
        return memo[n];
    }
}