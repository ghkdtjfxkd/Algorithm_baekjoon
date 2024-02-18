import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] counter = new int[10000];
        int maxNum = -1;

        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            counter[input-1]++;
            if(input >= maxNum){
                maxNum = input;
            }
        }

        for (int i = 0; i < maxNum; i++) {
            for (int j = 0; j < counter[i]; j++) {
                sb.append(i+1);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}