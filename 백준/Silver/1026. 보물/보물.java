import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Integer[] aArr;
    private static Integer[] bArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        aArr = new Integer[n];
        bArr = new Integer[n];

        putArr(br.readLine(),aArr);
        putArr(br.readLine(),bArr);

        Arrays.sort(aArr);
        Arrays.sort(bArr, Collections.reverseOrder());

        System.out.println(cal(aArr,bArr));
    }

    static void putArr (String s, Integer[] arrInt){
        String[] input = s.split(" ");
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i]= Integer.parseInt(input[i]);
        }
    }

    static int cal (Integer[] a, Integer[]b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}