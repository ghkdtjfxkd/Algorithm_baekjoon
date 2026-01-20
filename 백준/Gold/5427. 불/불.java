import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int te = Integer.parseInt(br.readLine());

        for (int t = 0; t < te; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] building = new char[h][w];
            int[][] fTime = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            Queue<int[]> fq = new LinkedList<>();
            Queue<int[]> sq = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    building[i][j] = c;
                    fTime[i][j] = -1;
                    if(c == '*') {
                        fTime[i][j] = 0;
                        fq.offer(new int[]{i, j});
                    }
                    if(c == '@') {
                        sq.offer(new int[] {i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }

            while (!fq.isEmpty()) {
                int[] cur = fq.poll();
                int r = cur[0];
                int c = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dx[j];
                    int nc = c + dy[j];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                    if (building[nr][nc] != '#' &&  fTime[nr][nc] == -1) {
                        fTime[nr][nc] = fTime[r][c] + 1;
                        fq.offer(new int[]{nr, nc});
                    }
                }
            }
            boolean exit = false;
            int exitTime = 0;
            while (!sq.isEmpty()) {
                int[] cur = sq.poll();
                int r = cur[0];
                int c = cur[1];
                int time = cur[2];

                if (r == 0 || c == 0 || r == h - 1 || c == w - 1) {
                    exitTime = time + 1;
                    exit = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nr = r + dx[j];
                    int nc = c + dy[j];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                    if (building[nr][nc] == '#' || visited[nr][nc]) continue;

                    if (fTime[nr][nc] == -1 || fTime[nr][nc] > time + 1) {
                        visited[nr][nc] = true;
                        sq.offer(new int[]{nr, nc, time + 1});
                    }
                }
            }

            if(exit) {
                System.out.println(exitTime);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}

