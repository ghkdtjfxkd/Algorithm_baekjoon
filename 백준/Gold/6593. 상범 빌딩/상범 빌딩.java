import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] df = {-1, 0, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String coor = br.readLine();
        while(!coor.equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(coor);
            int f = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][][] building = new char[f][r][c];
            boolean[][][] visited = new boolean[f][r][c];
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char ch = s.charAt(k);
                        building[i][j][k] = ch;
                        if (ch == 'S') {
                            q.offer(new int[]{i, j, k, 0});
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            int time = -1;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int d = cur[0];
                int cr = cur[1];
                int cc = cur[2];
                int t = cur[3];

                if(building[d][cr][cc] == 'E') {
                    time = t;
                    break;
                }

                for (int i = 0; i < 3; i++) {
                    int nd = d + df[i];

                    if(nd < 0 || nd >= f) continue;
                    if(nd != d) {
                        if(!visited[nd][cr][cc] && building[nd][cr][cc] != '#') {
                            q.offer(new int[]{nd, cr, cc, t + 1});
                            visited[nd][cr][cc] = true;
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            int nr = cr + dx[j];
                            int nc = cc + dy[j];

                            if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                            if(!visited[d][nr][nc] && building[d][nr][nc] != '#') {
                                visited[d][nr][nc] = true;
                                q.offer(new int[] {nd, nr, nc, t + 1});
                            }
                        }
                    }
                }
            }

            if(time != -1) {
                System.out.printf("Escaped in %d minute(s)." + System.lineSeparator(), time);
            } else {
                System.out.println("Trapped!");
            }

            coor = br.readLine();
        }



    }
}
