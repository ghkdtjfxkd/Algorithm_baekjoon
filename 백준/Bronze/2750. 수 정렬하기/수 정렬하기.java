import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            numList.add(input);
        }
       numList.stream().sorted().forEach(System.out::println);
    }
}