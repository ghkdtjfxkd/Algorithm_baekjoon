import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;
    private static int[] baskets;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        baskets = new int[n];

        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            changeOrder(start, end);
        }

        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }

        System.out.println(sb);
    }

    static void changeOrder(int start, int end) {
        int s = start-1;
        int[] reverseArr = new int[end - start +1];

        for (int i = end - start ; i >= 0; i--) {
           reverseArr[i] = baskets[s++];
        }

        for (int i = 0; i <= end- start; i++) {
            baskets[i+start-1] = reverseArr[i];
        }
    }
}