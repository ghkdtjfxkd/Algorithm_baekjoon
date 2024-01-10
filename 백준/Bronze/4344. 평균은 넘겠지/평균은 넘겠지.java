import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class  Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int testCaseC = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseC; i++) {

            String input = br.readLine();

            List<String> inputList = new ArrayList<>(List.of(input.trim().split(" ")));
            List<Integer> stdList = inputList.stream().map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> pointList = stdList.stream().skip(1).collect(Collectors.toList());

            int stdNum = stdList.get(0);
            double total = 0;


            total = pointList.stream().mapToInt(n -> n).sum();

            double stdAvg =  total / stdNum;

            double overCount = pointList.stream().filter(n -> n > stdAvg)
                    .count();


            bw.write(String.format("%.3f%%\n",(overCount /stdNum) * 100));
            bw.flush();
        }
    }
}