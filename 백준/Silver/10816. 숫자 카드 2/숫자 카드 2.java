import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            card[i] = input;
        }

        int m = Integer.parseInt(br.readLine());
        int[] test = new int[m];
        LinkedHashMap<Integer, Integer> newCard = new LinkedHashMap<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            test[i] = input;
            newCard.put(input, 0);
        }

        for (int i = 0; i < n; i++) {
            if (newCard.containsKey(card[i])) {
                newCard.replace(card[i], newCard.get(card[i]) + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            sb.append(newCard.get(test[i])).append(" ");
        }
        System.out.println(sb);
    }
}