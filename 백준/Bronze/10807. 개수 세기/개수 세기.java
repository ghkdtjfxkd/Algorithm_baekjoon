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

        int n = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        String[] inputNums = br.readLine().split(" ");
        for (String inputNum : inputNums) {
            nums.add(Integer.parseInt(inputNum));
        }

        int findNum =Integer.parseInt(br.readLine());

        bw.write(String.valueOf((int) nums.stream().filter(x -> x == findNum).count()));
        bw.flush();
    }
}