import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] farm;

    private static boolean[][] visitedCheck;
    private static int m;
    private static int n;
    private static int k;
    private static int EMPTY = 0;
    private static int tmp = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            farm = new int[n][m];
            visitedCheck = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                farm[r][c] = -1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(!visitedCheck[j][l] && farm[j][l] == -1){
                        tmp++;
                        checkAnother(j, l);
                    }
                }
            }
            System.out.println(tmp);
            tmp= 0;
        }
    }

    private static boolean outOfFarm(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }

    private static boolean vacantSpace(int r, int c) {
        return farm[r][c] == EMPTY;
    }

    private static boolean reachingGoal(int r, int c) {
        return r == n - 1 && c == m - 1;
    }

    private static void checkAnother(int r, int c) {
        if (!outOfFarm(r, c)) {
             if (!vacantSpace(r, c)) {
                if (!visitedCheck[r][c]) {
                    visitedCheck[r][c] = true;
                    farm[r][c] = tmp;
                    checkAnother(r + 1, c);
                    checkAnother(r - 1, c);
                    checkAnother(r, c - 1);
                    checkAnother(r, c + 1);
                }
            }
        }
    }
}