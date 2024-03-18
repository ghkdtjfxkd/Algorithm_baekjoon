import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("");

        Arrays.sort(input, Collections.reverseOrder());
        Arrays.stream(input).forEach(sb::append);
        System.out.println(sb);
    }
}