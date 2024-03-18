import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt( br.readLine());
        }
        System.out.println(Arrays.stream(nums).sum()/5);
        nums = Arrays.stream(nums).sorted().toArray();
        System.out.println(nums[2]);
    }
}