import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, n) - 1).append(System.lineSeparator());

        hanoi(n, 1, 2, 3);
        System.out.println(sb.toString());
    }

    static void hanoi(int count, int start, int mid, int to) {
        if (count == 1) {
            sb.append(start).append(" ").append(to).append(System.lineSeparator());
            return;
        }

        hanoi(count - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append(System.lineSeparator());
        hanoi(count - 1, mid, start, to);
    }
}
