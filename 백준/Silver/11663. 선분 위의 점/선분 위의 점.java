import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Long> numbers;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Long.parseLong(st.nextToken()));
        }
        
        Collections.sort(numbers);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            long startValue = Long.parseLong(st.nextToken());
            long endValue = Long.parseLong(st.nextToken());

            int startIndex = lowerBound(numbers, startValue);
            int endIndex = upperBound(numbers, endValue);

            bw.write((endIndex - startIndex) + System.lineSeparator());
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int lowerBound(List<Long> list, long target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private static int upperBound(List<Long> list, long target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}