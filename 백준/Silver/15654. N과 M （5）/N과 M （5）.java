import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m = 0;

    static int[] nums;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        bt(0, new int[m]);
        bw.flush();
    }

    static void bt (int idx,  int[] arr) throws IOException {
        if(arr[m-1] != 0) {
            for (int i : arr) {
                bw.write(i+ " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (Arrays.stream(arr).anyMatch(n -> n == num)) continue;
            
            int[] copy = arr.clone();
            copy[idx] = nums[i];
            bt(idx + 1 , copy);
        }
    }
}
