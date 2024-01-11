import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] strList = br.readLine().split(" ");

            for (String s : strList) {
                StringBuilder sb = new StringBuilder(s);
                System.out.print(sb.reverse() + " ");
            }
        }
    }
}