import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0};
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            if(start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }

            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            visited[start[0]][start[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int count = cur[2];

                if(r == end[0] && c == end[1]) {
                    System.out.println(count);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nr = r + dx[j];
                    int nc = c + dy[j];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, count + 1});
                    }
                }
            }
        }
    }
}

