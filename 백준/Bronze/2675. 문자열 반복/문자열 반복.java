import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count =Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            String[] inputArr = input.split(" ");

            int repeats = Integer.parseInt(inputArr[0]);

            String repeatStr = inputArr[1];
            String[] repeatStrSplit = repeatStr.split("");

            String p = "a";
            StringBuilder stringBuilder = new StringBuilder(p);

            for (String s : repeatStrSplit) {
                for (int j = 0; j < repeats; j++) {
                    stringBuilder.append(s);
                }
            }
            stringBuilder.delete(0, 1);
            System.out.println(stringBuilder);
        }
    }
}