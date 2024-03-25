import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Integer[] iArr;

    private static Integer[] sArr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        iArr = new Integer[n];
        sArr = new Integer[n+1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            iArr[i] = Integer.parseInt(input[i]) ;
        }

        sArr[0] = 0;
        for (int i = 1; i < n + 1 ; i++) {
            sArr[i] = sArr[i-1] + iArr[i-1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

           bw.write(String.valueOf(sArr[end] - sArr[start-1]) + "\n");
        }
        bw.flush();
    }
}