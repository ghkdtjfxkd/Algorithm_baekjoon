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
        String input = br.readLine();

        StringBuilder sb = new StringBuilder(input);
        String reInput = String.valueOf(sb.reverse());

        String[] reNums = reInput.split(" ");
        List<Integer> nums = new ArrayList<>();

        nums.add(Integer.parseInt(reNums[0]));
        nums.add(Integer.parseInt(reNums[1]));
        int max = Integer.parseInt(reNums[0]);

        for (Integer num : nums) {
            if(num> max){
                max = num;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}