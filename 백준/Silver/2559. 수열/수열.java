import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private static Integer[] tmpArr;

    private static Integer[] sArr;
    private static HashSet<Integer> diffArr = new HashSet<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tmpArr = new Integer[n];
        sArr = new Integer[n+1];
        int diffSum = 0;
        st = new StringTokenizer(br.readLine());
        tmpArr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n ; i++) {
            tmpArr[i] = Integer.parseInt(st.nextToken());
        }
        sArr[0] = 0;
        for (int i = 1; i < n +1; i++) {
            sArr[i] = sArr[i-1] + tmpArr[i-1];
        }
        for (int i = 0; i <= n - k; i++) {
            diffArr.add(sArr[i + k] - sArr[i]);
        }
        System.out.println(diffArr.stream().mapToInt(num->num).max().getAsInt());
    }
}
