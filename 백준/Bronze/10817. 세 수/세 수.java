import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        int third = Integer.parseInt(input[2]);

        List<Integer> nums = new ArrayList<>();
        nums.add(first);
        nums.add(second);
        nums.add(third);

        nums = nums.stream().sorted().collect(Collectors.toList());

        System.out.println(nums.get(1));
    }
}