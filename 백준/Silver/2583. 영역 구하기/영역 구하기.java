import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] rec = new int[h][w];
        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int l = lx; l < rx ; l++) {
                    rec[j][l] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(!visited[i][j] && rec[i][j] == 0) {
                    count++;
                    dfs(i, j, rec, visited);
                }
            }
        }
        System.out.println(count);

        visited = new boolean[h][w];
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && rec[i][j] == 0) {
                    f.add(bfs(i, j, rec, visited));
                }
            }
        }

        Stream<Integer> sorted = f.stream().sorted();

        sorted.forEach(s -> System.out.print(s + " "));
    }

    static int bfs(int row, int col, int[][] rec, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row,col});
        visited[row][col] = true;

        int ct = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr < 0 || nc < 0 || nr >= rec.length || nc >= rec[0].length) continue;
                if(!visited[nr][nc] && rec[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    ct++;
                }
            }
        }

        return ct;
    }

    static void dfs(int r, int c, int[][] rec, boolean[][] visited) {
        if(r < 0 || c < 0 || r >= rec.length || c >= rec[0].length) return;

        if(visited[r][c] || rec[r][c] == 1) return;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            dfs(r + dx[i] , c+ dy[i] , rec, visited);
        }
    }
}

