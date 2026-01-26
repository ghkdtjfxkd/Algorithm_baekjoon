import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[] {a, 1});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            long n = cur[0];
            long count = cur[1];

            if(n == b) {
                System.out.println(count);
                return;
            }

            if(n > b || n < 0) continue;

            q.offer(new long[] {2 * n, count + 1});
            q.offer(new long[] {Long.parseLong(n + "1") , count +1});
        }
        System.out.println(-1);
    }
}
