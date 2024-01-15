import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        List<String> numList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numList.add(br.readLine());
        }

        List<Integer> sortedList = numList.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());

        for (int s : sortedList) {
            sb.append(s).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}