import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] nums = new int[5];
        int sum= 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        for (int num : nums) {
            sum += (int) Math.pow(num,2);
        }
        System.out.println(sum%10);
    }
}
