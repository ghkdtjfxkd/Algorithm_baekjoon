import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] l = new int[100001];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int in = cur[0];
            int t = cur[1];

            if(in == k) {
                System.out.println(t);
                return;
            }

            int[] nxt = {in - 1, in + 1, in * 2};

            for (int i : nxt) {
                if(i >= 0 && i < 100001) {
                    if(l[i] == 0) {
                        l[i] = t + 1;
                        q.offer(new int[] {i, l[i]});
                    }
                }
            }

        }
    }
}
