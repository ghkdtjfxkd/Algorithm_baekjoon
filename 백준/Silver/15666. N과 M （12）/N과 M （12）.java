import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder sb;
    static Set<String> strSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stt.nextToken());
        m = Integer.parseInt(stt.nextToken());

        nums = new int[n];
        stt = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(stt.nextToken());

        Arrays.sort(nums);

        sb = new StringBuilder();
        strSet = new LinkedHashSet<>();
        for(int i = 0; i < n; i++) {
            String cur = String.valueOf(nums[i]);
            backTracking(m -1, i, cur);
        }

        for(String l : strSet) sb.append(l).append('\n');
        
        System.out.print(sb);

    }

    static void backTracking(int left, int curIdx, String prev) {
        if(left == 0) {
            strSet.add(prev);
            return;
        }

        for(int i = curIdx; i < n; i++) {
            String nxt = prev + " " + nums[i];
            backTracking(left -1, i, nxt);
        }
    }
}
