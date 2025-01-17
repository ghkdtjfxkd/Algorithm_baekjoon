import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] liquidShelf = new long[n];
        for (int i = 0; i < n; i++) {
            liquidShelf[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(liquidShelf);

        int left = 0;
        int right = n - 1;
        long minDiff = Long.MAX_VALUE;
        long result1 = 0, result2 = 0;

        while (left < right) {
            long sum = liquidShelf[left] + liquidShelf[right];

            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                result1 = liquidShelf[left];
                result2 = liquidShelf[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        bw.write(result1 + " " + result2);
        bw.flush();
        bw.close();
        br.close();
    }
}