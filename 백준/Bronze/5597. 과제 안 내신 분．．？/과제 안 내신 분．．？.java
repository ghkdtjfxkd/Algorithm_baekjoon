import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        boolean[] submitted = new boolean[30];
        int stdCount = 0;

        for (int i = 0; i < 28; i++) {
            int input = Integer.parseInt(br.readLine());
            submitted[input - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!submitted[i]) {
                System.out.println(i + 1);
                stdCount++;
                continue;
            }
            if (stdCount == 1 && !submitted[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}