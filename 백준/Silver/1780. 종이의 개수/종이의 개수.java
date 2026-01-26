import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] paper;
    static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(0,0, n);

        System.out.println(counts[0]);
        System.out.println(counts[1]);
        System.out.println(counts[2]);

    }

    static void countPaper(int r, int c, int len) {
        if (allSame(r, c, len)) {
            counts[paper[r][c] + 1]++;
            return;
        }

        int newLen = len / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(r + newLen * i, c + newLen * j, newLen);
            }
        }
    }

    static boolean allSame(int r, int c, int len) {
        int checking = paper[r][c];

        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if(paper[i][j] != checking) {
                    return false;
                }
            }
        }
        return true;
    }
}
