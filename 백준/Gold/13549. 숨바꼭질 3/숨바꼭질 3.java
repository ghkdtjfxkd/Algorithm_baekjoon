import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[100001];

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        Deque<int[]> d = new LinkedList<>();
        d.addFirst(new int[]{n, 0});

        while (!d.isEmpty()) {
            int[] cur = d.poll();
            int x = cur[0];
            int t = cur[1];

            if (x == k) {
                System.out.println(t);
                return;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            int[] dx = {x + 1, x - 1, 2 * x};

            for (int i = 2; i >= 0; i--) {
                if (dx[i] < 0 || dx[i] >= visited.length) {
                    continue;
                }

                if (!visited[dx[i]]) {
                    if (i == 2) {
                        d.addFirst(new int[]{dx[i], t});
                    } else {
                        d.addLast(new int[]{dx[i], t + 1});
                    }
                }
            }
        }
    }
}