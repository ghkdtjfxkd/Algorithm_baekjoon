import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] img;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        img = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                img[i][j] = Integer.parseInt(s.charAt(j)+ "");
            }
        }
        System.out.println(quadTree(0, 0, n));
    }

    static String quadTree(int r, int c, int len) {
        if (allSame(r, c, len)) {
            return String.format("%d", img[r][c]);
        }

        int newLen = len / 2;
        StringBuilder ans = new StringBuilder("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans.append(quadTree(r + newLen * i, c + newLen * j, newLen));
            }
        }
        return ans + ")";
    }

    static boolean allSame(int r, int c, int len) {
        int checking = img[r][c];

        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if(img[i][j] != checking) {
                    return false;
                }
            }
        }
        return true;
    }
}
