import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(block(r, c, (int) Math.pow(2, n)));
    }

    static int block(int r, int c, int sq) {

        if (sq == 1) return 0;

        int half = sq / 2;
        int smallSq = half * half;

        if (r < half && c < half) {
            return block(r, c, half);
        } else if (r < half && c >= half) {
            return smallSq + block(r, c - half, half);
        } else if (r >= half && c < half) {
            return smallSq * 2 + block(r - half, c, half);
        } else {
            return smallSq * 3 + block(r - half, c - half, half);
        }
    }
}
